package es.uah.grupo2.gestioncine.app.controllers.adminops;

import java.io.*;

import es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Actor;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "CrearPelicula", urlPatterns = {"/crearPelicula"})
public class CrearPeliculaController extends AdminOperationServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        List<String> generos = Arrays.asList(
                "Drama", "Ciencia ficción", "Acción", "Crimen", "Comedia", "Aventura", "Documental"
        );

        request.setAttribute("generos", generos);
        request.getRequestDispatcher(request.getContextPath() + "/crear-pelicula.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        // Obtenemos la sesion
        HttpSession session = request.getSession(false);
        request.setCharacterEncoding("UTF-8");


        // Obtenemos todos los parametros del formulario
        String nombre = request.getParameter("nombre");
        String sinopsis = request.getParameter("sinopsis");
        String pagina = request.getParameter("pagina");
        String titulo = request.getParameter("titulo");
        String genero = request.getParameter("genero");
        String nacionalidad = request.getParameter("nacionalidad");
        int duracion = Integer.parseInt(request.getParameter("duracion").trim());
        int ano = Integer.parseInt(request.getParameter("ano").trim());
        String distribuidora = request.getParameter("distribuidora");
        String director = request.getParameter("director");
        String otros = request.getParameter("otros");
        String clasificacion = request.getParameter("clasificacion");
        String portada = request.getParameter("portada");
        String[] actores = request.getParameterValues("actores");

        List<Actor> actoresList = new ArrayList<>();

        for (String s : actores) {
            actoresList.add(new Actor(Integer.parseInt(s)));
        }

        Pelicula pelicula = new Pelicula(
                -1, nombre, sinopsis, pagina, titulo, genero, nacionalidad, duracion,
                ano, distribuidora, director, otros, clasificacion, portada, actoresList
        );

        try {
            // insertamos la pelicula y obtenemos si se ha hecho correctamente
            PeliculaDAO.insertarPelicula(pelicula);
            session.setAttribute("success", "Se ha creado correctamente la pelicula");

            // Redireccionar de vuelta a la lista de salas
            response.sendRedirect(request.getContextPath() + "/gestionPeliculas");

        } catch (Exception e) {
            session.setAttribute("error", "Se ha producido un error al insertar la pelicula");
            response.sendRedirect(request.getContextPath() + "/crearPelicula");
            e.printStackTrace();
        }
    }
}
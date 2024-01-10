package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.dao.ActorDAO;
import es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Actor;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "EditarPelicula", urlPatterns = {"/editarPelicula/*"})
public class EditarPeliculaController extends AdminOperationServlet {
    private PeliculaDAO peliculaDAO;
    private ActorDAO actorDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        peliculaDAO = new PeliculaDAO(conn);
        actorDAO = new ActorDAO(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        HttpSession session = request.getSession(false);
        request.setCharacterEncoding("UTF-8");

        // Obtenemos el id de la pelicula dada por la ruta
        String rutaCompleta = request.getPathInfo();
        String[] partesRuta = rutaCompleta.split("/");
        String value = partesRuta[1]; // nos quedamos con el valor obtenido
        int idPelicula = Integer.parseInt(value);

        try {
            // Validamos la pelicula
            if (peliculaDAO.validarId(idPelicula)) {
                // Obtenemos la pelicula de la base de datos
                Pelicula pelicula = peliculaDAO.obtenerPelicula(idPelicula);

                // Listado de los generos posibles de la pelicula
                List<String> generos = Arrays.asList(
                        "Drama", "Ciencia ficción", "Acción", "Crimen", "Comedia", "Aventura", "Documental"
                );

                List<Actor> actores = actorDAO.obtenerActores();

                request.setAttribute("pelicula", pelicula);
                request.setAttribute("generos", generos);
                request.setAttribute("actores", actores);

                request.getRequestDispatcher(request.getContextPath() + "/editar-pelicula.jsp").forward(request, response);
            } else {
                session.setAttribute("error", "No se ha podido acceder a la pelicula");
                response.sendRedirect(request.getContextPath() + "/gestionPeliculas");
            }
        } catch (SQLException e) {
            session.setAttribute("error", "Hubo un error al validar el id");
            response.sendRedirect(request.getContextPath() + "/gestionPeliculas");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        HttpSession session = request.getSession(false);
        request.setCharacterEncoding("UTF-8");

        // Obtener los datos del formulario
        int id = Integer.parseInt(request.getParameter("id"));
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

        for (String s: actores){
            actoresList.add(new Actor(Integer.parseInt(s)));
        }

        Pelicula pelicula = new Pelicula(
                id, nombre, sinopsis, pagina, titulo, genero, nacionalidad, duracion,
                ano, distribuidora, director, otros, clasificacion, portada, actoresList
        );

        try {
            // Actualizamos la pelicula
            peliculaDAO.update(pelicula);

            // Redireccionamos a la pagina de gestion de peliculas con un mensaje de exito
            session.setAttribute("success", "Se ha editado correctamente la pelicula");
            response.sendRedirect(request.getContextPath() + "/gestionPeliculas");

        } catch (SQLException e) {
            session.setAttribute("error", "Se ha producido un error actualizar la pelicula");
            response.sendRedirect(request.getContextPath() + "/editarPelicula/" + id);

            e.printStackTrace();
        }
    }
}

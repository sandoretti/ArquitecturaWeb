package es.uah.grupo2.gestioncine.app.controllers;

import java.io.*;

import es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Actor;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CrearPelicula", urlPatterns = {"/crearPelicula"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class CrearPeliculaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearPelicula</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearPelicula at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Verificamos si existe session
        if (session != null) {
            Cliente cliente = (Cliente) session.getAttribute("usuario");    // Obtenemos el atributo cliente

            // Si existe cliente y el cliente es administrador
            if (cliente != null && cliente.isAdmin()) {
                request.getRequestDispatcher(request.getContextPath() + "/crear-pelicula.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtenemos la sesion
        HttpSession session = request.getSession(false);

        if (session != null) {
            Cliente cliente = (Cliente) session.getAttribute("usuario");

            if (cliente != null && cliente.isAdmin()) {

                // Obtenemos todos los parametros del formulario
                String nombre = request.getParameter("nombre").trim();
                String sinopsis = request.getParameter("sinopsis").trim();
                String pagina = request.getParameter("pagina").trim();
                String titulo = request.getParameter("titulo").trim();
                String genero = request.getParameter("genero").trim();
                String nacionalidad = request.getParameter("nacionalidad").trim();
                int duracion = Integer.parseInt(request.getParameter("duracion").trim());
                int ano = Integer.parseInt(request.getParameter("ano").trim());
                String distribuidora = request.getParameter("distribuidora").trim();
                String director = request.getParameter("director").trim();
                String otros = request.getParameter("otros").trim();
                String clasificacion = request.getParameter("clasificacion").trim();
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

                } catch (SQLException | FileNotFoundException e) {
                    session.setAttribute("error", "Se ha producido un error al insertar la pelicula");
                    response.sendRedirect(request.getContextPath() + "/crearPelicula");
                    e.printStackTrace();
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
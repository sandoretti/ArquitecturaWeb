package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EditarPelicula", urlPatterns = {"/editarPelicula/*"})
public class EditarPeliculaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EliminarPelicula</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarPelicula at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Verificamos si existe session
        if (session != null) {
            Cliente cliente = (Cliente) session.getAttribute("usuario"); // Obtenemos el atributo cliente

            // Si existe cliente y el cliente es administrador
            if (cliente != null && cliente.isAdmin()) {
                String rutaCompleta = request.getPathInfo();
                String[] partesRuta = rutaCompleta.split("/");
                String value = partesRuta[1]; // nos quedamos con el valor obtenido

                int idPelicula = Integer.parseInt(value);

                if (PeliculaDAO.validarId(idPelicula)) {
                    Pelicula pelicula = PeliculaDAO.obtenerPelicula(idPelicula);

                    request.setAttribute("pelicula", pelicula);
                    request.getRequestDispatcher(request.getContextPath() + "/editar-pelicula.jsp").forward(request, response);
                } else {
                    session.setAttribute("error", "No se ha podido acceder a la pelicula");
                    response.sendRedirect(request.getContextPath() + "/gestionPeliculas");
                }


            } else {
                session.setAttribute("error", "No puede acceder a esta pagina");
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null) {
            Cliente cliente = (Cliente) session.getAttribute("usuario");

            if (cliente != null && cliente.isAdmin()) {
                // Obtener los datos del formulario
                int id = Integer.parseInt(request.getParameter("id"));
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
                String[] actores = request.getParameterValues("actores");

                List<Actor> actoresList = new ArrayList<>();

                for (String s: actores){
                    actoresList.add(new Actor(Integer.parseInt(s)));
                }

                Pelicula pelicula = new Pelicula(
                        id, nombre, sinopsis, pagina, titulo, genero, nacionalidad, duracion,
                        ano, distribuidora, director, otros, clasificacion, "", actoresList
                );

                try {
                    // Actualizamos la pelicula
                    PeliculaDAO.update(pelicula);

                    // Redireccionamos a la pagina de gestion de peliculas con un mensaje de exito
                    session.setAttribute("success", "Se ha editado correctamente la pelicula");
                    response.sendRedirect(request.getContextPath() + "/gestionPeliculas");
                } catch (SQLException e) {
                    session.setAttribute("error", "Se ha producido un error actualizar la pelicula");
                    response.sendRedirect(request.getContextPath() + "/editarPelicula/" + id);

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

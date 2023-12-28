package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.ActorDAO;
import es.uah.grupo2.gestioncine.app.model.Cliente;

import java.io.*;

import es.uah.grupo2.gestioncine.app.model.PeliculaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

@WebServlet(name = "CrearPelicula", urlPatterns = {"/crear-pelicula"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class CrearPeliculaController extends HttpServlet {
    final String RUTA_UPLOAD = "C://uploads//";

    Logger logger = Logger.getLogger(getClass().getName());

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
                response.sendRedirect(request.getContextPath() + "/crear-pelicula.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/index");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/index");
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
        Part portadaPart = request.getPart("portada");
        String[] actores = request.getParameterValues("actores");

        // De la imagen obtenemos el nombre del archivo
        String portada = portadaPart.getSubmittedFileName();

        // Obtenemos la sesion
        HttpSession session = request.getSession(false);

        // insertamos la pelicula y obtenemos si se ha hecho correctamente
        boolean insertarPelicula = PeliculaDAO.insertarPelicula(
                nombre, sinopsis, pagina, titulo, genero, nacionalidad, duracion, ano,
                distribuidora, director, otros, clasificacion, portada
        );

        // Si se ha insertado
        if (insertarPelicula) {
            // Establecemos la ruta del archivo
            Path rootPath = Paths.get( RUTA_UPLOAD + portada);

            // Insertamos la imagen en RuTA_UPLOAD
            Files.copy(portadaPart.getInputStream(), rootPath);

            // Obtenemos la id de la pelicula insertada
            int idPelicula = PeliculaDAO.obtenerId(nombre);

            // Si el id es valido
            if (idPelicula > 0) {
                // Insertamos a la tabla PELICULA_ACTOR los actores asociados a la pelicula
                boolean actoresAnnadidos = ActorDAO.annadirActoresPelicula(actores, idPelicula);

                // Si se han insertado correctamente
                if (actoresAnnadidos) {
                    session.setAttribute("success", "Se ha creado correctamente la pelicula");
                    response.sendRedirect(request.getContextPath() + "/gest-peliculas");
                } else {
                    session.setAttribute("error", "Se ha producido un error al anadir los actores");
                    response.sendRedirect(request.getContextPath() + "/crear-pelicula");
                }

            } else {
                session.setAttribute("error", "Se ha producido un error al obtener la pelicula");
                response.sendRedirect(request.getContextPath() + "/crear-pelicula");
            }
        } else {
            session.setAttribute("error", "Se ha producido un error al insertar la pelicula");
            response.sendRedirect(request.getContextPath() + "/crear-pelicula");
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
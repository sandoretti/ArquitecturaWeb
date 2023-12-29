package es.uah.grupo2.gestioncine.app.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import es.uah.grupo2.gestioncine.app.model.Cliente;
import es.uah.grupo2.gestioncine.app.model.PeliculaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "EliminarPelicula", urlPatterns = {"/eliminarPelicula/*"})
public class EliminarPeliculaController extends HttpServlet {

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
            Cliente cliente = (Cliente) session.getAttribute("usuario");    // Obtenemos el atributo cliente

            // Si existe cliente y el cliente es administrador
            if (cliente != null && cliente.isAdmin()) {
                String rutaCompleta = request.getPathInfo();
                String[] partesRuta = rutaCompleta.split("/");
                String value = partesRuta[1]; // nos quedamos con el valor obtenido

                int idPelicula = Integer.parseInt(value);

                if (PeliculaDAO.validarId(idPelicula) && PeliculaDAO.eliminarPeliculaId(idPelicula)) {
                    session.setAttribute("success", "Se ha eliminado correctamente la pelicula");
                    response.sendRedirect(request.getContextPath() + "/gestionPeliculas");
                } else {
                    session.setAttribute("error", "No se ha podido eliminar la pelicula");
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
        doGet(request, response);
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

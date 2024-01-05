package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.dao.SalaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;

/**
 *
 * @author serchio
 */
@WebServlet(name = "EliminarSalaController", urlPatterns = {"/eliminarSala/*"})
public class EliminarSalaController extends HttpServlet {

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
            out.println("<title>Servlet EliminarSalaController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarSalaController at " + request.getContextPath() + "</h1>");
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

        if (session != null) {
            Cliente cliente = (Cliente) session.getAttribute("usuario");    // Obtenemos el atributo cliente

            // Si existe cliente y el cliente es administrador
            if (cliente != null && cliente.isAdmin()) {

                // Extrayendo el ID de la sala de la URL
                String pathInfo = request.getPathInfo(); // Esto debería dar algo como "/123" si la URL es /eliminarSala/123
                if (pathInfo == null || pathInfo.equals("/")) {
                    // Manejar el caso de no tener ID en la URL
                    response.sendRedirect(request.getContextPath() + "/gestionSalas"); // Redirigir a la lista de salas o a una página de error
                    return;
                }
                String[] splits = pathInfo.split("/");
                if (splits.length != 2) {
                    // Manejar el caso de una URL mal formada
                    response.sendRedirect(request.getContextPath() + "/gestionSalas");
                    return;
                }

                int salaId;
                try {
                    salaId = Integer.parseInt(splits[1]);
                } catch (NumberFormatException e) {
                    // Manejar el caso de un ID no numérico
                    response.sendRedirect(request.getContextPath() + "/gestionSalas");
                    return;
                }

                // Proceder con la eliminación
                SalaDAO salita = new SalaDAO();
                Connection conn = salita.getConnection();
                boolean eliminado = salita.eliminarSala(conn, salaId);
                if (eliminado) {
                    session.setAttribute("success", "Se ha eliminado correctamente la sala");
                    // La sala se eliminó correctamente
                } else {
                    session.setAttribute("error", "Se ha producido un error al insertar la sala");
                    // Hubo un problema al eliminar la sala
                }
                response.sendRedirect(request.getContextPath() + "/gestionSalas");

            } else {
                request.getRequestDispatcher(request.getContextPath() + "/login").forward(request, response);
            }
        } else {
            request.getRequestDispatcher(request.getContextPath() + "/login").forward(request, response);
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
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

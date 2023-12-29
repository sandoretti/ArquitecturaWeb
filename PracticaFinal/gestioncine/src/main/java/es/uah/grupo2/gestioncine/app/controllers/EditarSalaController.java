package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.Cliente;
import es.uah.grupo2.gestioncine.app.model.Sala;
import es.uah.grupo2.gestioncine.app.model.SalaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author serchio
 */
@WebServlet(name = "EditarSalaController", urlPatterns = {"/editarSala/*"})
public class EditarSalaController extends HttpServlet {

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
            out.println("<title>Servlet EditarSalaController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditarSalaController at " + request.getContextPath() + "</h1>");
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
            Cliente cliente = (Cliente) session.getAttribute("usuario");

            if (cliente != null && cliente.isAdmin()) {
                String pathInfo = request.getPathInfo();
                if (pathInfo == null || pathInfo.equals("/")) {
                    response.sendRedirect(request.getContextPath() + "/gestionSalas");
                    return;
                }

                String[] splits = pathInfo.split("/");
                if (splits.length != 2) {
                    response.sendRedirect(request.getContextPath() + "/gestionSalas");
                    return;
                }

                int salaId;
                try {
                    salaId = Integer.parseInt(splits[1]);
                } catch (NumberFormatException e) {
                    response.sendRedirect(request.getContextPath() + "/gestionSalas");
                    return;
                }

                // Obtener detalles de la sala para editar
                SalaDAO salaDAO = new SalaDAO();
                Connection conn = salaDAO.getConnection();
                try {
                    Sala sala = salaDAO.obtenerSalaPorId(conn, salaId);
                    if (sala != null) {
                        request.setAttribute("sala", sala);
                        request.getRequestDispatcher(request.getContextPath() + "/editarSala.jsp").forward(request, response);
                    } else {
                        session.setAttribute("error", "Sala no encontrada");
                        response.sendRedirect(request.getContextPath() + "/gestionSalas");
                    }
                } finally {
                    try {
                        conn.close(); // Asegúrese de cerrar la conexión
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

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

        HttpSession session = request.getSession(false);

        if (session != null) {
            Cliente cliente = (Cliente) session.getAttribute("usuario");

            if (cliente != null && cliente.isAdmin()) {
                // Obtener los datos del formulario
                int id = Integer.parseInt(request.getParameter("id"));
                String nombreSala = request.getParameter("nombre_sala");
                int filas = Integer.parseInt(request.getParameter("filas"));
                int columnas = Integer.parseInt(request.getParameter("columnas"));

                Sala sala = new Sala(id, nombreSala, filas, columnas);

                // Actualizar la sala en la base de datos
                SalaDAO salaDAO = new SalaDAO();
                try (Connection conn = salaDAO.getConnection()) {
                    boolean actualizado = salaDAO.actualizarSala(conn, sala);
                    if (actualizado) {
                        session.setAttribute("success", "Sala actualizada correctamente.");
                    } else {
                        session.setAttribute("error", "Error al actualizar la sala.");
                    }
                } catch (SQLException e) {
                    // Manejar la excepción
                    session.setAttribute("error", "Error de base de datos.");
                }

                // Redireccionar de vuelta a la lista de salas
                response.sendRedirect(request.getContextPath() + "/gestionSalas");
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
    }// </editor-fold>

}

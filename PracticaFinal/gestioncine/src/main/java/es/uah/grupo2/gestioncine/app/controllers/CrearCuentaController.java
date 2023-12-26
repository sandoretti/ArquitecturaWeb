package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.Cliente;
import es.uah.grupo2.gestioncine.app.model.ClienteDAO;
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
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CrearCuentaController", urlPatterns = {"/cuentaNueva"})
public class CrearCuentaController extends HttpServlet {

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
            out.println("<title>Servlet CrearCuentaController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearCuentaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        HttpSession session = request.getSession();
        if (null != (Cliente) session.getAttribute("usuario")) {
            response.sendRedirect(request.getContextPath() + "/perfil");
        } else {
            request.getRequestDispatcher("/crearCuenta.jsp").forward(request, response);
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
        String nombre = request.getParameter("nombre").trim();
        String apellido = request.getParameter("apellido").trim();
        String email = request.getParameter("email").trim();
        String passwd = request.getParameter("passwd").trim();
        Timestamp ahora = new Timestamp(System.currentTimeMillis());

        Cliente nuevoCliente = new Cliente(0, nombre, apellido, email, passwd, ahora, false);
        ClienteDAO dao = new ClienteDAO();

        try (Connection conn = dao.getConnection()) {
            boolean insertado = dao.IngresarUsuario(conn, nuevoCliente);
            if (insertado) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", nuevoCliente);
                response.sendRedirect(request.getContextPath() + "/perfil");
            } else {
                request.setAttribute("error", "No se pudo crear el usuario.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            request.setAttribute("error", "Error de base de datos: " + ex.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            Logger.getLogger(CrearCuentaController.class.getName()).log(Level.SEVERE, null, ex);
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

package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;

@WebServlet(name = "SignupController", urlPatterns = {"/signup"})
public class SignupController extends HttpServlet {

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
            out.println("<title>Servlet SignupController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession(false);
        // Verificar si hay un atributo de usuario en la sesión
        if (session != null && session.getAttribute("usuario") != null) {
            Cliente cliente = (Cliente) session.getAttribute("usuario");
            session.setAttribute("usuario", cliente);
            response.sendRedirect(request.getContextPath() + "/perfil");

        } else {
            // No hay usuario logueado, redirigir al login
            response.sendRedirect(request.getContextPath() + "/signup.jsp");
            //request.getRequestDispatcher("/signup.jsp").forward(request, response);
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
        HttpSession session = request.getSession();

        String nombre = request.getParameter("nombre").trim();
        String apellido = request.getParameter("apellido").trim();
        String email = request.getParameter("email").trim();
        String passwd = request.getParameter("passwd").trim();

        ClienteDAO dao = new ClienteDAO();
        Connection conn = dao.getConnection();

        Boolean existeEmail = dao.verificarEmail(conn, email);

        if (existeEmail) {
            conn = dao.getConnection();
            Boolean insertarCliente = dao.insertarCliente(conn, nombre, apellido, email, passwd);

            if (insertarCliente) {
                session.setAttribute("success", "Se ha creado la cuenta correctamente");
                response.sendRedirect(request.getContextPath() + "/login");
            } else {
                session.setAttribute("error", "Se ha producido un error al crear la cuenta");
                response.sendRedirect(request.getContextPath() + "/signup");
            }
        } else {
            session.setAttribute("error", "Email en uso");
            response.sendRedirect(request.getContextPath() + "/signup");
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

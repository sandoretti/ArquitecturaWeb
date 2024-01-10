package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.dao.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;

@WebServlet(name = "SignupController", urlPatterns = {"/signup"})
public class SignupController extends CineServlet {

    private ClienteDAO clienteDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        clienteDAO = new ClienteDAO(conn);
    }

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String nombre = request.getParameter("nombre").trim();
        String apellido = request.getParameter("apellido").trim();
        String email = request.getParameter("email").trim();
        String passwd = request.getParameter("passwd").trim();

        boolean existeEmail = clienteDAO.verificarEmail(email);

        if (existeEmail) {
            boolean insertarCliente = clienteDAO.insertarCliente(nombre, apellido, email, passwd);

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

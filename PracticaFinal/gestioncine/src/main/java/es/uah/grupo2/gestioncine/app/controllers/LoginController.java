package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.dao.ClienteDAO;
import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginController extends CineServlet {
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
        if (session != null && null != session.getAttribute("usuario")) {
            response.sendRedirect(request.getContextPath() + "/perfil");
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email").trim();
        String passwd = request.getParameter("passwd").trim();

        Cliente clienteResultado = clienteDAO.validarUsuario(email, passwd);
        HttpSession session = request.getSession();

        if (clienteResultado != null) {
            session.setAttribute("usuario", clienteResultado);
            response.sendRedirect(request.getContextPath() + "/perfil");
        } else {
            session.setAttribute("error", "Usuario o password no coincide.");
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}

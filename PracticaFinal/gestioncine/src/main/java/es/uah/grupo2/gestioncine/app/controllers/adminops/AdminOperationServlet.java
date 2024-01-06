package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.dao.DatabaseConnection;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;


public abstract class AdminOperationServlet extends HttpServlet {
    public Connection conn;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        conn = DatabaseConnection.getConnection();
    }

    public boolean validarAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return false;
        }

        Cliente cliente = (Cliente) session.getAttribute("usuario"); // Obtenemos el atributo cliente

        // Validamos que el cliente no sea nulo y que sea admin
        return cliente != null && cliente.isAdmin();
    }
}

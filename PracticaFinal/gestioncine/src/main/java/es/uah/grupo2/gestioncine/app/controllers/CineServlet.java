package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.DatabaseConnection;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CineServlet extends HttpServlet {
    protected Connection conn;
    protected Logger logger;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        conn = DatabaseConnection.getConnection();
        logger = Logger.getLogger(getClass().getName());
    }

    @Override
    public void destroy() {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al cerrar la conexion a la base de datos");
        }

    }
}

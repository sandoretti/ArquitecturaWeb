package es.uah.grupo2.gestioncine.app.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static Connection conn = null;
    private static final String URL = "jdbc:derby://localhost:1527/shopmedb";
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    public DatabaseConnection() {
        try {
            // Registra el controlador JDBC de Derby
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            conn = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE, "Error al cargar el controlador JDBC de Derby", e);
        }
    }

    public Connection getConnection()
    {
        return conn;
    }
}

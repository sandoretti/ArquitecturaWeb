package grupo2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    private static final String URL = "jdbc:derby://localhost:1527/cinedb";
    private static final String USUARIO = "admin";
    private static final String CONTRASENA = "admin";
    private static final Logger logger = Logger.getLogger(ConexionBD.class.getName());

    static {
        try {
            // Registra el controlador JDBC de Derby
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Error al cargar el controlador JDBC de Derby", e);
        }
    }

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al cerrar la conexión a la base de datos", e);
            }
        }
    }
}

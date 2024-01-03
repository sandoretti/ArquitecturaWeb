package es.uah.grupo2.gestioncine.app.model.dao;

import es.uah.grupo2.gestioncine.app.model.entity.Sala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalaDAO {

    private Connection conexion;
    private static final Logger logger = Logger.getLogger(EntradaDAO.class.getName());
    
    public SalaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public SalaDAO() {
    }
    

    public Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/shopmedb;create=true");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return c;
    }

    public boolean insertarSala(Connection conn, String nombre, int filas, int columnas) {
        String sql = "INSERT INTO sala (nombre_sala, filas, columnas) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Establecer los valores de los parámetros
            pstmt.setString(1, nombre);
            pstmt.setInt(2, filas);
            pstmt.setInt(3, columnas);

            // Ejecutar la sentencia
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Sala> mostrarSalas(Connection conn) {
        List<Sala> salas = new ArrayList<>();
        String sql = "SELECT * FROM SALA";

        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Sala sala = new Sala(
                        rs.getInt("id"),
                        rs.getString("nombre_sala"),
                        rs.getInt("filas"),
                        rs.getInt("columnas")
                );
                salas.add(sala);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close(); // Asegurarse de cerrar la conexión
                } catch (SQLException e) {
                    e.printStackTrace(); // Manejar la excepción de cierre
                }
            }
        }

        return salas;
    }

    public boolean eliminarSala(Connection conn, int salaId) {
        String sql = "DELETE FROM SALA WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, salaId);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Sala obtenerSalaPorId(Connection conn, int salaId) {
        String sql = "SELECT * FROM sala WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, salaId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Sala(
                            rs.getInt("id"),
                            rs.getString("nombre_sala"),
                            rs.getInt("filas"),
                            rs.getInt("columnas")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Devuelve null si no se encuentra la sala o si hay un error
    }

    public boolean actualizarSala(Connection conn, Sala sala) throws SQLException {
        String sql = "UPDATE sala SET nombre_sala = ?, filas = ?, columnas = ? WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sala.getNombreSala());
            pstmt.setInt(2, sala.getFila());
            pstmt.setInt(3, sala.getColumna());
            pstmt.setInt(4, sala.getId());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        }
    }

    public Sala obtenerSalaPorId(int idPelicula) {
        Sala sala = null;
        String sql = "SELECT * FROM sala WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idPelicula);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    sala = construirSalaDesdeResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener película por ID. Mensaje: " + e.getMessage(), e);
        }

        return sala;
    }

    private Sala construirSalaDesdeResultSet(ResultSet resultSet) throws SQLException {
        Sala sala = new Sala();
        sala.setId(resultSet.getInt("id"));
        sala.setNombreSala(resultSet.getString("nombre_sala"));
        sala.setFila(resultSet.getInt("filas"));
        sala.setColumna(resultSet.getInt("columnas"));

        return sala;
    }
}

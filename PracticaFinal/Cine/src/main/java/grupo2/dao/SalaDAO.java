package grupo2.dao;

import grupo2.modelo.Sala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo 2
 */
public class SalaDAO {
    
    private Connection conexion;
    private static final Logger logger = Logger.getLogger(SalaDAO.class.getName());

    public SalaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public Sala obtenerSalaPorId(int idSala) {
        Sala sala = null;
        String sql = "SELECT * FROM sala WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idSala);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    sala = construirSalaDesdeResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener sala por ID. Mensaje: " + e.getMessage(), e);
        }

        return sala;
    }
    
    private Sala construirSalaDesdeResultSet(ResultSet resultSet) throws SQLException {
        Sala sala = new Sala();
        
        sala.setId(resultSet.getInt("id"));
        sala.setNombre(resultSet.getString("nombre"));
        sala.setFilas(resultSet.getInt("filas"));
        sala.setColumnas(resultSet.getInt("columnas"));

        return sala;
    }

}

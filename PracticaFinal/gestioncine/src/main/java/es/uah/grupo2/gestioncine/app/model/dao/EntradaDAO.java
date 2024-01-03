package es.uah.grupo2.gestioncine.app.model.dao;

import es.uah.grupo2.gestioncine.app.model.entity.Entrada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntradaDAO {

    private Connection conexion;
    private static final Logger logger = Logger.getLogger(EntradaDAO.class.getName());

    public EntradaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Entrada> obtenerTodasLasEntradas() {
        List<Entrada> entradas = new ArrayList<>();
        String sql = "SELECT * FROM entrada";

        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Entrada entrada = construirEntradaDesdeResultSet(resultSet);
                entradas.add(entrada);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener todas las entradas. Mensaje: " + e.getMessage(), e);
        }

        return entradas;
    }

    public List<Entrada> obtenerEntradasPorProyeccion(int idProyeccion) {
        List<Entrada> entradas = new ArrayList<>();
        String sql = "SELECT * FROM entrada WHERE id_proyeccion = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idProyeccion);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Entrada entrada = construirEntradaDesdeResultSet(resultSet);
                    entradas.add(entrada);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener entradas por proyeccion. Mensaje: " + e.getMessage(), e);
        }

        return entradas;
    }

    private Entrada construirEntradaDesdeResultSet(ResultSet resultSet) throws SQLException {
        Entrada entrada = new Entrada();
        entrada.setId(resultSet.getInt("id"));
        entrada.setIdProyeccion(resultSet.getInt("id_proyeccion"));
        entrada.setFila(resultSet.getInt("fila"));
        entrada.setColumna(resultSet.getInt("columna"));
        entrada.setIdReserva(resultSet.getInt("reserva_id"));

        return entrada;
    }
}

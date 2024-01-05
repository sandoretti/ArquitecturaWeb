package es.uah.grupo2.gestioncine.app.model.dao;

import es.uah.grupo2.gestioncine.app.model.entity.Entrada;
import es.uah.grupo2.gestioncine.app.model.entity.Proyeccion;
import es.uah.grupo2.gestioncine.app.model.entity.Sala;

import java.sql.*;
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

    // Método para actualizar el atributo reserva_id de una entrada
    public void actualizarReservaId(int proyeccionId, int fila, int columna, int idReserva) {
        String sql = "UPDATE entrada SET reserva_id = ? WHERE id_proyeccion = ? AND fila = ? AND columna = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            if (idReserva == 0) preparedStatement.setNull(1, Types.INTEGER);
            else preparedStatement.setInt(1, idReserva);

            preparedStatement.setInt(2, proyeccionId);
            preparedStatement.setInt(3, fila);
            preparedStatement.setInt(4, columna);

            preparedStatement.executeUpdate();
            logger.log(Level.INFO, "Se actualizó el atributo reserva_id para la entrada ({0}, {1}, {2}) en la proyección {3}.", new Object[]{fila, columna, idReserva, proyeccionId});

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar el atributo reserva_id para la entrada.", e);
        }
    }

    public void actualizarReservaId(Entrada entrada) {
        actualizarReservaId(entrada.getIdProyeccion(), entrada.getFila(), entrada.getColumna(), entrada.getIdReserva());
    }

    public void creaEntradasProyeccion(Proyeccion proyeccion, Sala sala) throws SQLException {
        String SQL = "INSERT INTO ENTRADA (ID_PROYECCION, FILA, COLUMNA) VALUES (?, ?, ?)";
        PreparedStatement ps = conexion.prepareStatement(SQL);

        int numFilas = sala.getFila();
        int numCols = sala.getColumna();
        int idProyeccion = proyeccion.getId();

        for (int i = 1; i <= numFilas; i++){
            for (int j = 1; j <= numCols; j++) {
                ps.setInt(1, idProyeccion);
                ps.setInt(2, i);
                ps.setInt(3, j);

                ps.addBatch();
            }
        }

        ps.executeBatch();
    }


    public Entrada obtenerEntradaId (int idEntrada) throws SQLException {
        String SQL = "SELECT ID, ID_PROYECCION, FILA, COLUMNA, RESERVA_ID FROM ENTRADA WHERE ID = ?";

        PreparedStatement ps = conexion.prepareStatement(SQL);
        ps.setInt(1, idEntrada);

        ResultSet rs = ps.executeQuery();

        Entrada entrada = null;

        if (rs.next()) {
            entrada = construirEntradaDesdeResultSet(rs);
        }

        return entrada;
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

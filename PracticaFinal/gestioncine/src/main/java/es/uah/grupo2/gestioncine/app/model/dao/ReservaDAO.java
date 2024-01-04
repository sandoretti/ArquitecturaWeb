package es.uah.grupo2.gestioncine.app.model.dao;

import es.uah.grupo2.gestioncine.app.model.entity.Reserva;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservaDAO {

    static Connection conn = DatabaseConnection.getConnection();
    private Connection conexion;
    private static final Logger logger = Logger.getLogger(EntradaDAO.class.getName());

    public ReservaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public ReservaDAO() {
    }

    public List<Reserva> all() throws SQLException {
        String SQL = "SELECT ID, ID_CLIENTE, FECHA_RESERVA, NUMERO_TARJETA, REFERENCIA_RESERVA, PRECIO FROM RESERVA " +
                "WHERE ID > -1";

        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();

        List<Reserva> reservaList = new ArrayList<>();

        while (rs.next()) {
            Reserva reserva = new Reserva();

            reserva.setId(rs.getInt(1));
            reserva.setIdCliente(rs.getInt(2));
            reserva.setFechaReserva(rs.getTimestamp(3));
            reserva.setNumeroTarjeta(rs.getString(4));
            reserva.setReferenciaReserva(rs.getString(5));
            reserva.setPrecio(rs.getFloat(6));

            reservaList.add(reserva);
        }

        return reservaList;
    }

    // Método para crear una nueva reserva y obtener su ID
    public int crearReserva(Reserva reserva) {
        String sql = "INSERT INTO reserva (id_cliente, fecha_reserva, numero_tarjeta, referencia_reserva, precio) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, reserva.getIdCliente());
            statement.setTimestamp(2, new Timestamp(reserva.getFechaReserva().getTime()));
            statement.setString(3, reserva.getNumeroTarjeta());
            statement.setString(4, reserva.getReferenciaReserva());
            statement.setFloat(5, reserva.getPrecio());

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                // Recupera el ID generado para la reserva
                ResultSet generatedKeys = statement.getGeneratedKeys();

                // Verifica si el conjunto de resultados no es nulo y contiene datos
                if (generatedKeys != null && generatedKeys.next()) {
                    int idReserva = generatedKeys.getInt(1);
                    logger.log(Level.INFO, "Se creó una nueva reserva con ID: {0}", idReserva);
                    return idReserva;
                } else {
                    logger.log(Level.SEVERE, "Error al obtener el ID de la reserva creada.");
                    return -1;
                }
            } else {
                logger.log(Level.WARNING, "Error al añadir reserva: {0}", reserva.getId());
                return -1;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al añadir reserva", e);
            return -1;
        }
    }
}

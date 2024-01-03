package es.uah.grupo2.gestioncine.app.model.dao;

import es.uah.grupo2.gestioncine.app.model.entity.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    static Connection conn = DatabaseConnection.getConnection();

    public List<Reserva> all() throws SQLException {
        String SQL = "SELECT ID, ID_CLIENTE, FECHA_RESERVA, NUMERO_TARJETA, REFERENCIA_RESERVA, PRECIO FROM RESERVA";

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
}

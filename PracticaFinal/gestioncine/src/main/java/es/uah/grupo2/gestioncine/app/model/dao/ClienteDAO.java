package es.uah.grupo2.gestioncine.app.model.dao;

import es.uah.grupo2.gestioncine.app.model.entity.Cliente;

import java.sql.*;

public class ClienteDAO {

    private final Connection conn;

    public ClienteDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Retorna: 0 si no encuestra el usuario o la contraseña es incorrecta. 1 si
     * existe el usuario pero no es administrador. 2 si existe el usuario y es
     * administrador.
     */
    public Cliente validarUsuario(String email, String passwd) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM APP.CLIENTE WHERE EMAIL = ? AND CONTRASENA = ?";
            //String sql = "SELECT * FROM APP.CLIENTE";
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, passwd);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Cliente(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getString("EMAIL"),
                        rs.getString("CONTRASENA"),
                        rs.getTimestamp("FECHA_REGISTRO"),
                        rs.getBoolean("ES_ADMIN")
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    public boolean insertarCliente(
            String nombre,
            String apellido,
            String email,
            String passwd
    ) {
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO Cliente (nombre, apellido, email, contrasena, fecha_registro, es_admin) "
                    + "VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP, FALSE)";

            ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, email);
            ps.setString(4, passwd);

            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;

    }

    public boolean verificarEmail(String email) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT EMAIL FROM APP.CLIENTE WHERE EMAIL = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, email);

            rs = ps.executeQuery();

            // Comprobamos si existe el email en la BBDD
            return !rs.next();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}

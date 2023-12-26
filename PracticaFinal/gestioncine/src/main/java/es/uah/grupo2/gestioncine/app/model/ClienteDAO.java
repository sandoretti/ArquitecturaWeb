package es.uah.grupo2.gestioncine.app.model;

import java.sql.*;

public class ClienteDAO {

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

    /**
     * Retorna: 0 si no encuestra el usuario o la contraseña es incorrecta. 1 si
     * existe el usuario pero no es administrador. 2 si existe el usuario y es
     * administrador.
     */
    public Cliente validarUsuario(Connection conn, String email, String passwd) {
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
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean IngresarUsuario(Connection conn, Cliente cliente) throws SQLException {
        String sql = "INSERT INTO Cliente (nombre, apellido, email, contrasena, fecha_registro, es_admin) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getPasswd());
            ps.setTimestamp(5, cliente.getFechaRegistro());
            ps.setBoolean(6, cliente.isAdmin());
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }
}

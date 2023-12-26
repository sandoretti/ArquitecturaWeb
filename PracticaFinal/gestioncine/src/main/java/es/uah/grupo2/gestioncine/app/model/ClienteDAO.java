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
                        rs.getString("FECHA_REGISTRO"),
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

    /**
     * Inserta un cliente en la base de datos dada por la conexion. 
     * 
     * @param conn 
     * @param nombre
     * @param apellido
     * @param email
     * @param passwd
     * @return Si se ha insertado correctamente, este devuelve true, pero sino , devolvemos false
     */
    public boolean insertarCliente(
            Connection conn,
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
        } finally {
            try {
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
        
        return false;

    }

    /**
     * Verifica si el email dado se encuentra dentro de la base de datos
     * 
     * @param conn
     * @param email
     * @return 
     */
    public boolean verificarEmail(Connection conn, String email) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT EMAIL FROM APP.CLIENTE WHERE EMAIL = ?";
            
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, email);
            
            rs =  ps.executeQuery();
            
            // Comprobamos si existe el email en la BBDD
            return !rs.next(); 
            
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
        
        return false;
    }

}

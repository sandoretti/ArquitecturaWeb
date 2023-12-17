package modelo;

import java.sql.*;
import java.util.ArrayList;

public class CircuitoOperaciones {

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

    public ArrayList<Circuito> getCircuitos(Connection conn) {
        ArrayList<Circuito> circuitos = new ArrayList<>();
        String sql = "SELECT * FROM CIRCUITOS";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String ciudad = rs.getString("ciudad");
                String pais = rs.getString("pais");
                int numVueltas = rs.getInt("numVueltas");
                int longitudVuelta = rs.getInt("longitudVuelta");
                int numCurvas = rs.getInt("numCurvas");

                Circuito circuito = new Circuito(nombre, ciudad, pais, numVueltas, longitudVuelta, numCurvas);
                circuitos.add(circuito);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return circuitos;

    }

    public void guardarCircuito(Connection conn, Circuito circuito) {
        String sql = "INSERT INTO APP.CIRCUITOS(nombre, ciudad, pais, numVueltas, longitudVuelta, numCurvas) VALUES (?, ?, ?, ?, ?, ?)";
        // Usamos try-with-resources para asegurarnos de que los recursos se cierran automáticamente
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Establecemos los parámetros para el PreparedStatement
            pstmt.setString(1, circuito.getNombre());
            pstmt.setString(2, circuito.getCiudad());
            pstmt.setString(3, circuito.getPais());
            pstmt.setInt(4, circuito.getNumeroVueltas());
            pstmt.setInt(5, circuito.getLongitudVueltas());
            pstmt.setInt(6, circuito.getNumeroCurvas());

            // Ejecutamos la consulta
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Manejo de la excepción SQLException
            e.printStackTrace();
            // Podrías lanzar una excepción personalizada o manejarla de otra manera
        }
    }
}

package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CocheOperaciones {

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

    public void guardarCoche(Connection conn, Coche coche) {
        String sql = "INSERT INTO APP.COCHES(nombre, gananciapotenciacurva) VALUES (?, ?)";
        // Usamos try-with-resources para asegurarnos de que los recursos se cierran automáticamente
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Establecemos los parámetros para el PreparedStatement
            pstmt.setString(1, coche.getNombre());
            pstmt.setInt(2, coche.getGananciaPotenciaCurva());

            // Ejecutamos la consulta
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // Manejo de la excepción SQLException
            e.printStackTrace();
            // Podrías lanzar una excepción personalizada o manejarla de otra manera
        }
    }

    public ArrayList<Coche> getCoches(Connection conn) {
        ArrayList<Coche> coches = new ArrayList<>();
        String sql = "SELECT * FROM COCHES";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int gananciaPotenciaCurva = rs.getInt("gananciapotenciacurva");

                Coche coche = new Coche(nombre, gananciaPotenciaCurva);
                coches.add(coche);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coches;
    }

}

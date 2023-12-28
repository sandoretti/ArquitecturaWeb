package es.uah.grupo2.gestioncine.app.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO {
    public static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/shopmedb");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return c;
    }

    public static List<Actor> obtenerActores(){
        String sql = "SELECT id, nombre, apellido FROM APP.ACTOR";

        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            List<Actor> actores = new ArrayList<>();

            int id;
            String nombre, apellido;

            while (rs.next()){
                id = rs.getInt(1);
                nombre = rs.getString(2);
                apellido = rs.getString(3);

                actores.add(new Actor(id, nombre, apellido));
            }

            return actores;

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

    public static boolean annadirActoresPelicula(String[] actores, int idPelicula){
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "INSERT INTO PELICULA_ACTOR(PELICULA_ID, ACTOR_ID) VALUES (?, ?)";

        try{
            ps = conn.prepareStatement(sql);

            for (String s: actores){
                int idActor = Integer.parseInt(s);

                ps.setInt(1, idPelicula);
                ps.setInt(2, idActor);

                ps.addBatch();
            }

            ps.executeBatch();

            return true;


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

package es.uah.grupo2.gestioncine.app.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDAO {
    static Connection conn = DatabaseConnection.getConnection();

    public static List<Actor> obtenerActores(){
        String sql = "SELECT id, nombre, apellido FROM APP.ACTOR";

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
        }

        return null;
    }

    public static void annadirActoresPelicula(List<Actor> actores, int idPelicula)
        throws SQLException
    {
        String sql = "INSERT INTO PELICULA_ACTOR(PELICULA_ID, ACTOR_ID) VALUES (?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        for (Actor actor: actores){
            int idActor = actor.getId();

            ps.setInt(1, idPelicula);
            ps.setInt(2, idActor);

            ps.addBatch();
        }

        ps.executeBatch();
    }

    public static List<Actor> obtenerActoresPelicula(int id_pelicula){
        String sql = "SELECT ACTOR_ID FROM PELICULA_ACTOR WHERE PELICULA_ID = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id_pelicula);

            rs = ps.executeQuery();

            List<Actor> actores = new ArrayList<>();

            int id;

            while (rs.next()){
                id = rs.getInt(1);

                actores.add(new Actor(id));
            }

            return actores;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void eliminarActoresPelicula(int idPelicula) throws SQLException{
        String SQL = "DELETE FROM PELICULA_ACTOR WHERE PELICULA_ID = ?";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setInt(1, idPelicula);

        ps.executeUpdate();
    }
}

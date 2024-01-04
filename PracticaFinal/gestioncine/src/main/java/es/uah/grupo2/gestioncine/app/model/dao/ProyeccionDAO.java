package es.uah.grupo2.gestioncine.app.model.dao;

import es.uah.grupo2.gestioncine.app.model.entity.Proyeccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProyeccionDAO {
    static Connection conn = DatabaseConnection.getConnection();

    public static List<Proyeccion> obtenerProyecciones() throws SQLException {
        String sql = "select PROYECCION.ID, NOMBRE_PELICULA, NOMBRE_SALA, FECHA_HORA from " +
                "(PROYECCION INNER JOIN PELICULA on PELICULA.ID = PROYECCION.ID_PELICULA) INNER JOIN " +
                "SALA on PROYECCION.ID_SALA = SALA.ID ORDER BY PROYECCION.ID";

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Proyeccion> proyecciones = new ArrayList<>();

        while (rs.next()) {
            proyecciones.add(new Proyeccion(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getTimestamp(4)
            ));
        }

        return proyecciones;
    }

    public Proyeccion crearProyeccion(Proyeccion proyeccion) throws SQLException {
        String SQL = "INSERT INTO PROYECCION(id_pelicula, id_sala, fecha_hora) VALUES (?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setInt(1, proyeccion.getIdPelicula());
        ps.setInt(2, proyeccion.getIdSala());
        ps.setTimestamp(3, new Timestamp(proyeccion.getFechaHora().getTime()));

        ps.executeUpdate();

        int idProyeccion = obtenerIdProyeccion(proyeccion);

        proyeccion.setId(idProyeccion);

        return proyeccion;
    }

    public int obtenerIdProyeccion(Proyeccion proyeccion) throws SQLException {
        String SQL = "SELECT ID FROM PROYECCION WHERE ID_PELICULA = ? AND ID_SALA = ? AND FECHA_HORA = ?";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setInt(1, proyeccion.getIdPelicula());
        ps.setInt(2, proyeccion.getIdSala());
        ps.setTimestamp(3, new Timestamp(proyeccion.getFechaHora().getTime()));

        ResultSet rs = ps.executeQuery();

        int id = -1;

        if (rs.next()){
            id = rs.getInt(1);
        }

        return id;
    }

    public static void eliminarProyeccion(int id) throws SQLException {
        String SQL = "DELETE FROM PROYECCION WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setInt(1, id);

        ps.executeUpdate();
    }

    public static boolean validarIdProyeccion(int id) throws SQLException {
        String SQL = "SELECT ID FROM PROYECCION WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        return rs.next();
    }

    public static Proyeccion obtenerProyeccion(int id) throws SQLException {
        String SQL = "SELECT ID, ID_PELICULA, ID_SALA, FECHA_HORA FROM PROYECCION WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Proyeccion proyeccion = null;

        if (rs.next()) {
            proyeccion = new Proyeccion(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getTimestamp(4)
            );
        }

        return proyeccion;
    }

    public static void editarProyeccion(Proyeccion proyeccion) throws SQLException {
        String SQL = "UPDATE PROYECCION SET ID_PELICULA = ?, ID_SALA = ?, FECHA_HORA = ? WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setInt(1, proyeccion.getIdPelicula());
        ps.setInt(2, proyeccion.getIdSala());
        ps.setTimestamp(3, new Timestamp(proyeccion.getFechaHora().getTime()));
        ps.setInt(4, proyeccion.getId());

        ps.executeUpdate();
    }
}

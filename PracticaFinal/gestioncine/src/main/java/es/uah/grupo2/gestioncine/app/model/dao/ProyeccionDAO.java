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

    public static void crearProyeccion(Proyeccion proyeccion) throws SQLException {
        String SQL = "INSERT INTO PROYECCION(id_pelicula, id_sala, fecha_hora) VALUES (?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setInt(1, proyeccion.getIdPelicula());
        ps.setInt(2, proyeccion.getIdSala());
        ps.setTimestamp(3, new Timestamp(proyeccion.getFechaHora().getTime()));

        ps.executeUpdate();
    }
}

package es.uah.grupo2.gestioncine.app.model.dao;

import es.uah.grupo2.gestioncine.app.model.entity.Actor;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PeliculaDAO {

    static Connection conn = DatabaseConnection.getConnection();

    /**
     * Inserta una pelicula en la base de datos
     */
    public static void insertarPelicula(Pelicula pelicula) throws SQLException{
        String SQL = "INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_oficial," +
                "genero, nacionalidad, duracion, ano, distribuidora, director, otros_datos, class_edad, " +
                "portada) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setString(1, pelicula.getNombre());
        ps.setString(2, pelicula.getSipnosis());
        ps.setString(3, pelicula.getPagina());
        ps.setString(4, pelicula.getTitulo());
        ps.setString(5, pelicula.getGenero());
        ps.setString(6, pelicula.getNacionalidad());
        ps.setInt(7, pelicula.getDuracion());
        ps.setInt(8, pelicula.getAno());
        ps.setString(9, pelicula.getDistribuidora());
        ps.setString(10, pelicula.getDirector());
        ps.setString(11, pelicula.getOtrosDatos());
        ps.setString(12, pelicula.getClasificacionEdad());
        ps.setString(13, pelicula.getPortad());

        ps.executeUpdate();

        if (pelicula.getActores() != null) {
            int idPelicula = PeliculaDAO.obtenerId(pelicula.getNombre());

            if (idPelicula > 0) {
                pelicula.setId(idPelicula);

                // Metemos los nuevos actores asociados a la pelicula
                ActorDAO.annadirActoresPelicula(pelicula.getActores(), pelicula.getId());
            }

        }

    }

    public static int obtenerId(String nombre) throws SQLException{
        String sql = "SELECT id FROM PELICULA WHERE nombre_pelicula = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, nombre);

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            return rs.getInt(1);
        } else {
            return -1;
        }

    }

    public static List<Pelicula> selectPeliculasIdNombGenAnoClas() throws SQLException{
        String sql = "SELECT ID, NOMBRE_PELICULA, GENERO, ANO, CLASS_EDAD FROM PELICULA ";

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        String nombre, genero, clasificacionEdad;
        int id, ano;

        List<Pelicula> peliculasList = new ArrayList<>();

        while(rs.next()){
            id = rs.getInt(1);
            nombre = rs.getString(2);
            genero = rs.getString(3);
            ano = rs.getInt(4);
            clasificacionEdad = rs.getString(5);

            peliculasList.add(new Pelicula(id, nombre, genero, ano, clasificacionEdad));
        }

        return peliculasList;
    }

    public static boolean validarId(int id) throws SQLException{
        String sql = "SELECT ID FROM PELICULA WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        return rs.next();
    }

    public static void eliminarPeliculaId(int id) throws SQLException{
        String SQL = "DELETE FROM PELICULA WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static Pelicula obtenerPelicula(int id) throws SQLException{
        String SQL_Pelicula = "SELECT ID, NOMBRE_PELICULA, SINOPSIS, PAGINA_OFICIAL, TITULO_OFICIAL, GENERO," +
                "NACIONALIDAD, DURACION, ANO, DISTRIBUIDORA, DIRECTOR, OTROS_DATOS, CLASS_EDAD, " +
                "PORTADA FROM PELICULA WHERE ID = ?";

        // Obtenemos los actores de la pelicula
        List<Actor> actores = ActorDAO.obtenerActoresPelicula(id);

        PreparedStatement ps = conn.prepareStatement(SQL_Pelicula);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Pelicula pelicula = null;

        if(rs.next()){
            pelicula = new Pelicula(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getInt(8),
                    rs.getInt(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getString(12),
                    rs.getString(13),
                    rs.getString(14),
                    actores
            );
        }

        return pelicula;
    }

    public static void update(Pelicula pelicula) throws SQLException{
        String SQL = "UPDATE PELICULA SET NOMBRE_PELICULA = ?, SINOPSIS = ?, PAGINA_OFICIAL = ?," +
                " TITULO_OFICIAL = ?, GENERO = ?, NACIONALIDAD = ?, DURACION = ?, ANO = ?, " +
                "DISTRIBUIDORA = ?, DIRECTOR = ?, OTROS_DATOS = ?, CLASS_EDAD = ? WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setString(1, pelicula.getNombre());
        ps.setString(2, pelicula.getSipnosis());
        ps.setString(3, pelicula.getPagina());
        ps.setString(4, pelicula.getTitulo());
        ps.setString(5, pelicula.getGenero());
        ps.setString(6, pelicula.getNacionalidad());
        ps.setInt(7, pelicula.getDuracion());
        ps.setInt(8, pelicula.getAno());
        ps.setString(9, pelicula.getDistribuidora());
        ps.setString(10, pelicula.getDirector());
        ps.setString(11, pelicula.getOtrosDatos());
        ps.setString(12, pelicula.getClasificacionEdad());
        ps.setInt(13, pelicula.getId());

        ps.executeUpdate();

        // Quitamos los actores de la pelicula
        ActorDAO.eliminarActoresPelicula(pelicula.getId());

        if (pelicula.getActores() != null) {
            // Metemos los nuevos actores asociados a la pelicula
            ActorDAO.annadirActoresPelicula(pelicula.getActores(), pelicula.getId());
        }

    }

    public static List<Pelicula> selectPeliculasIdNombrePortada() throws SQLException{
        String SQL = "SELECT ID, NOMBRE_PELICULA, PORTADA FROM PELICULA";

        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();

        List<Pelicula> peliculas = new ArrayList<>();

        while (rs.next()) {
            peliculas.add(new Pelicula(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
            ));
        }

        return peliculas;
    }
}

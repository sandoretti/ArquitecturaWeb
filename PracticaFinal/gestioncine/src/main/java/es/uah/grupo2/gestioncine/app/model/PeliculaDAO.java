package es.uah.grupo2.gestioncine.app.model;

import java.sql.*;
import java.util.ArrayList;
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

    /**
     * Obtiene el id de una pelicula dada por su nombre. Si no se encuentra o salta un error, devuelve -1.
     *
     * @param nombre
     * @return
     */
    public static int obtenerId(String nombre){
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id FROM PELICULA WHERE nombre_pelicula = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);

            rs = ps.executeQuery();

            if (rs.next()){
                return rs.getInt(1);
            } else {
                return -1;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return -1;
    }

    public static List<Pelicula> selectPeliculasIdNombGenAnoClas(){
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT ID, NOMBRE_PELICULA, GENERO, ANO, CLASS_EDAD FROM PELICULA ";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

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

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static boolean validarId(int id){
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT ID FROM PELICULA WHERE ID = ?";
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public static boolean eliminarPeliculaId(int id){
        PreparedStatement psPelicula = null;
        PreparedStatement psActores = null;

        try {
            // Eliminamos las relaciones de la pelicula con actores
            String SQL_Actores = "DELETE FROM PELICULA_ACTOR WHERE PELICULA_ID = ?";

            psActores = conn.prepareStatement(SQL_Actores);

            psActores.setInt(1, id);

            psActores.executeUpdate();

            // Eliminamos las peliculas
            String SQL_Peliculas = "DELETE FROM PELICULA WHERE ID = ?";

            psPelicula = conn.prepareStatement(SQL_Peliculas);

            psPelicula.setInt(1, id);

            psPelicula.executeUpdate();

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public static Pelicula obtenerPelicula(int id){
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            List<Actor> actores = ActorDAO.obtenerActoresPelicula(id);

            String SQL_Pelicula = "SELECT ID, NOMBRE_PELICULA, SINOPSIS, PAGINA_OFICIAL, TITULO_OFICIAL, GENERO," +
                    "NACIONALIDAD, DURACION, ANO, DISTRIBUIDORA, DIRECTOR, OTROS_DATOS, CLASS_EDAD, " +
                    "PORTADA FROM PELICULA WHERE ID = ?";

            ps = conn.prepareStatement(SQL_Pelicula);

            ps.setInt(1, id);

            rs = ps.executeQuery();

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

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
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

        if (pelicula.getActores() != null) {
            // Quitamos los actores de la pelicula
            ActorDAO.eliminarActoresPelicula(pelicula.getId());

            // Metemos los nuevos actores asociados a la pelicula
            ActorDAO.annadirActoresPelicula(pelicula.getActores(), pelicula.getId());
        }

    }
}

package es.uah.grupo2.gestioncine.app.model.dao;

import es.uah.grupo2.gestioncine.app.model.entity.Actor;
import es.uah.grupo2.gestioncine.app.model.entity.Comentario;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;
import es.uah.grupo2.gestioncine.app.model.entity.Proyeccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeliculaDAO {

    static Connection conn = DatabaseConnection.getConnection();
    private Connection conexion;
    private static final Logger logger = Logger.getLogger(PeliculaDAO.class.getName());

    public PeliculaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Inserta una pelicula en la base de datos
     */
    public static void insertarPelicula(Pelicula pelicula) throws SQLException {
        String SQL = "INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_oficial,"
                + "genero, nacionalidad, duracion, ano, distribuidora, director, otros_datos, class_edad, "
                + "portada) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

    public static int obtenerId(String nombre) throws SQLException {
        String sql = "SELECT id FROM PELICULA WHERE nombre_pelicula = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, nombre);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return -1;
        }

    }

    public static List<Pelicula> selectPeliculasIdNombGenAnoClas() throws SQLException {
        String sql = "SELECT ID, NOMBRE_PELICULA, GENERO, ANO, CLASS_EDAD FROM PELICULA ";

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        String nombre, genero, clasificacionEdad;
        int id, ano;

        List<Pelicula> peliculasList = new ArrayList<>();

        while (rs.next()) {
            id = rs.getInt(1);
            nombre = rs.getString(2);
            genero = rs.getString(3);
            ano = rs.getInt(4);
            clasificacionEdad = rs.getString(5);

            peliculasList.add(new Pelicula(id, nombre, genero, ano, clasificacionEdad));
        }

        return peliculasList;
    }

    public static boolean validarId(int id) throws SQLException {
        String sql = "SELECT ID FROM PELICULA WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        return rs.next();
    }

    public static void eliminarPeliculaId(int id) throws SQLException {
        String SQL = "DELETE FROM PELICULA WHERE ID = ?";

        PreparedStatement ps = conn.prepareStatement(SQL);

        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static Pelicula obtenerPelicula(int id) throws SQLException {
        String SQL_Pelicula = "SELECT ID, NOMBRE_PELICULA, SINOPSIS, PAGINA_OFICIAL, TITULO_OFICIAL, GENERO,"
                + "NACIONALIDAD, DURACION, ANO, DISTRIBUIDORA, DIRECTOR, OTROS_DATOS, CLASS_EDAD, "
                + "PORTADA FROM PELICULA WHERE ID = ?";

        // Obtenemos los actores de la pelicula
        List<Actor> actores = ActorDAO.obtenerActoresPelicula(id);

        PreparedStatement ps = conn.prepareStatement(SQL_Pelicula);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Pelicula pelicula = null;

        if (rs.next()) {
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

    public static void update(Pelicula pelicula) throws SQLException {
        String SQL = "UPDATE PELICULA SET NOMBRE_PELICULA = ?, SINOPSIS = ?, PAGINA_OFICIAL = ?,"
                + " TITULO_OFICIAL = ?, GENERO = ?, NACIONALIDAD = ?, DURACION = ?, ANO = ?, "
                + "DISTRIBUIDORA = ?, DIRECTOR = ?, OTROS_DATOS = ?, CLASS_EDAD = ?, PORTADA = ? " +
                "WHERE ID = ?";

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
        ps.setInt(14, pelicula.getId());

        ps.executeUpdate();

        // Quitamos los actores de la pelicula
        ActorDAO.eliminarActoresPelicula(pelicula.getId());

        if (pelicula.getActores() != null) {
            // Metemos los nuevos actores asociados a la pelicula
            ActorDAO.annadirActoresPelicula(pelicula.getActores(), pelicula.getId());
        }

    }

    public static List<Pelicula> selectPeliculasIdNombrePortada() throws SQLException {
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

    public List<Pelicula> obtenerTodasLasPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT * FROM pelicula";

        try (Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Pelicula pelicula = construirPeliculaDesdeResultSet(resultSet);
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener todas las películas. Mensaje: " + e.getMessage(), e);
        }

        return peliculas;
    }

    public Pelicula obtenerPeliculaPorId(int idPelicula) {
        Pelicula pelicula = null;
        String sql = "SELECT * FROM pelicula WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idPelicula);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    pelicula = construirPeliculaDesdeResultSet(resultSet);

                    // Obtener y asignar la lista de actores para esta película
                    List<Actor> actores = obtenerActoresPorPelicula(idPelicula);
                    pelicula.setActores(actores);

                    // Obtener y asignar la lista de comentarios para esta película
                    List<Comentario> comentarios = obtenerComentariosPorPelicula(idPelicula);
                    pelicula.setComentarios(comentarios);

                    // Obtener y asignar la lista de comentarios para esta película
                    List<Proyeccion> proyecciones = obtenerProyeccionesPorPelicula(idPelicula);
                    pelicula.setProyecciones(proyecciones);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener película por ID. Mensaje: " + e.getMessage(), e);
        }

        return pelicula;
    }

    private Pelicula construirPeliculaDesdeResultSet(ResultSet resultSet) throws SQLException {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(resultSet.getInt("id"));
        pelicula.setNombre(resultSet.getString("nombre_pelicula"));
        pelicula.setSipnosis(resultSet.getString("sinopsis"));
        pelicula.setPagina(resultSet.getString("pagina_oficial"));
        pelicula.setTitulo(resultSet.getString("titulo_oficial"));
        pelicula.setGenero(resultSet.getString("genero"));
        pelicula.setNacionalidad(resultSet.getString("nacionalidad"));
        pelicula.setDuracion(resultSet.getInt("duracion"));
        pelicula.setAno(resultSet.getInt("ano"));
        pelicula.setDistribuidora(resultSet.getString("distribuidora"));
        pelicula.setDirector(resultSet.getString("director"));
        pelicula.setOtrosDatos(resultSet.getString("otros_datos"));
        pelicula.setClasificacionEdad(resultSet.getString("class_edad"));
        pelicula.setPortad(resultSet.getString("portada"));
        pelicula.setTrailer(resultSet.getString("trailer"));

        return pelicula;
    }

    // Método privado para obtener la lista de actores por película
    private List<Actor> obtenerActoresPorPelicula(int idPelicula) {
        List<Actor> actores = new ArrayList<>();
        String sql = "SELECT a.* FROM actor a "
                + "JOIN pelicula_actor pa ON a.ID = pa.actor_id "
                + "WHERE pa.pelicula_id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idPelicula);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Actor actor = new Actor();
                    actor.setNombre(resultSet.getString("nombre"));
                    actor.setApellido(resultSet.getString("apellido"));

                    actores.add(actor);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener actores por película. Mensaje: " + e.getMessage(), e);
        }

        return actores;
    }

    private List<Comentario> obtenerComentariosPorPelicula(int idPelicula) {
        List<Comentario> comentarios = new ArrayList<>();
        String sql = "SELECT c.*, u.nombre, u.apellido "
                + "FROM comentario c "
                + "JOIN cliente u ON c.id_cliente = u.id "
                + "WHERE c.id_pelicula = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idPelicula);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Comentario comentario = new Comentario();
                    comentario.setId(resultSet.getInt("id"));
                    comentario.setIdCliente(resultSet.getInt("id_cliente"));
                    comentario.setIdPelicula(resultSet.getInt("id_pelicula"));
                    comentario.setTexto(resultSet.getString("texto"));
                    comentario.setFechaComentario(resultSet.getTimestamp("fecha_comentario"));
                    comentario.setUsuario(resultSet.getString("nombre") + " " + resultSet.getString("apellido"));

                    comentarios.add(comentario);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener comentarios por película. Mensaje: " + e.getMessage(), e);
        }

        return comentarios;
    }

    public List<Proyeccion> obtenerProyeccionesPorPelicula(int idPelicula) {
        List<Proyeccion> proyecciones = new ArrayList<>();
        String sql = "SELECT p.id, p.id_pelicula, p.id_sala, p.fecha_hora, s.nombre_sala AS nombre_sala "
                + "FROM proyeccion p "
                + "JOIN sala s ON p.id_sala = s.id "
                + "WHERE p.id_pelicula = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idPelicula);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Proyeccion proyeccion = new Proyeccion();
                    proyeccion.setId(resultSet.getInt("id"));
                    proyeccion.setIdPelicula(resultSet.getInt("id_pelicula"));
                    proyeccion.setIdSala(resultSet.getInt("id_sala"));
                    proyeccion.setFechaHora(resultSet.getTimestamp("fecha_hora"));
                    proyeccion.setNombreSala(resultSet.getString("nombre_sala"));
                    proyecciones.add(proyeccion);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener proyeccion por pelicula. Mensaje: " + e.getMessage(), e);
        }

        return proyecciones;
    }
}

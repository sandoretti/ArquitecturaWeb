package grupo2.dao;

import grupo2.modelo.Actor;
import grupo2.modelo.Comentario;
import grupo2.modelo.Pelicula;
import grupo2.modelo.Proyeccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PeliculaDAO {

    private Connection conexion;
    private static final Logger logger = Logger.getLogger(PeliculaDAO.class.getName());

    public PeliculaDAO(Connection conexion) {
        this.conexion = conexion;
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

    public List<Pelicula> obtenerTodasLasPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT * FROM pelicula";

        try (Statement statement = conexion.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Pelicula pelicula = construirPeliculaDesdeResultSet(resultSet);
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener todas las películas. Mensaje: " + e.getMessage(), e);
        }

        return peliculas;
    }

    // Método privado para obtener la lista de actores por película
    private List<Actor> obtenerActoresPorPelicula(int idPelicula) {
        List<Actor> actores = new ArrayList<>();
        String sql = "SELECT a.* FROM actor a "
                + "JOIN pelicula_actor pa ON a.ID = pa.id_actor "
                + "WHERE pa.id_pelicula = ?";

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
         String sql = "SELECT c.*, u.nombre, u.apellido " +
                 "FROM comentario c " +
                 "JOIN usuario u ON c.id_usuario = u.id " +
                 "WHERE c.id_pelicula = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idPelicula);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Comentario comentario = new Comentario();
                    comentario.setId(resultSet.getInt("id"));
                    comentario.setIdUsuario(resultSet.getInt("id_usuario"));
                    comentario.setIdPelicula(resultSet.getInt("id_pelicula"));
                    comentario.setTexto(resultSet.getString("texto"));
                    comentario.setFecha(resultSet.getTimestamp("fecha_comentario"));
                    comentario.setUsuario(resultSet.getString("nombre") + " " + resultSet.getString("apellido"));

                    comentarios.add(comentario);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener comentarios por película. Mensaje: " + e.getMessage(), e);
        }

        return comentarios;
    }
    
    private List<Proyeccion> obtenerProyeccionesPorPelicula(int idPelicula) {
        List<Proyeccion> proyecciones = new ArrayList<>();
        String sql = "SELECT p.id, p.id_pelicula, p.fecha, p.hora, s.nombre AS nombre_sala "
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
                    proyeccion.setFecha(resultSet.getDate("fecha"));
                    proyeccion.setHora(resultSet.getTime("hora"));
                    proyeccion.setNombreSala(resultSet.getString("nombre_sala"));
                    proyecciones.add(proyeccion);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener proyeccion por pelicula. Mensaje: " + e.getMessage(), e);
        }

        return proyecciones;
    }
    
    
    private Pelicula construirPeliculaDesdeResultSet(ResultSet resultSet) throws SQLException {
        Pelicula pelicula = new Pelicula();
        pelicula.setId(resultSet.getInt("id"));
        pelicula.setNombre(resultSet.getString("nombre"));
        pelicula.setSinopsis(resultSet.getString("sinopsis"));
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
        pelicula.setPortada(resultSet.getString("portada"));

        return pelicula;
    }

}

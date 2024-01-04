package es.uah.grupo2.gestioncine.app.model.dao;

import es.uah.grupo2.gestioncine.app.model.entity.Comentario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComentarioDAO {

    private Connection conexion;
    private static final Logger logger = Logger.getLogger(ComentarioDAO.class.getName());

    public ComentarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean agregarComentario(Comentario comentario) {
        String sql = "INSERT INTO comentario (id_cliente, id_pelicula, texto, fecha_comentario) "
                + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, comentario.getIdCliente());
            statement.setInt(2, comentario.getIdPelicula());
            statement.setString(3, comentario.getTexto());
            statement.setTimestamp(4, comentario.getFechaComentario());

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                logger.log(Level.INFO, "Comentario registrado: {0}", comentario.getTexto());
                return true;
            } else {
                logger.log(Level.WARNING, "Error al registrar comentario: {0}", comentario.getTexto());
                return false;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al registrar comentario", e);
            return false;
        }
    }
}

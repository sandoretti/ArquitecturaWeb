package grupo2.dao;

import grupo2.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO {
    private Connection conexion;
    private static final Logger logger = Logger.getLogger(UsuarioDAO.class.getName());

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nombre, apellido, email, contrasena, fecha_registro, es_admin) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getEmail());
            statement.setString(4, usuario.getContrasena());
            statement.setTimestamp(5, usuario.getFechaRegistro());
            statement.setBoolean(6, usuario.isEsAdmin());

            int filasAfectadas = statement.executeUpdate();

            if (filasAfectadas > 0) {
                logger.log(Level.INFO, "Usuario registrado: {0}", usuario.getEmail());
                return true;
            } else {
                logger.log(Level.WARNING, "Error al registrar usuario: {0}", usuario.getEmail());
                return false;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al registrar usuario", e);
            return false;
        }
    }

    public Usuario obtenerUsuarioPorEmail(String email) {
        String sql = "SELECT * FROM usuario WHERE email = ?";
        
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return construirUsuarioDesdeResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener usuario por email", e);
        }

        return null;
    }

    private Usuario construirUsuarioDesdeResultSet(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getInt("id"));
        usuario.setNombre(resultSet.getString("nombre"));
        usuario.setApellido(resultSet.getString("apellido"));
        usuario.setEmail(resultSet.getString("email"));
        usuario.setContrasena(resultSet.getString("contrasena"));
        usuario.setFechaRegistro(resultSet.getTimestamp("fecha_registro"));
        usuario.setEsAdmin(resultSet.getBoolean("es_admin"));
        return usuario;
    }
    
    
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET nombre=?, apellido=?, contrasena=?, es_admin=? WHERE id=?";
        
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellido());
            statement.setString(3, usuario.getContrasena());
            statement.setBoolean(4, usuario.isEsAdmin());
            statement.setInt(5, usuario.getId());

            int filasAfectadas = statement.executeUpdate();
            
            if (filasAfectadas > 0) {
                logger.log(Level.INFO, "Usuario actualizado: {0}", usuario.getEmail());
                return true;
            } else {
                logger.log(Level.WARNING, "Error al actualizar usuario: {0}", usuario.getEmail());
                return false;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al actualizar usuario", e);
            return false;
        }
    }

    public boolean eliminarUsuario(int usuarioId) {
        String sql = "DELETE FROM usuario WHERE id=?";
        
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, usuarioId);

            int filasAfectadas = statement.executeUpdate();
            
            if (filasAfectadas > 0) {
                logger.log(Level.INFO, "Usuario eliminado con ID: {0}", usuarioId);
                return true;
            } else {
                logger.log(Level.WARNING, "Error al eliminar usuario con ID: {0}", usuarioId);
                return false;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al eliminar usuario", e);
            return false;
        }
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Usuario usuario = construirUsuarioDesdeResultSet(resultSet);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error SQL al obtener todos los usuarios", e);
        }

        return usuarios;
    }
}

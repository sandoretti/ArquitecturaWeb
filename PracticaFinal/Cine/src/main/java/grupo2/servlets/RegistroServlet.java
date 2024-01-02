package grupo2.servlets;

import grupo2.dao.ConexionBD;
import grupo2.dao.UsuarioDAO;
import grupo2.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(RegistroServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexion = null;

        try {
            // Obtiene una conexión de la clase de gestión de conexión
            conexion = ConexionBD.obtenerConexion();

            // Recupera los parámetros del formulario de registro
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            String contrasena = request.getParameter("password");

            // Crea un objeto de usuario con la información del formulario
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setApellido(apellido);
            nuevoUsuario.setEmail(email);
            nuevoUsuario.setContrasena(contrasena);
            // Crear un objeto Timestamp con la marca de tiempo actual
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            nuevoUsuario.setFechaRegistro(timestamp);
            nuevoUsuario.setEsAdmin(false);

            // Accede al DAO para registrar el nuevo usuario en la base de datos
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
            boolean registrado = usuarioDAO.agregarUsuario(nuevoUsuario);

            // Redirige a una página de éxito o error según el resultado del registro
            if (registrado) {
                logger.log(Level.INFO, "Nuevo usuario registrado: {0}", email);
                response.sendRedirect("index.jsp");
            } else {
                logger.log(Level.WARNING, "Error al registrar nuevo usuario: {0}", email);
                response.sendRedirect("404.jsp");
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener conexión a la base de datos", e);
        } finally {
            // Cierra la conexión en el bloque finally para garantizar que se cierre
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    logger.log(Level.SEVERE, "Error al cerrar la conexión a la base de datos", e);
                }
            }
        }
    }
}

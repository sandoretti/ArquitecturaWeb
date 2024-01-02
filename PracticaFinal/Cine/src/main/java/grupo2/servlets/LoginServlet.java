package grupo2.servlets;

import grupo2.dao.ConexionBD;
import grupo2.dao.UsuarioDAO;
import grupo2.modelo.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexion = null;

        try {
            // Obtiene una conexión de la clase de gestión de conexión
            conexion = ConexionBD.obtenerConexion();

            // Recupera los parámetros del formulario de inicio de sesión
            String email = request.getParameter("email");
            String contrasena = request.getParameter("password");

            // Accede al DAO para autenticar al usuario
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
            Usuario usuario = usuarioDAO.obtenerUsuarioPorEmail(email);

            // Verifica las credenciales del usuario
            if (usuario != null && usuario.getContrasena().equals(contrasena)) {
                // Credenciales válidas, crea una sesión y redirige a la página principal
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);

                // Establece un atributo de sesión para indicar inicio de sesión exitoso
                session.setAttribute("loginMessage", "¡Bienvenido de nuevo! Has iniciado sesión correctamente.");

                // Verifica si el usuario es un administrador
                if (usuario.isEsAdmin()) {
                    logger.log(Level.INFO, "Inicio de sesion exitoso (Admin): {0}", email);
                    response.sendRedirect("indexAdmin.jsp");
                } else {
                    logger.log(Level.INFO, "Inicio de sesion exitoso: {0}", email);
                    response.sendRedirect("index.jsp");
                }
            } else {
                logger.log(Level.WARNING, "Error de inicio de sesion para: {0}", email);
                // Puedes agregar un mensaje de error para informar al usuario
                request.setAttribute("error", "Credenciales incorrectas. Por favor, inténtalo de nuevo.");
                // Puedes redirigir de nuevo a la página de inicio de sesión o a otra página según tus necesidades
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener conexion a la base de datos", e);
        } finally {
            // Cierra la conexión en el bloque finally para garantizar que se cierre
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    logger.log(Level.SEVERE, "Error al cerrar la conexion a la base de datos", e);
                }
            }
        }
    }
}

package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.ComentarioDAO;
import es.uah.grupo2.gestioncine.app.model.dao.DatabaseConnection;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Comentario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ComentarioServlet", urlPatterns = {"/comentario"})
public class ComentarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ComentarioServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Verificar la existencia de un usuario en la sesión
        HttpSession session = request.getSession(false);
        Cliente cliente = (Cliente) session.getAttribute("usuario");
        if (session == null || cliente == null) {
            // Redirigir a la página de inicio de sesión si no hay usuario en la sesión
            response.sendRedirect(request.getContextPath() + "/login.jsp");

        } else {
            Connection conexion = null;
            try {
                // Obtiene una conexión de la clase de gestión de conexión
                conexion = DatabaseConnection.obtenerConexion();
                // Obtiene los parámetros del formulario
                int peliculaId = Integer.parseInt(request.getParameter("peliculaId"));
                String texto = request.getParameter("opinion");
                Date fecha = new Date();

                // Crea el comentario
                Comentario comentario = new Comentario();
                comentario.setIdCliente(cliente.getId());
                comentario.setIdPelicula(peliculaId);
                // Obtener la fecha actual
                Date fechaActual = new Date();
                // Crear un Timestamp a partir de la fecha actual
                Timestamp timestamp = new Timestamp(fechaActual.getTime());
                comentario.setFechaComentario(timestamp);
                comentario.setTexto(texto);

                // Guarda el comentario en la base de datos
                ComentarioDAO comentarioDAO = new ComentarioDAO(conexion);
                boolean registrado = comentarioDAO.agregarComentario(comentario);

                // Redirige a una página de éxito o error según el resultado del registro
                if (registrado) {
                    logger.log(Level.INFO, "Nuevo comentario registrado: {0}", texto);
                    response.sendRedirect("pelicula?id=" + peliculaId);
                } else {
                    logger.log(Level.WARNING, "Error al registrar nuevo comentario: {0}", texto);
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

}

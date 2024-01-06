package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.ComentarioDAO;
import es.uah.grupo2.gestioncine.app.model.dao.DatabaseConnection;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Comentario;
import java.io.IOException;

import jakarta.servlet.ServletConfig;
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
public class ComentarioServlet extends CineServlet {
    private ComentarioDAO comentarioDAO;

    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        comentarioDAO = new ComentarioDAO(conn);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Verificar la existencia de un usuario en la sesión
        HttpSession session = request.getSession(false);
        Cliente cliente = (Cliente) session.getAttribute("usuario");
        if (session == null || cliente == null) {
            // Redirigir a la página de inicio de sesión si no hay usuario en la sesión
            response.sendRedirect(request.getContextPath() + "/login.jsp");

        } else {
            try {
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

                boolean registrado = comentarioDAO.agregarComentario(comentario);

                // Redirige a una página de éxito o error según el resultado del registro
                if (registrado) {
                    logger.log(Level.INFO, "Nuevo comentario registrado: {0}", texto);
                    response.sendRedirect("pelicula?id=" + peliculaId);
                } else {
                    logger.log(Level.WARNING, "Error al registrar nuevo comentario: {0}", texto);
                    response.sendRedirect("404.jsp");
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error al obtener conexión a la base de datos", e);
            }
        }
    }

}

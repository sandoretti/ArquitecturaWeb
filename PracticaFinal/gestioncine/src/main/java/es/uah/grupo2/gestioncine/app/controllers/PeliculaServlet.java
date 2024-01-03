package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.DatabaseConnection;
import es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "PeliculaServlet", urlPatterns = {"/pelicula"})
public class PeliculaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(PeliculaServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexion = null;

        try {
            // Obtiene una conexión de la clase de gestión de conexión
            conexion = DatabaseConnection.obtenerConexion();

            // Recupera el parámetro de la solicitud que representa el ID de la película
            String peliculaIdParam = request.getParameter("id");

            if (peliculaIdParam != null && !peliculaIdParam.isEmpty()) {
                // Convierte el ID de la película a un entero
                int peliculaId = Integer.parseInt(peliculaIdParam);

                // Accede al DAO para obtener la información de la película por ID
                PeliculaDAO peliculaDAO = new PeliculaDAO(conexion);
                Pelicula pelicula = peliculaDAO.obtenerPeliculaPorId(peliculaId);

                if (pelicula != null) {
                    // Coloca la película en el ámbito de solicitud para que la JSP pueda accederla
                    request.setAttribute("pelicula", pelicula);

                    String paginaOrigen = request.getParameter("to");

                    if ("reserva".equals(paginaOrigen)) {
                        // Verificar sesion
                        HttpSession session = request.getSession(false);
                        if (session != null) {
                            Cliente cliente = (Cliente) session.getAttribute("usuario");

                            if (cliente != null) {
                                request.getRequestDispatcher(request.getContextPath() + "/reserva.jsp").forward(request, response);
                            } else {
                                response.sendRedirect(request.getContextPath() + "login?from=reserva");
                            }
                        } else {
                            response.sendRedirect(request.getContextPath() + "login?from=reserva");
                        }
                    } else {
                        request.getRequestDispatcher("pelicula.jsp").forward(request, response);
                    }

                } else {
                    // La película no fue encontrada
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "La película no fue encontrada");
                }
            } else {
                // ID de la película no proporcionado en la solicitud
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de película no proporcionado");
            }
        } catch (NumberFormatException e) {
            // Error al convertir el ID de la película a un entero
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de película no válido");
        } catch (SQLException e) {
            // Error al obtener conexión o al acceder a la base de datos
            logger.log(Level.SEVERE, "Error al obtener conexión a la base de datos", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en la base de datos");
        } finally {
            // Cierra la conexión en el bloque finally para garantizar que se cierre
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    // Error al cerrar la conexión
                    logger.log(Level.SEVERE, "Error al cerrar la conexión a la base de datos", e);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}

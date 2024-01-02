package grupo2.servlets;

import grupo2.dao.ConexionBD;
import grupo2.dao.SalaDAO;
import grupo2.modelo.Sala;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SalaServlet", urlPatterns = {"/sala"})
public class SalaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(PeliculaServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexion = null;

        try {
            // Obtiene una conexión de la clase de gestión de conexión
            conexion = ConexionBD.obtenerConexion();

            // Recupera el parámetro de la solicitud que representa el ID de la sala
            String salaIdParam = request.getParameter("id");

            if (salaIdParam != null && !salaIdParam.isEmpty()) {
                // Convierte el ID de la película a un entero
                int salaId = Integer.parseInt(salaIdParam);

                // Accede al DAO para obtener la información de la película por ID
                SalaDAO salaDAO = new SalaDAO(conexion);
                Sala sala = salaDAO.obtenerSalaPorId(salaId);

                if (sala != null) {
                    // Coloca la sala en el ámbito de solicitud para que la JSP pueda accederla
                    request.setAttribute("sala", sala);
                    // Redirige a la página
                    request.getRequestDispatcher(".jsp").forward(request, response);

                } else {
                    // La sala no fue encontrada
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "La sala no fue encontrada");
                }
            } else {
                // ID de la sala no proporcionado en la solicitud
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de sala no proporcionado");
            }
        } catch (NumberFormatException e) {
            // Error al convertir el ID de la sala a un entero
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de sala no válido");
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

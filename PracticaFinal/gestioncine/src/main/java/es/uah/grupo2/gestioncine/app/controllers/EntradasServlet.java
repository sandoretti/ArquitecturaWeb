package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.DatabaseConnection;
import es.uah.grupo2.gestioncine.app.model.dao.EntradaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Entrada;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "EntradasServlet", urlPatterns = {"/entradas"})
public class EntradasServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(EntradasServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexion = null;

        try {
            // Obtiene una conexión de la clase de gestión de conexión
            conexion = DatabaseConnection.obtenerConexion();

            // Recupera el parámetro de la solicitud que representa el ID de la proyeccion
            String proyeccionIdParam = request.getParameter("id");

            if (proyeccionIdParam != null && !proyeccionIdParam.isEmpty()) {
                // Convierte el ID de la proyecion a un entero
                int proyeccionId = Integer.parseInt(proyeccionIdParam);

                // Accede al DAO para obtener las entradas de la proyeccion por ID
                EntradaDAO entradDAO = new EntradaDAO(conexion);
                List<Entrada> entradas = entradDAO.obtenerEntradasPorProyeccion(proyeccionId);

                if (entradas != null) {
                    // Coloca la película en el ámbito de solicitud para que la JSP pueda accederla
                    request.setAttribute("entradas", entradas);
                    
                    // Redirige a la pagina de las entradas
                    request.getRequestDispatcher(".jsp").forward(request, response);

                } else {
                    // La proyeccion no fue encontrada
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "La proyeccion no fue encontrada");
                }
            } else {
                // ID de la proyeccion no proporcionado en la solicitud
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de proyeccion no proporcionado");
            }
        } catch (NumberFormatException e) {
            // Error al convertir el ID de la proyeccion a un entero
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de proyeccion no válido");
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

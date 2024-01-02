package grupo2.servlets;

import grupo2.dao.ConexionBD;
import grupo2.dao.PeliculaDAO;
import grupo2.modelo.Pelicula;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "PeliculasServlet", urlPatterns = {"/peliculas"})
public class PeliculasServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(PeliculasServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conexion = null;

        try {
            // Obtiene una conexión de la clase de gestión de conexión
            conexion = ConexionBD.obtenerConexion();

            // Accede al DAO para obtener todas las películas
            PeliculaDAO peliculaDAO = new PeliculaDAO(conexion);
            List<Pelicula> peliculas = peliculaDAO.obtenerTodasLasPeliculas();

            // Coloca la lista de películas en el ámbito de solicitud para que la JSP pueda accederla
            request.setAttribute("peliculas", peliculas);

            // Registro: Información sobre la obtención exitosa de películas
            logger.log(Level.INFO, "Obtención exitosa de todas las películas.");

            String paginaOrigen = request.getParameter("from");
            if ("index".equals(paginaOrigen)) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("peliculas.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            // Registro: Error en la base de datos
            logger.log(Level.SEVERE, "Error al obtener películas de la base de datos", e);

            // Manejo de errores de base de datos
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en la base de datos");
        } finally {
            // Cierra la conexión en el bloque finally para garantizar que se cierre
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    // Registro: Error al cerrar la conexión
                    logger.log(Level.SEVERE, "Error al cerrar la conexión a la base de datos", e);
                }
            }
        }
    }

}

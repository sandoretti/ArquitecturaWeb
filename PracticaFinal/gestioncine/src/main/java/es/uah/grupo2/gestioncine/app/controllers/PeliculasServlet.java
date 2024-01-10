package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.DatabaseConnection;
import es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;
import java.io.IOException;

import jakarta.servlet.ServletConfig;
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
public class PeliculasServlet extends CineServlet{

    private static final long serialVersionUID = 1L;
    private PeliculaDAO peliculaDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        peliculaDAO = new PeliculaDAO(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Pelicula> peliculas = peliculaDAO.obtenerTodasLasPeliculas();

            // Coloca la lista de películas en el ámbito de solicitud para que la JSP pueda accederla
            request.setAttribute("peliculas", peliculas);

            // Registro: Información sobre la obtención exitosa de películas
            //logger.log(Level.INFO, "Obtención exitosa de todas las películas.");

            String paginaOrigen = request.getParameter("from");
            if ("index".equals(paginaOrigen)) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("peliculas.jsp").forward(request, response);
            }

        } catch (Exception e) {
            // Registro: Error en la base de datos
            logger.log(Level.SEVERE, "Error al obtener películas de la base de datos", e);

            // Manejo de errores de base de datos
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en la base de datos");
        }
    }

}

package es.uah.grupo2.gestioncine.app.controllers.adminops;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "GestPeliculas", urlPatterns = {"/gestionPeliculas"})
public class GestPeliculasController extends AdminOperationServlet {
    private PeliculaDAO peliculaDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        peliculaDAO = new PeliculaDAO(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        List<Pelicula> peliculas = null;
        try {
            peliculas = peliculaDAO.selectPeliculasIdNombGenAnoClas();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("peliculas", peliculas);
        request.getRequestDispatcher(request.getContextPath() + "/gest-peliculas.jsp").forward(request, response);
    }
}

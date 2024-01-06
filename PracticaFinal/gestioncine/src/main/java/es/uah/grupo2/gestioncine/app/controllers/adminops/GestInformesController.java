package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.dao.*;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "GestionInformes", urlPatterns = "/gestionInformes")
public class GestInformesController extends AdminOperationServlet{
    private PeliculaDAO peliculaDAO;
    private ProyeccionDAO proyeccionDAO;
    private SalaDAO salaDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        peliculaDAO = new PeliculaDAO(conn);
        proyeccionDAO = new ProyeccionDAO(conn);
        salaDAO = new SalaDAO(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        // Lista de peliculas por genero
        List<Pelicula> peliculaList = peliculaDAO.obtenerTodasLasPeliculas();

        // key: Genero - value: lista de peliculas
        HashMap<String, List<Pelicula>> peliculasGeneros = new HashMap<>();

        // Miramos si hay peliculas en la lista
        if (peliculaList != null) {
            // Recorremos las peliculas
            for (Pelicula pelicula: peliculaList) {
                // Si el genero de la pelicula se encuentra dentro del hashmap
                if (peliculasGeneros.containsKey(pelicula.getGenero())){
                    // Lo metemos dentro de la lista de las peliculas del mismo genero del hashmap
                    peliculasGeneros.get(pelicula.getGenero()).add(pelicula);
                } else { // Sino, creamos una lista con la pelicula dentro y la insertamos dentro del hasmap
                    List<Pelicula> peliculas = new ArrayList<>();
                    peliculas.add(pelicula);
                    peliculasGeneros.put(pelicula.getGenero(), peliculas);
                }
            }
        }

        request.setAttribute("peliculasGen", peliculasGeneros);

        request.getRequestDispatcher(request.getContextPath() + "/gest-informes.jsp").forward(request, response);
    }
}

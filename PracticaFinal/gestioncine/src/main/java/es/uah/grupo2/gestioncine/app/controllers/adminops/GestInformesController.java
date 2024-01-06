package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.dao.*;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;
import es.uah.grupo2.gestioncine.app.model.entity.Proyeccion;
import es.uah.grupo2.gestioncine.app.model.entity.Sala;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

@WebServlet(name = "GestionInformes", urlPatterns = "/gestionInformes")
public class GestInformesController extends AdminOperationServlet{
    // DAO
    private PeliculaDAO peliculaDAO;
    private ProyeccionDAO proyeccionDAO;
    private SalaDAO salaDAO;

    // Listas de objetos del modelo
    private List<Pelicula> peliculaList;
    private List<Proyeccion> proyeccionList;
    private List<Sala> salaList;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        peliculaDAO = new PeliculaDAO(conn);
        proyeccionDAO = new ProyeccionDAO(conn);
        salaDAO = new SalaDAO(conn);

        peliculaList = null;
        proyeccionList = null;
        salaList = null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
                
        try {
            peliculaList = peliculaDAO.obtenerTodasLasPeliculas();
            proyeccionList = proyeccionDAO.obtenerProyeccionesEntradas();
            salaList = salaDAO.mostrarSalas(conn);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al acceder a la base de datos", e);
        }

        // key: Genero - value: lista de peliculas
        HashMap<String, List<Pelicula>> peliculasGeneros = obtenerPeliculasGenero();

        // Metemos los numero en el hashmap
        HashMap<String, Integer> otrosInformes = obtenerOtrosInformes();

        request.setAttribute("otrosInformes", otrosInformes);
        request.setAttribute("peliculasGen", peliculasGeneros);

        request.getRequestDispatcher(request.getContextPath() + "/gest-informes.jsp").forward(request, response);
    }

    private HashMap<String, List<Pelicula>> obtenerPeliculasGenero() {
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

        return peliculasGeneros;
    }

    private HashMap<String, Integer> obtenerOtrosInformes() {
        HashMap<String, Integer> otrosInformes = new HashMap<>();

        // Obtenemos el numero total de entradas vendidas y totales
        int entradasTotales = 0;
        int entradasVendidas = 0;

        if (proyeccionList != null) {
            for (Proyeccion proyeccion: proyeccionList) {
                entradasTotales += proyeccion.getEntradasTotales();
                entradasVendidas += proyeccion.getEntradasVendidas();
            }
        }

        // Obtenemos el numero total de peliculas
        int numPeliculas = peliculaList != null ? peliculaList.size() : 0;

        // Obtenemos el numero total de salas
        int numSalas = salaList != null ? salaList.size() : 0;

        // Insertamos en el hashmap los valores obtenidos
        otrosInformes.put("Entradas totales", entradasTotales);
        otrosInformes.put("Entradas vendidas", entradasVendidas);
        otrosInformes.put("Número de peliculas", numPeliculas);
        otrosInformes.put("Número de salas", numSalas);

        return otrosInformes;
    }
}

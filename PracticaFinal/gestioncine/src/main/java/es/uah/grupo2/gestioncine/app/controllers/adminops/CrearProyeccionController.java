package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.dao.*;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;
import es.uah.grupo2.gestioncine.app.model.entity.Proyeccion;
import es.uah.grupo2.gestioncine.app.model.entity.Sala;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;


@WebServlet(name = "CrearProyeccion", urlPatterns = "/crearProyeccion")
public class CrearProyeccionController extends AdminOperationServlet {
    private PeliculaDAO peliculaDAO;
    private SalaDAO salaDAO;
    private ProyeccionDAO proyeccionDAO;
    private EntradaDAO entradaDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        peliculaDAO = new PeliculaDAO(conn);
        salaDAO = new SalaDAO(conn);
        proyeccionDAO = new ProyeccionDAO(conn);
        entradaDAO = new EntradaDAO(conn);
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
        List<Sala> salas = null;

        try {
            peliculas = peliculaDAO.selectPeliculasIdNombGenAnoClas();
            salas = salaDAO.mostrarSalas();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("salas", salas);
        request.setAttribute("peliculas", peliculas);
        request.getRequestDispatcher(request.getContextPath() + "/crear-proyeccion.jsp")
            .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        // Obtenemos la sesion
        HttpSession session = request.getSession(false);

        int idPelicula = Integer.parseInt(request.getParameter("pelicula"));
        int idSala = Integer.parseInt(request.getParameter("sala"));
        String fechaHoraStr = request.getParameter("fechahora");

        Date fechaHora = null;
        try {
            fechaHora = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(fechaHoraStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Proyeccion proyeccion = new Proyeccion(idPelicula, idSala, fechaHora);

        try {
            // Creamos la proyeccion en la base de datos y modificamos dicha proyeccion junto su id correspondiente
            proyeccion = proyeccionDAO.crearProyeccion(proyeccion);

            // Obtenemos la sala de la proyeccion
            Sala sala = salaDAO.obtenerSalaPorId(idSala);

            // Creamos las entradas de la proyeccion segun el numero de filas y columnas de la sala
            entradaDAO.creaEntradasProyeccion(proyeccion, sala);

            session.setAttribute("success", "Se ha creado correctamente la proyeccion");
            response.sendRedirect(request.getContextPath() + "/gestionProyecciones");
        } catch (SQLException e) {
            session.setAttribute("error", "Se ha producido un error al crear la proyeccion");
            response.sendRedirect(request.getContextPath() + "/crearProyeccion");
            e.printStackTrace();
        }
    }
}

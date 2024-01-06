package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO;
import es.uah.grupo2.gestioncine.app.model.dao.ProyeccionDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;
import es.uah.grupo2.gestioncine.app.model.entity.Proyeccion;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EditarProyeccion", urlPatterns = "/editarProyeccion/*")
public class EditarProyeccionController extends AdminOperationServlet
{
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

        HttpSession session = request.getSession(false);

        String rutaCompleta = request.getPathInfo();
        String[] partesRuta = rutaCompleta.split("/");
        String value = partesRuta[1]; // nos quedamos con el valor obtenido

        int idProyeccion = Integer.parseInt(value);

        try {
            if (ProyeccionDAO.validarIdProyeccion(idProyeccion)) {
                Proyeccion proyeccion = ProyeccionDAO.obtenerProyeccion(idProyeccion);

                List<Pelicula> peliculas = peliculaDAO.selectPeliculasIdNombGenAnoClas();

                request.setAttribute("peliculas", peliculas);
                request.setAttribute("proyeccion", proyeccion);
                request.getRequestDispatcher(request.getContextPath() + "/editar-proyeccion.jsp")
                        .forward(request, response);
            } else {
                session.setAttribute("error", "No se ha podido acceder a la pelicula");
                response.sendRedirect(request.getContextPath() + "/gestionProyecciones");
            }
        } catch (SQLException e) {
            session.setAttribute("error", "Hubo un error al validar el id");
            response.sendRedirect(request.getContextPath() + "/gestionProyecciones");
            e.printStackTrace();
        }
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

        // Obtenemos los parametros necesarios para la proyeccion
        int idPelicula = Integer.parseInt(request.getParameter("pelicula"));
        int idSala = Integer.parseInt(request.getParameter("sala"));
        String fechaHoraStr = request.getParameter("fechahora");
        int id = Integer.parseInt(request.getParameter("id"));

        // Obtenemos la fecha y la casteamos a tipo Date
        Date fechaHora = null;
        try {
            fechaHora = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(fechaHoraStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Construimos una proyeccion nueva
        Proyeccion proyeccion = new Proyeccion(id, idPelicula, idSala, fechaHora);

        try {
            // Editamos la proyeccion por su id con los parametros nuevos
            ProyeccionDAO.editarProyeccion(proyeccion);

            // Redireccionamos a la página de gestion de peliculas con un mensaje de exito
            session.setAttribute("success", "Se ha editado correctamente la proyeccion");
            response.sendRedirect(request.getContextPath() + "/gestionProyecciones");
        } catch (SQLException e) {
            session.setAttribute("error", "Se ha producido un error actualizar la proyeccion");
            response.sendRedirect(request.getContextPath() + "/editarProyeccion/" + id);

            e.printStackTrace();
        }

    }
}

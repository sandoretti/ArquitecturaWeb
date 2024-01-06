package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.dao.ProyeccionDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Proyeccion;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

@WebServlet(name = "GestProyecciones", urlPatterns = "/gestionProyecciones")
public class GestProyeccionesController extends AdminOperationServlet {
    private ProyeccionDAO proyeccionDAO;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        proyeccionDAO = new ProyeccionDAO(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        List<Proyeccion> proyecciones = null;

        try {
            proyecciones = proyeccionDAO.obtenerProyeccionesEntradas();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener las proyecciones", e);
        }

        request.setAttribute("proyecciones", proyecciones);
        request.getRequestDispatcher(request.getContextPath() + "/gest-proyecciones.jsp")
                .forward(request, response);
    }
}

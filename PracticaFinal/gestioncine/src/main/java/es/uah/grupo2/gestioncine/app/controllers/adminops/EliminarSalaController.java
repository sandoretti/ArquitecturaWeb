package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.dao.SalaDAO;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;

/**
 *
 * @author serchio
 */
@WebServlet(name = "EliminarSalaController", urlPatterns = {"/eliminarSala/*"})
public class EliminarSalaController extends AdminOperationServlet {
    private SalaDAO salaDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

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

        HttpSession session = request.getSession(false);
        // Extrayendo el ID de la sala de la URL
        String pathInfo = request.getPathInfo(); // Esto debería dar algo como "/123" si la URL es /eliminarSala/123
        if (pathInfo == null || pathInfo.equals("/")) {
            // Manejar el caso de no tener ID en la URL
            response.sendRedirect(request.getContextPath() + "/gestionSalas"); // Redirigir a la lista de salas o a una página de error
            return;
        }
        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            // Manejar el caso de una URL mal formada
            response.sendRedirect(request.getContextPath() + "/gestionSalas");
            return;
        }

        int salaId;
        try {
            salaId = Integer.parseInt(splits[1]);
        } catch (NumberFormatException e) {
            // Manejar el caso de un ID no numérico
            response.sendRedirect(request.getContextPath() + "/gestionSalas");
            return;
        }

        // Proceder con la eliminación
        boolean eliminado = salaDAO.eliminarSala(conn, salaId);
        if (eliminado) {
            session.setAttribute("success", "Se ha eliminado correctamente la sala");
            // La sala se eliminó correctamente
        } else {
            session.setAttribute("error", "Se ha producido un error al insertar la sala");
            // Hubo un problema al eliminar la sala
        }

        response.sendRedirect(request.getContextPath() + "/gestionSalas");
    }
}

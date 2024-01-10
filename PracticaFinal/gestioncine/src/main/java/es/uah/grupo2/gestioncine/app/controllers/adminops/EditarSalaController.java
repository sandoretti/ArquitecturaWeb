package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Sala;
import es.uah.grupo2.gestioncine.app.model.dao.SalaDAO;
import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 *
 * @author serchio
 */
@WebServlet(name = "EditarSalaController", urlPatterns = {"/editarSala/*"})
public class EditarSalaController extends AdminOperationServlet {

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

        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendRedirect(request.getContextPath() + "/gestionSalas");
            return;
        }

        String[] splits = pathInfo.split("/");
        if (splits.length != 2) {
            response.sendRedirect(request.getContextPath() + "/gestionSalas");
            return;
        }

        int salaId;
        try {
            salaId = Integer.parseInt(splits[1]);
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/gestionSalas");
            return;
        }


        Sala sala = salaDAO.obtenerSalaPorId(salaId);
        if (sala != null) {
            request.setAttribute("sala", sala);
            request.getRequestDispatcher(request.getContextPath() + "/editarSala.jsp").forward(request, response);
        } else {
            session.setAttribute("error", "Sala no encontrada");
            response.sendRedirect(request.getContextPath() + "/gestionSalas");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            Cliente cliente = (Cliente) session.getAttribute("usuario");

            if (cliente != null && cliente.isAdmin()) {
                // Obtener los datos del formulario
                int id = Integer.parseInt(request.getParameter("id"));
                String nombreSala = request.getParameter("nombre_sala");
                int filas = Integer.parseInt(request.getParameter("filas"));
                int columnas = Integer.parseInt(request.getParameter("columnas"));

                Sala sala = new Sala(id, nombreSala, filas, columnas);

                // Actualizar la sala en la base de datos
                try {
                    boolean actualizado = salaDAO.actualizarSala(sala);
                    if (actualizado) {
                        session.setAttribute("success", "Sala actualizada correctamente.");
                    } else {
                        session.setAttribute("error", "Error al actualizar la sala.");
                    }
                } catch (SQLException e) {
                    // Manejar la excepción
                    session.setAttribute("error", "Error de base de datos.");
                }

                // Redireccionar de vuelta a la lista de salas
                response.sendRedirect(request.getContextPath() + "/gestionSalas");
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }

    }

}

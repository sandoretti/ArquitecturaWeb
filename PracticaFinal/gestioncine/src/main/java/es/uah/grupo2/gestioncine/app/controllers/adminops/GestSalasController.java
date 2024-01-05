package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.entity.Sala;
import es.uah.grupo2.gestioncine.app.model.dao.SalaDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author serchio
 */
@WebServlet(name = "GestSalasController", urlPatterns = {"/gestionSalas"})
public class GestSalasController extends AdminOperationServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        HttpSession session = request.getSession(false);

        // Obtenemos todas las salas
        SalaDAO salita = new SalaDAO();
        Connection conn = salita.getConnection();
        List<Sala> salaList = salita.mostrarSalas(conn);

        // Las devolvemos en la vista de gestion de salas
        session.setAttribute("salas", salaList);
        request.getRequestDispatcher(request.getContextPath() + "/gest-salas.jsp").forward(request, response);

    }
}

package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.dao.ReservaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Reserva;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GestReservas", urlPatterns = "/gestionReservas")
public class GestReservasController extends AdminOperationServlet {
    private ReservaDAO reservaDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        reservaDAO = new ReservaDAO(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        List<Reserva> reservaList;

        try {
            reservaList = reservaDAO.all();
        } catch (SQLException e) {
            reservaList = new ArrayList<>();
            e.printStackTrace();
        }

        request.setAttribute("reservas", reservaList);
        request.getRequestDispatcher(request.getContextPath() + "/gest-reservas.jsp").forward(request, response);
    }


}

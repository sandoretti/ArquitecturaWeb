package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.ReservaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Reserva;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GestReservas", urlPatterns = "/gestionReservas")
public class GestReservasController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Verificamos si existe session
        if (session != null) {
            Cliente cliente = (Cliente) session.getAttribute("usuario");    // Obtenemos el atributo cliente

            // Si existe cliente y el cliente es administrador
            if (cliente != null && cliente.isAdmin()) {
                ReservaDAO reservaDAO = new ReservaDAO();

                List<Reserva> reservaList;

                try {
                    reservaList = reservaDAO.all();
                } catch (SQLException e) {
                    reservaList = new ArrayList<>();
                    e.printStackTrace();
                }

                request.setAttribute("reservas", reservaList);
                request.getRequestDispatcher(request.getContextPath() + "/gest-reservas.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }


}

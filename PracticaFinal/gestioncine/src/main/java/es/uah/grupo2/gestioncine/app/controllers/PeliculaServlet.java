package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.DatabaseConnection;
import es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;
import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "PeliculaServlet", urlPatterns = {"/pelicula"})
public class PeliculaServlet extends CineServlet {

    private static final long serialVersionUID = 1L;

    private PeliculaDAO peliculaDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        peliculaDAO = new PeliculaDAO(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Recupera el parámetro de la solicitud que representa el ID de la película
            String peliculaIdParam = request.getParameter("id");

            if (peliculaIdParam != null && !peliculaIdParam.isEmpty()) {
                // Convierte el ID de la película a un entero
                int peliculaId = Integer.parseInt(peliculaIdParam);

                // Accede al DAO para obtener la información de la película por ID
                Pelicula pelicula = peliculaDAO.obtenerPeliculaPorId(peliculaId);

                if (pelicula != null) {
                    // Coloca la película en el ámbito de solicitud para que la JSP pueda accederla
                    request.setAttribute("pelicula", pelicula);

                    String paginaOrigen = request.getParameter("to");

                    if ("reserva".equals(paginaOrigen)) {
                        // Verificar sesion
                        HttpSession session = request.getSession(false);
                        if (session != null) {
                            Cliente cliente = (Cliente) session.getAttribute("usuario");

                            if (cliente != null) {
                                request.getRequestDispatcher(request.getContextPath() + "/reserva.jsp").forward(request, response);
                            } else {
                                response.sendRedirect(request.getContextPath() + "login?from=reserva");
                            }
                        } else {
                            response.sendRedirect(request.getContextPath() + "login?from=reserva");
                        }
                    } else {
                        request.getRequestDispatcher("pelicula.jsp").forward(request, response);
                    }

                } else {
                    // La película no fue encontrada
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "La película no fue encontrada");
                }
            } else {
                // ID de la película no proporcionado en la solicitud
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de película no proporcionado");
            }
        } catch (NumberFormatException e) {
            // Error al convertir el ID de la película a un entero
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de película no válido");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}

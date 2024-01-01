package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.ProyeccionDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Proyeccion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;


@WebServlet(name = "CrearProyeccion", urlPatterns = "/crearProyeccion")
public class CrearProyeccionController extends HttpServlet {
    final Logger logger = Logger.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        Cliente cliente = (Cliente) session.getAttribute("usuario"); // Obtenemos el atributo cliente

        // Validamos que el cliente no sea nulo y que sea admin
        if (cliente != null && cliente.isAdmin()) {
            request.getRequestDispatcher(request.getContextPath() + "/crear-proyeccion.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        Cliente cliente = (Cliente) session.getAttribute("usuario"); // Obtenemos el atributo cliente

        // Validamos que el cliente no sea nulo y que sea admin
        if (cliente != null && cliente.isAdmin()) {
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
                ProyeccionDAO.crearProyeccion(proyeccion);

                session.setAttribute("success", "Se ha creado correctamente la proyeccion");
                response.sendRedirect(request.getContextPath() + "/gestionProyecciones");
            } catch (SQLException e) {
                session.setAttribute("error", "Se ha producido un error al crear la proyeccion");
                response.sendRedirect(request.getContextPath() + "/crearProyeccion");
                e.printStackTrace();
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}

package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.ProyeccionDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EliminarProyeccion", urlPatterns = "/eliminarProyeccion/*")
public class EliminarProyeccionController extends HttpServlet {
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
            String rutaCompleta = request.getPathInfo();
            String[] partesRuta = rutaCompleta.split("/");
            String value = partesRuta[1]; // nos quedamos con el valor obtenido

            int idProyeccion = Integer.parseInt(value);

            try {
                // Si el id obtenido se encuentra en la tabla proyeccion, lo eliminamos
                if (ProyeccionDAO.validarIdProyeccion(idProyeccion)) {
                    ProyeccionDAO.eliminarProyeccion(idProyeccion);

                    session.setAttribute("success", "Se ha eliminado correctamente la proyeccion");
                    response.sendRedirect(request.getContextPath() + "/gestionProyecciones");
                } else {
                    session.setAttribute("error", "No se encuentra la proyeccion");
                    response.sendRedirect(request.getContextPath() + "/gestionProyecciones");
                }
            } catch (SQLException e) {
                session.setAttribute("error", "Hubo un error en la base de datos");
                response.sendRedirect(request.getContextPath() + "/gestionProyecciones");
                e.printStackTrace();
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}

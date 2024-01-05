package es.uah.grupo2.gestioncine.app.controllers.adminops;

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
public class EliminarProyeccionController extends AdminOperationServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        HttpSession session = request.getSession(false);

        // Obtenemos el id de la proyeccion a eliminar
        String rutaCompleta = request.getPathInfo();
        String[] partesRuta = rutaCompleta.split("/");
        String value = partesRuta[1]; // nos quedamos con el valor obtenido
        int idProyeccion = Integer.parseInt(value);

        try {
            // Si el id obtenido se encuentra en la tabla proyeccion, lo eliminamos
            if (ProyeccionDAO.validarIdProyeccion(idProyeccion)) {
                ProyeccionDAO.eliminarProyeccion(idProyeccion);

                // Mensaje de exito
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
    }
}

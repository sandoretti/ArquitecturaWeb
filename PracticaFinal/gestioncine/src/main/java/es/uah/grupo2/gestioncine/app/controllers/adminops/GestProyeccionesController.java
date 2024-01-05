package es.uah.grupo2.gestioncine.app.controllers.adminops;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GestProyecciones", urlPatterns = "/gestionProyecciones")
public class GestProyeccionesController extends AdminOperationServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        request.getRequestDispatcher(request.getContextPath() + "/gest-proyecciones.jsp")
                .forward(request, response);
    }
}

package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.dao.DatabaseConnection;
import es.uah.grupo2.gestioncine.app.model.dao.EntradaDAO;
import es.uah.grupo2.gestioncine.app.model.dao.SalaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Entrada;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "GestionEntradasProy", urlPatterns = "/gestionEntradas/*")
public class GestEntradasProyController extends HttpServlet {
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

            Connection conn = DatabaseConnection.getConnection();
            EntradaDAO entradaDAO = new EntradaDAO(conn);
            List<Entrada> entradaList = entradaDAO.obtenerEntradasPorProyeccion(idProyeccion);

            request.setAttribute("proyeccion", idProyeccion);
            request.setAttribute("entradas", entradaList);

            request.getRequestDispatcher(request.getContextPath() + "/gest-entradas.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}

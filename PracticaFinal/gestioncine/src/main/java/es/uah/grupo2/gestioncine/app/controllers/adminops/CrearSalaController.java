package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.dao.SalaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;

/**
 *
 * @author serchio
 */
@WebServlet(name = "CrearSalaController", urlPatterns = {"/crearSala"})
public class CrearSalaController extends AdminOperationServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        request.getRequestDispatcher(request.getContextPath() + "/crearSala.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        // Obtenemos la sesion
        HttpSession session = request.getSession(false);

        // Obtener los parámetros del formulario
        String nombreSala = request.getParameter("nombre_sala");
        int filas = Integer.parseInt(request.getParameter("filas"));
        int columnas = Integer.parseInt(request.getParameter("columnas"));

        SalaDAO salita = new SalaDAO();
        Connection conn = salita.getConnection();

        boolean insertado = salita.insertarSala(conn, nombreSala, filas, columnas);

        if (insertado) {
            session.setAttribute("success", "Se ha creado correctamente la sala");
        } else {
            session.setAttribute("error", "Se ha producido un error al insertar la sala");
        }

        response.sendRedirect(request.getContextPath() + "/gestionSalas");
    }
}

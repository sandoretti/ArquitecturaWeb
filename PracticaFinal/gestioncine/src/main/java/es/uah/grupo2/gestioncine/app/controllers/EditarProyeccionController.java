package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO;
import es.uah.grupo2.gestioncine.app.model.dao.ProyeccionDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Pelicula;
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

@WebServlet(name = "EditarProyeccion", urlPatterns = "/editarProyeccion/*")
public class EditarProyeccionController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Verificamos si existe session
        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
        Cliente cliente = (Cliente) session.getAttribute("usuario"); // Obtenemos el atributo cliente

        // Si existe cliente y el cliente es administrador
        if (cliente != null && cliente.isAdmin()) {
            String rutaCompleta = request.getPathInfo();
            String[] partesRuta = rutaCompleta.split("/");
            String value = partesRuta[1]; // nos quedamos con el valor obtenido

            int idProyeccion = Integer.parseInt(value);

            try {
                if (ProyeccionDAO.validarIdProyeccion(idProyeccion)) {
                    Proyeccion proyeccion = ProyeccionDAO.obtenerProyeccion(idProyeccion);

                    request.setAttribute("proyeccion", proyeccion);
                    request.getRequestDispatcher(request.getContextPath() + "/editar-proyeccion.jsp")
                            .forward(request, response);
                } else {
                    session.setAttribute("error", "No se ha podido acceder a la pelicula");
                    response.sendRedirect(request.getContextPath() + "/gestionProyecciones");
                }
            } catch (SQLException e) {
                session.setAttribute("error", "Hubo un error al validar el id");
                response.sendRedirect(request.getContextPath() + "/gestionProyecciones");
                e.printStackTrace();
            }
        } else {
            session.setAttribute("error", "No puede acceder a esta pagina");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Verificamos si existe session
        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
        Cliente cliente = (Cliente) session.getAttribute("usuario"); // Obtenemos el atributo cliente

        // Si existe cliente y el cliente es administrador
        if (cliente != null && cliente.isAdmin()) {
            int idPelicula = Integer.parseInt(request.getParameter("pelicula"));
            int idSala = Integer.parseInt(request.getParameter("sala"));
            String fechaHoraStr = request.getParameter("fechahora");
            int id = Integer.parseInt(request.getParameter("id"));

            Date fechaHora = null;
            try {
                fechaHora = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(fechaHoraStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Proyeccion proyeccion = new Proyeccion(id, idPelicula, idSala, fechaHora);

            try {
                ProyeccionDAO.editarProyeccion(proyeccion);

                // Redireccionamos a la página de gestion de peliculas con un mensaje de exito
                session.setAttribute("success", "Se ha editado correctamente la proyeccion");
                response.sendRedirect(request.getContextPath() + "/gestionProyecciones");
            } catch (SQLException e) {
                session.setAttribute("error", "Se ha producido un error actualizar la proyeccion");
                response.sendRedirect(request.getContextPath() + "/editarProyeccion/" + id);

                e.printStackTrace();
            }
        }
    }
}

package es.uah.grupo2.gestioncine.app.controllers.adminops;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "EliminarPelicula", urlPatterns = {"/eliminarPelicula/*"})
public class EliminarPeliculaController extends AdminOperationServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        HttpSession session = request.getSession(false);

        // Obtenemos el id de la pelicula de la ruta
        String rutaCompleta = request.getPathInfo();
        String[] partesRuta = rutaCompleta.split("/");
        String value = partesRuta[1]; // nos quedamos con el valor obtenido
        int idPelicula = Integer.parseInt(value);

        try {
            // Validamos el id de la pelicula
            if (PeliculaDAO.validarId(idPelicula)) {
                // Eliminamos la pelicula del id dado
                PeliculaDAO.eliminarPeliculaId(idPelicula);

                // Mensaje de exito
                session.setAttribute("success", "Se ha eliminado correctamente la pelicula");
                response.sendRedirect(request.getContextPath() + "/gestionPeliculas");
            } else {
                session.setAttribute("error", "No se ha podido eliminar la pelicula");
                response.sendRedirect(request.getContextPath() + "/gestionPeliculas");
            }
        } catch (SQLException e) {
            session.setAttribute("error", "Hubo un error al validar el id");
            response.sendRedirect(request.getContextPath() + "/gestionPeliculas");
            e.printStackTrace();
        }
    }
}

package es.uah.grupo2.gestioncine.app.controllers.adminops;

import es.uah.grupo2.gestioncine.app.model.dao.DatabaseConnection;
import es.uah.grupo2.gestioncine.app.model.dao.EntradaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Entrada;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "CambiarEntrada", urlPatterns = "/cambiarEntrada/*")
public class CambiarEntradaController extends AdminOperationServlet {
    private EntradaDAO entradaDAO;

    private final int SIN_RESERVA = 0;
    private final int DESCARTADO = 1;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        entradaDAO = new EntradaDAO(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                         throws ServletException, IOException {
        // Si no es admin redirigimos a la pagina de inicio
        if (!validarAdmin(request)){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        HttpSession session = request.getSession(false);

        String rutaCompleta = request.getPathInfo();
        String[] partesRuta = rutaCompleta.split("/");
        String value = partesRuta[1]; // nos quedamos con el valor obtenido

        int idEntrada = Integer.parseInt(value);

        try {
            Entrada entrada = entradaDAO.obtenerEntradaId(idEntrada);

            if (entrada != null) {
                int estadoEntrada = SIN_RESERVA; // Nuevo estado de la entrada

                // Si no tiene reserva, lo descartamos
                if (entrada.getIdReserva() == SIN_RESERVA) {
                    estadoEntrada = DESCARTADO;
                }

                // Cambiamos el estado de la entrada
                entrada.setIdReserva(estadoEntrada);

                // Realizamos el cambio en la base de datos
                entradaDAO.actualizarReservaId(entrada);

                session.setAttribute("success", "Se ha cambiado el estado a la entrada " + idEntrada);
                response.sendRedirect(request.getContextPath() + "/gestionEntradas/" + entrada.getIdProyeccion());

            } else {
                session.setAttribute("error", "No se encuentra la entrada");
                response.sendRedirect(request.getContextPath() + "/gestionProyecciones" );
            }
        } catch (SQLException e) {
            session.setAttribute("error", "Hubo un error en la base de datos");
            response.sendRedirect(request.getContextPath() + "/gestionProyecciones");
            e.printStackTrace();
        }
    }
}

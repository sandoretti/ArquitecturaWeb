package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.DatabaseConnection;
import es.uah.grupo2.gestioncine.app.model.dao.ReservaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Reserva;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ReservaServlet", urlPatterns = {"/reserva"})
public class ReservaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ReservaServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexion = null;

        try {
            // Obtiene una conexión de la clase de gestión de conexión
            conexion = DatabaseConnection.obtenerConexion();

            // Recupera los parámetros del formulario de registro
            String nombre = request.getParameter("nombre");
            String nTarjeta = request.getParameter("numeroTarjeta");
            String fecha_cad = request.getParameter("fechaExpiracion");
            String cvv = request.getParameter("codigoSeguridad");

            // Crea un objeto de reserva con la información del formulario
            Reserva nuevaReserva = new Reserva();
            HttpSession session = request.getSession(false);
            // Obtener el cliente de la sesión
            Cliente cliente = (Cliente) session.getAttribute("usuario");
            nuevaReserva.setIdCliente(cliente.getId());
            nuevaReserva.setFechaReserva(new Date());
            nuevaReserva.setNumeroTarjeta(nTarjeta);
            String referencia = "XOXOXO";
            nuevaReserva.setReferenciaReserva(referencia);
            nuevaReserva.setPrecio((float) 10.2);

            // Accede al DAO para registrar el nuevo usuario en la base de datos
            ReservaDAO reservaDAO = new ReservaDAO(conexion);
            boolean reservaRealizada = reservaDAO.crearReserva(nuevaReserva);

            // Redirige a una página de éxito o error según el resultado del registro
            if (reservaRealizada) {
                logger.log(Level.INFO, "Nueva reserva registrado: {0}", referencia);
                response.sendRedirect("confirmacionPago.jsp?referencia=" + referencia);
            } else {
                logger.log(Level.WARNING, "Error al registrar nueva reserva: {0}", referencia);
                response.sendRedirect("404.jsp");
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener conexión a la base de datos", e);
        } finally {
            // Cierra la conexión en el bloque finally para garantizar que se cierre
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    logger.log(Level.SEVERE, "Error al cerrar la conexión a la base de datos", e);
                }
            }
        }

    }
}

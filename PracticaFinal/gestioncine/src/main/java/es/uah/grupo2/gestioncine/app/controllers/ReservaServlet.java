package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.DatabaseConnection;
import es.uah.grupo2.gestioncine.app.model.dao.EntradaDAO;
import es.uah.grupo2.gestioncine.app.model.dao.ReservaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Cliente;
import es.uah.grupo2.gestioncine.app.model.entity.Reserva;
import java.io.IOException;

import jakarta.servlet.ServletConfig;
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
public class ReservaServlet extends CineServlet {

    private static final long serialVersionUID = 1L;

    private EntradaDAO entradaDAO;
    private ReservaDAO reservaDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        entradaDAO = new EntradaDAO(conn);
        reservaDAO = new ReservaDAO(conn);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtiene los parámetros del formulario de pago
        String nombre = request.getParameter("nombre");
        String nTarjeta = request.getParameter("numeroTarjeta");
        String fecha_cad = request.getParameter("fechaExpiracion");
        String cvv = request.getParameter("codigoSeguridad");
        int proyeccionId = Integer.parseInt(request.getParameter("proyeccionId"));
        String[] asientosSeleccionados = request.getParameter("asientos").split(",");
        String strNumero = request.getParameter("precioTotal");
        // Reemplaza la coma por un punto
        strNumero = strNumero.replace(",", ".");
        Float precio = Float.valueOf(strNumero);

        // Genera un número de referencia aleatorio
        String numeroReferencia = generarNumeroReferencia();

        // Crea la reserva
        Reserva nuevaReserva = new Reserva();
        HttpSession session = request.getSession(false);
        // Obtener el cliente de la sesión
        Cliente cliente = (Cliente) session.getAttribute("usuario");
        nuevaReserva.setIdCliente(cliente.getId());
        nuevaReserva.setFechaReserva(new Date());
        nuevaReserva.setNumeroTarjeta(nTarjeta);
        nuevaReserva.setReferenciaReserva(numeroReferencia);
        nuevaReserva.setPrecio(precio);

        // Guarda la reserva en la base de datos y obtiene su ID
        int idReserva = reservaDAO.crearReserva(nuevaReserva);

        // Redirige a una página de éxito o error según el resultado del registro
        if (idReserva > 0) {
            // Actualiza el atributo reserva_id de las entradas seleccionadas
            for (String asiento : asientosSeleccionados) {
                String[] filaColumna = asiento.split("_");
                int fila = Integer.parseInt(filaColumna[0]);
                int columna = Integer.parseInt(filaColumna[1]);

                entradaDAO.actualizarReservaId(proyeccionId, fila, columna, idReserva);
            }

            logger.log(Level.INFO, "Nueva reserva registrado: {0}", numeroReferencia);
            response.sendRedirect("confirmacionPago.jsp?referencia=" + numeroReferencia);
        } else {
            logger.log(Level.WARNING, "Error al registrar nueva reserva: {0}", numeroReferencia);
            response.sendRedirect("404.jsp");
        }

    }

    private String generarNumeroReferencia() {
        // Genera un número de referencia aleatorio (puedes ajustar según tus necesidades)
        return String.valueOf((int) (Math.random() * 1000000));
    }
}

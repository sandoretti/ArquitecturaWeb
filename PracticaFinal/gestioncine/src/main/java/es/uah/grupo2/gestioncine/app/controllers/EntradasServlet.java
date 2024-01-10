package es.uah.grupo2.gestioncine.app.controllers;

import es.uah.grupo2.gestioncine.app.model.dao.DatabaseConnection;
import es.uah.grupo2.gestioncine.app.model.dao.EntradaDAO;
import es.uah.grupo2.gestioncine.app.model.entity.Entrada;
import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(name = "EntradasServlet", urlPatterns = {"/entradas"})
public class EntradasServlet extends CineServlet {

    private static final long serialVersionUID = 1L;

    private EntradaDAO entradaDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        entradaDAO = new EntradaDAO(conn);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            // Recupera el parámetro de la solicitud que representa el ID de la proyección
            String proyeccionIdParam = request.getParameter("proyeccionId");

            if (proyeccionIdParam != null && !proyeccionIdParam.isEmpty()) {
                // Convierte el ID de la proyección a un entero
                int proyeccionId = Integer.parseInt(proyeccionIdParam);

                // Accede al DAO para obtener la información de las entradas por ID de proyección
                List<Entrada> entradas = entradaDAO.obtenerEntradasPorProyeccion(proyeccionId);

                // Crea un objeto JSON para enviar información al cliente
                JSONArray jsonEntradas = new JSONArray();
                for (Entrada entrada : entradas) {
                    JSONObject jsonEntrada = new JSONObject();
                    jsonEntrada.put("fila", entrada.getFila());
                    jsonEntrada.put("columna", entrada.getColumna());
                    jsonEntrada.put("idReserva", entrada.getIdReserva());

                    jsonEntradas.add(jsonEntrada);
                }

                // Establece el tipo de contenido de la respuesta
                response.setContentType("application/json");
                // Escribe la respuesta JSON en el flujo de salida de la respuesta
                response.getWriter().write(jsonEntradas.toString());
            } else {
                // ID de la proyección no proporcionado en la solicitud
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de proyección no proporcionado");
            }
        } catch (NumberFormatException e) {
            // Error al convertir el ID de la proyección a un entero
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de proyección no válido");
        }
    }
}

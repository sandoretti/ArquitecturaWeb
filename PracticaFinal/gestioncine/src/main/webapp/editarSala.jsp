<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="es.uah.grupo2.gestioncine.app.model.Sala" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Sala</title>
    </head>
    <body>
        <h1>Editar Sala</h1>
        <%
            Sala sala = (Sala) request.getAttribute("sala");
            if (sala != null) {
        %>
        <form action="/editarSala/<%= sala.getId() %>" method="POST">
            <input type="hidden" name="id" value="<%= sala.getId() %>" />
            <div>
                <label>Nombre de la Sala:</label>
                <input type="text" name="nombre_sala" value="<%= sala.getNombreSala() %>" required />
            </div>
            <div>
                <label>Filas:</label>
                <input type="number" name="filas" value="<%= sala.getFila() %>" required />
            </div>
            <div>
                <label>Columnas:</label>
                <input type="number" name="columnas" value="<%= sala.getColumna() %>" required />
            </div>
            <div>
                <input type="submit" value="Actualizar Sala" />
            </div>
        </form>
        <% } else { %>
        <p>Sala no encontrada o error al cargar la sala.</p>
        <% } %>
    </body>
</html>

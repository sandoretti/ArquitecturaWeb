<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Sala" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Sala</title>
        <!-- El enlace es a una carpeta anterior porque toma como referencia
        al controlador -->
        <link rel="stylesheet" type="text/css" href="../css/styles.css"> 
    </head>
    <body class="body-style">
        
        <div class="container-style">
            <div class="navbar-style" style="margin:auto; padding: 5px 5px 5px 5px; max-width: 40%;">
            <!-- TODO: IMAGEN DE LA PELICULA PONERLA A LA IZQUIERDA DEL FORMULARIO -->
            <h1 style="margin:auto 15px auto;">Editar Sala</h1>
            <div>
                <a href="/gestionSalas" class="button-link" style="margin: 5px 5px 5px 5px;">Volver a gestion salas</a>
            </div>
        </div>
            <%
            Sala sala = (Sala) request.getAttribute("sala");
            if (sala != null) {
            %>
            <form style="margin-top:10px" class="form-container" action="/editarSala/<%= sala.getId() %>" method="POST">
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
        </div>
    </body>
</html>

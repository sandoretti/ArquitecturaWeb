<%-- 
    Document   : crearSala
    Created on : 29 dic 2023, 13:35:01
    Author     : serchio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Creando una sala</h1>
        <form action="/crearSala" method="post">
            <label for="nombre_sala">Nombre de la Sala:</label><br>
            <input type="text" id="nombre_sala" name="nombre_sala" required><br>

            <label for="filas">Número de Filas:</label><br>
            <input type="number" id="filas" name="filas" min="1" required><br>

            <label for="columnas">Número de Columnas:</label><br>
            <input type="number" id="columnas" name="columnas" min="1" required><br>

            <input type="submit" value="Agregar Sala">
        </form>
    </body>
</html>

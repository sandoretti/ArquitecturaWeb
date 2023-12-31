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
        <title>Crear Sala</title>
        <link rel="stylesheet" type="text/css" href="./css/styles.css"> <!-- Añade esta línea -->
    </head>
    <body class="body-style">
        <div class="container-style">
            <div style="max-width:40%; margin:5px auto;" class="navbar-style">
                <h1 style="margin: 5px 5px 5px 5px;">Crear una sala</h1>
                <div>
                    <a href="/gestionSalas" class="button-link" style="margin: 5px 5px 5px 5px;">Volver a gestion salas</a>
                </div>
            </div>
            <form class="form-container" action="/crearSala" method="post">
                <label for="nombre_sala">Nombre de la Sala:</label><br>
                <input type="text" id="nombre_sala" name="nombre_sala" required><br>

                <label for="filas">Número de Filas:</label><br>
                <input type="number" id="filas" name="filas" min="1" required><br>

                <label for="columnas">Número de Columnas:</label><br>
                <input type="number" id="columnas" name="columnas" min="1" required><br>

                <input type="submit" value="Agregar Sala">
            </form>
        </div>
        
    </body>
</html>

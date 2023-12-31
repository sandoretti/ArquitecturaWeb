<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="es.uah.grupo2.gestioncine.app.model.Cliente" %>
<% Cliente cliente = (Cliente) session.getAttribute("usuario");
    if(!cliente.isAdmin())
                    request.getRequestDispatcher(request.getContextPath() + "./").forward(request, response);
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion</title>
        <link rel="stylesheet" type="text/css" href="../css/styles.css">
    </head>
    <body class="body-style">
        <div class="container-style">
            <div class="navbar-style">
                <h1 style="margin:auto;">Menu de administrador</h1>
            </div>
            <div class="button-container" style="margin-top: 5px">
                <a class="button-link" href="/gestionPeliculas">Gestionar peliculas</a>
                <a class="button-link" href="/gestionSalas">Gestionar salas</a>
                <a class="button-link" href="/logout">Cerrar Sesión</a>
            </div>
        </div>
    </body>
</html>
<<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" type="text/css" href="./css/styles.css">
        <style>
            /* Por alguna razon esto no funciona si lo adquiero desde el archivo css */
            .button-link {
                display: inline-block;
                padding: 18px 25px;
                background-color: white; /* color de fondo del botón */
                color: black; /* color del texto del botón */
                text-decoration: none; /* elimina el subrayado */
                border-radius: 15px; /* esquinas redondeadas */
                transition: background-color 0.3s ease; /* animación al pasar el cursor */
                margin: 10px 1px 1px 1px;
                
            }

            .button-link:hover {
                background-color: #45a049; /* color de fondo del botón al pasar el cursor */
            }
        </style>
    </head>
    <body class="body-style">
        <div class="container-style">
            <div class="navbar-style">
                <h1 style="margin:auto;">Menu de administrador</h1>
            </div>
            <div class="button-container">
                <a class="button-link" href="/gestionPeliculas">Gestionar peliculas</a>
                <a class="button-link" href="/gestionSalas">Gestionar salas</a>
                <a class="button-link" href="/logout">Cerrar Sesión</a>
            </div>
        </div>
    </body>
</html>

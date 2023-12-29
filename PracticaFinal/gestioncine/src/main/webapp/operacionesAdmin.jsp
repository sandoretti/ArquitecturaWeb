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
    </head>
    <body>
        <h1>Hello!</h1>
        <% cliente = (Cliente) session.getAttribute("usuario"); %>
        <p>Hola <%=  cliente.getNombre() %>, ¿Cómo estas? </p>
        <a href="/gestionPeliculas">Gestionar peliculas</a>
        <a href="/gestionSalas">Gestionar salas</a>
        <a href="/logout">Cerrar Sesión</a>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="es.uah.grupo2.gestioncine.app.model.Cliente" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administracion</title>
    </head>
    <body>
        <h1>Hello!</h1>
        <% Cliente cliente = (Cliente) session.getAttribute("usuario"); %>
        <p>Hola <%=  cliente.getNombre() %>, ¿Cómo estas? </p>
    </body>
</html>

<%-- 
    Document   : sesionEje2
    Created on : 7 dic 2023, 18:39:12
    Author     : flapv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
    <head>
        <title> Ejemplo de Sesión </title>
    </head>
    <body>
    <center> <h1>Ejemplo de Sesión</h1>
        Hola, <%=session.getAttribute("Nombre")%>
        Bienvenido a la página 2
    </body>
</HTML>

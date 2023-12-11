<%-- 
    Document   : sesionEje1
    Created on : 7 dic 2023, 18:38:10
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
        Bienvenido a la página 1
    </body>
</HTML>

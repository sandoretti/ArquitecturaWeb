<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crear cuenta</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            String error = (String) session.getAttribute("error");
            if(error != null) {
                out.println("<div>Error: ".concat(error).concat("</div>"));
            }
        %>
        
        <form action="/signup" method="POST">
            Nombre:
            <input type="text" name="nombre">
            Apellido:
            <input type="text" name="apellido">
            Email:
            <input type="email" name="email">
            Password:
            <input type="password" name="passwd">
            <button>Enviar</button>
        </form>
    </body>
</html>
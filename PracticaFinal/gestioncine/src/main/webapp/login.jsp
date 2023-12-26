<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            String error = (String) session.getAttribute("error");
            if(error != null) {
                out.println("<div>Error: ".concat(error).concat("</div>"));
                session.removeAttribute("error");
            }
            
            String success = (String) session.getAttribute("success");
            if(success != null) {
                out.println("<div>Success: ".concat(success).concat("</div>"));
                session.removeAttribute("success");
            }
        %>
        <<h1>Iniciar sesión</h1>
        <form action="/login" method="POST">
            Email
            <input type="email" name="email">
            Password:
            <input type="password" name="passwd">
            <button>Enviar</button>
        </form>
    </body>
</html>

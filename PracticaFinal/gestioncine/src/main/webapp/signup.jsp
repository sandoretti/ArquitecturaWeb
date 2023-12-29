<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crear cuenta</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./css/styles.css">
    </head>
    <body class="body-style">
        <div class="container-style">
            <%
                String error = (String) session.getAttribute("error");
                if(error != null) {
                    out.println("<div>Error: ".concat(error).concat("</div>"));
                    session.removeAttribute("error");
                }
            %>
            <h1>Crear cuenta</h1>
            <div class="form-container">
                <form action="/signup" method="POST">
                    Nombre:
                    <input class="form-input" type="text" name="nombre">
                    Apellido:
                    <input class="form-input" type="text" name="apellido">
                    Email:
                    <input class="form-input" type="email" name="email">
                    Password:
                    <input class="form-input" type="password" name="passwd">
                    <button class="button-style">Crear cuenta</button>
                </form>
            </div>
        </div>
    </body>
</html>
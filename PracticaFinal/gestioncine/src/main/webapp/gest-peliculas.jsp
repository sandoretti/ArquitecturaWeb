<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Gestionar peliculas</title>
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
    %>
    <h1>Gestionar peliculas</h1>
    <a href="/crear-pelicula">Crear pelicula</a>
</body>
</html>

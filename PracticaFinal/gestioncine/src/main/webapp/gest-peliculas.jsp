<%@ page import="es.uah.grupo2.gestioncine.app.model.Pelicula" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.PeliculaDAO" %>
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

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Género</th>
            <th>Año</th>
            <th>Clasificación</th>
            <th>Editar</th>
            <th>Eliminar</th>
        </tr>
        </thead>
        <tbody>
    <%
        List<Pelicula> peliculasList = PeliculaDAO.selectPeliculasIdNombGenAnoClas();
        if (peliculasList != null && !peliculasList.isEmpty()) {
            for (Pelicula pelicula: peliculasList){
    %>
                <tr>
                    <td><%=pelicula.getId()%></td>
                    <td><%=pelicula.getNombre()%></td>
                    <td><%=pelicula.getGenero()%></td>
                    <td><%=pelicula.getAno()%></td>
                    <td><%=pelicula.getClasificacionEdad()%></td>
                    <td><a href="">Editar</a></td>
                    <td><a href="">Eliminar</a></td>
                </tr>
    <%
            }
        }
    %>
        </tbody>
    </table>



</body>
</html>

<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Pelicula" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Peliculas</title>
</head>
<body>
    <h1>Peliculas</h1>
    <%
        List<Pelicula> peliculaList = null;

        try {
            peliculaList = PeliculaDAO.selectPeliculasIdNombrePortada();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (peliculaList != null) {
            for (Pelicula pelicula: peliculaList) {
    %>
    <div>
        <img height="400" width="270" src="/imagenes/uploads/<%=pelicula.getPortad()%>" alt="<%=pelicula.getNombre()%>">
        <a href="/pelicula/<%=pelicula.getId()%>"><%=pelicula.getNombre()%></a>
    </div>
    <%
            }
        }
    %>

</body>
</html>

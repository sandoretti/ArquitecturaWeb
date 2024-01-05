<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Pelicula" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.dao.SalaDAO" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Sala" %>
<%@ page import="java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
    <title>Crear proyeccion</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="./css/styles.css"> <!-- Añade esta línea -->
</head>
<body class="body-style">
<%
    String error = (String) session.getAttribute("error");
    if(error != null) {
        out.println("<div>Error: ".concat(error).concat("</div>"));
        session.removeAttribute("error");
    }
%>
<div style="max-width:40%; margin:5px auto;" class="navbar-style">
    <h1 style="margin: 5px 5px 5px 5px;">Añadir proyeccion</h1>
    <div>
        <a href="/gestionProyecciones" class="button-link" style="margin: 5px 5px 5px 5px;">Volver a gestion proyecciones</a>
    </div>
</div>
<div class="form-container">
    <form action="/crearProyeccion" method="POST" >
        <div>
            <label for="pelicula">Seleccionar pelicula:<br></label>
            <select name="pelicula" id="pelicula">
                <%
                    List<Pelicula> peliculas = null;

                    try {
                        peliculas = PeliculaDAO.selectPeliculasIdNombGenAnoClas();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    if(peliculas != null){
                        for(Pelicula pelicula: peliculas){
                %>
                <option value="<%=pelicula.getId()%>"><%=pelicula.getNombre()%></option>
                <%
                        }
                    }
                %>
            </select>
        </div>
        <br>
        <div>
            <label for="sala">Seleccionar sala:<br></label>
            <select name="sala" id="sala">
                <%
                    SalaDAO salaDAO = new SalaDAO();
                    Connection conn = salaDAO.getConnection();
                    List<Sala> salas = salaDAO.mostrarSalas(conn);

                    if(salas != null){
                        for(Sala sala: salas){
                %>
                <option value="<%=sala.getId()%>"><%=sala.getNombreSala()%></option>
                <%
                        }
                    }
                %>
            </select>
        </div>
        <br>
        <div>
            <label for="fechahora">Fecha y hora:<br></label>
            <input type="datetime-local" id="fechahora" name="fechahora">
        </div>
        <button class="button-style">Crear</button>
    </form>
</div>

</body>
</html>

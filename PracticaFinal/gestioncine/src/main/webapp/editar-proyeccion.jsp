<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Proyeccion" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Pelicula" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.dao.SalaDAO" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Sala" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar proyeccion</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body class="body-style">
<%
    String error = (String) session.getAttribute("error");
    if(error != null) {
        out.println("<div>Error: ".concat(error).concat("</div>"));
        session.removeAttribute("error");
    }

    Proyeccion proyeccion = (Proyeccion) request.getAttribute("proyeccion");
%>
<div class="navbar-style" style="margin:auto; padding: 5px 5px 5px 5px; max-width: 40%;">
    <h1 style="margin:auto 15px auto;">Editar proyeccion</h1>
    <div>
        <a href="/gestionProyecciones" class="button-link" style="margin: 5px 5px 5px 5px;">Volver a gestion proyecciones</a>
    </div>
</div>
<div class="container-style">
    <form style="margin-top:10px" class="form-container" action="/editarProyeccion/<%=proyeccion.getId()%>" method="POST">
        Pelicula
        <select name="pelicula" id="pelicula">
            <%
                List<Pelicula> peliculas = (List<Pelicula>) request.getAttribute("peliculas");
                int idPelicula = proyeccion.getIdPelicula();

                if(peliculas != null){
                    for(Pelicula pelicula: peliculas){
            %>
            <option value="<%=pelicula.getId()%>" <%if (idPelicula == pelicula.getId()) out.println("selected");%>><%=pelicula.getNombre()%></option>
            <%
                    }
                }
            %>
        </select>
        <label for="sala">Salas</label>
        <select name="sala" id="sala">
            <%
                List<Sala> salas = (List<Sala>) request.getAttribute("salas");

                int idSala = proyeccion.getIdSala();

                if(salas != null){
                    for(Sala sala: salas){
            %>
            <option value="<%=sala.getId()%>" <%if (idSala == sala.getId()) out.println("selected");%>><%=sala.getNombreSala()%></option>
            <%
                    }
                }
            %>
        </select>
        <label for="fechahora">Fecha y hora</label>
        <%
            Date fechaHora = proyeccion.getFechaHora();

            String fechaHoraStr = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(fechaHora);
        %>
        <input type="datetime-local" id="fechahora" name="fechahora" value="<%=fechaHoraStr%>">
        <input type="hidden" name="id" value="<%=proyeccion.getId()%>">
        <button>Editar proyeccion</button>
    </form>
</div>
</body>
</html>

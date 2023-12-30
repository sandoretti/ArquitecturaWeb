<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="es.uah.grupo2.gestioncine.app.model.ActorDAO" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.Actor" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.Pelicula" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar pelicula</title>
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

    Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
%>
<h1>Editar pelicula</h1>
<img src="/imagenes/uploads/<%=pelicula.getPortad()%>" alt="<%=pelicula.getNombre()%>">
<form action="/editarPelicula/<%=pelicula.getId()%>" method="POST">
    Nombre:
    <input type="text" name="nombre" value="<%=pelicula.getNombre()%>"><br>
    Sinopsis:
    <input type="text" name="sinopsis" value="<%=pelicula.getSipnosis()%>"><br>
    Página oficial:
    <input type="text" name="pagina" value="<%=pelicula.getPagina()%>"><br>
    Título original:
    <input type="text" name="titulo" value="<%=pelicula.getTitulo()%>"><br>
    Género:
    <input type="text" name="genero" value="<%=pelicula.getGenero()%>"><br>
    Nacionalidad:
    <input type="text" name="nacionalidad" value="<%=pelicula.getNacionalidad()%>"><br>
    Duración:
    <input type="number" name="duracion" value="<%=pelicula.getDuracion()%>"><br>
    Año:
    <input type="number" name="ano" value="<%=pelicula.getAno()%>"><br>
    Distribuidora:
    <input type="text" name="distribuidora" value="<%=pelicula.getDistribuidora()%>"><br>
    Director:
    <input type="text" name="director" value="<%=pelicula.getDirector()%>"><br>
    Otros datos:
    <input type="text" name="otros" value="<%=pelicula.getOtrosDatos()%>"><br>
    Clasificación de edad:
    <input type="text" name="clasificacion" value="<%=pelicula.getClasificacionEdad()%>"><br>
    Actores:
    <div>
        <%
            List<Actor> actores = ActorDAO.obtenerActores();
            List<Actor> actoresPelicula = pelicula.getActores();
            if (actores != null){
                for(Actor actor: actores){
        %>
        <input type="checkbox" name="actores" <%if (actoresPelicula.contains(actor)) out.println("checked");%>
               value="<%=actor.getId()%>"><%=actor.getNombre()%> <%=actor.getApellido()%><br>
        <%
                }
            }
        %>
    </div>
    <input type="hidden" name="id" value="<%=pelicula.getId()%>">
    <button>Editar pelicula</button>
</form>
</body>
</html>

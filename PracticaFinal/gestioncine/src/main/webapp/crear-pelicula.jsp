<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="es.uah.grupo2.gestioncine.app.model.ActorDAO" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.Actor" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Crear pelicula</title>
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
    <h1>Crear cuenta</h1>
    <form action="/crear-pelicula" method="POST" enctype="multipart/form-data">
        Nombre:
        <input type="text" name="nombre"><br>
        Sinopsis:
        <input type="text" name="sinopsis"><br>
        Página oficial:
        <input type="text" name="pagina"><br>
        Título original:
        <input type="text" name="titulo"><br>
        Género:
        <input type="text" name="genero"><br>
        Nacionalidad:
        <input type="text" name="nacionalidad"><br>
        Duración:
        <input type="number" name="duracion"><br>
        Año:
        <input type="number" name="ano"><br>
        Distribuidora:
        <input type="text" name="distribuidora"><br>
        Director:
        <input type="text" name="director"><br>
        Otros datos:
        <input type="text" name="otros"><br>
        Clasificación de edad:
        <input type="text" name="clasificacion"><br>
        Portada:
        <input type="file" name="portada"><br>
        Actores:
        <div>
        <%
            List<Actor> actores = ActorDAO.obtenerActores();
            if (actores != null){
                for(Actor actor: actores){
                    out.println("<input type=\"checkbox\" name=\"actores\" value=\""
                            + actor.getId() + "\">" + actor.getNombre() + " "
                            + actor.getApellido() + "<br>"
                    );
                }
            }
        %>
        </div>
        <button>Crear pelicula</button>
    </form>
    </body>
</html>
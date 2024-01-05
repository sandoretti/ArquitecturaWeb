<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="es.uah.grupo2.gestioncine.app.model.dao.ActorDAO" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Actor" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
    <title>Crear pelicula</title>
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
        <h1 style="margin: 5px 5px 5px 5px;">Añadir película</h1>
        <div>
            <a href="/gestionPeliculas" class="button-link" style="margin: 5px 5px 5px 5px;">Volver a gestion películas</a>
        </div>
    </div>
   <form action="/crearPelicula" method="POST" class="form-container">
        Nombre:
        <input type="text" name="nombre"><br>
        Sinopsis:
        <input type="text" name="sinopsis"><br>
        Página oficial:
        <input type="text" name="pagina"><br>
        Título original:
        <input type="text" name="titulo"><br>
        Género:
           <select name="genero">
               <%
                   List<String> generos = (List<String>) request.getAttribute("generos");
                   if (generos != null){
                       for (String genero: generos){
               %>
               <option value="<%=genero%>"><%=genero%></option>
               <%
                        }
                   }
               %>
           </select><br><br>
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
        <input type="text" name="portada"><br>
        Actores:
        <div>
        <%
            List<Actor> actores = null;

            try {
                actores = ActorDAO.obtenerActores();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (actores != null){
                for(Actor actor: actores){
                    out.println("<input style='position:relative; top:27px;' type=\"checkbox\" name=\"actores\" value=\""
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
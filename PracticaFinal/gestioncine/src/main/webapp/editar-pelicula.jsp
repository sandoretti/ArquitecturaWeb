<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="es.uah.grupo2.gestioncine.app.model.dao.ActorDAO" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Actor" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Pelicula" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar pelicula</title>
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

            Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
        %>
        <div class="navbar-style" style="margin:auto; padding: 5px 5px 5px 5px; max-width: 40%;">
            <!-- TODO: IMAGEN DE LA PELICULA PONERLA A LA IZQUIERDA DEL FORMULARIO -->
            <h1 style="margin:auto 15px auto;">Editar pelicula</h1>
            <div>
                <a href="/gestionPeliculas" class="button-link" style="margin: 5px 5px 5px 5px;">Volver a gestion películas</a>
            </div>
        </div>
        <div class="container-style">
            <img src="<%=pelicula.getPortad()%>" style="width: 140px; height: 200px;" alt="<%=pelicula.getNombre()%>">
            <form style="margin-top:10px" class="form-container" action="/editarPelicula/<%=pelicula.getId()%>" method="POST">
                Nombre:
                <input type="text" name="nombre" value="<%=pelicula.getNombre()%>"><br>
                Sinopsis:
                <input type="text" name="sinopsis" value="<%=pelicula.getSipnosis()%>"><br>
                Página oficial:
                <input type="text" name="pagina" value="<%=pelicula.getPagina()%>"><br>
                Título original:
                <input type="text" name="titulo" value="<%=pelicula.getTitulo()%>"><br>
                Género:
                <select name="genero">
                    <%
                        List<String> generos = (List<String>) request.getAttribute("generos");
                        if (generos != null){
                            for (String genero: generos){
                    %>
                    <option value="<%=genero%>" <%if (genero.equals(pelicula.getGenero())) out.print("selected");%>><%=genero%></option>
                    <%
                            }
                        }
                    %>
                </select><br><br>
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
                Portada:
                <input type="text" name="portada" value="<%=pelicula.getPortad()%>"><br>
                Actores:
                <div>
                    <%
                        List<Actor> actoresPelicula = pelicula.getActores();
                        List<Actor> actores = null;

                        try {
                            actores = ActorDAO.obtenerActores();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        if (actores != null){
                            for(Actor actor: actores){
                    %>
                    <input type="checkbox" name="actores" <%if (actoresPelicula.contains(actor)) out.print("checked");%>
                           value="<%=actor.getId()%>"><%=actor.getNombre()%> <%=actor.getApellido()%><br>
                    <%
                            }
                        }
                    %>
                </div>
                <input type="hidden" name="id" value="<%=pelicula.getId()%>">
                <button>Editar pelicula</button>
            </form>
        </div>
    </body>
</html>

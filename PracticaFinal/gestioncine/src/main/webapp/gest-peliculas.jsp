<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Pelicula" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Gestionar peliculas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./css/styles.css">
        <script src="./javaScript/scripts.js"></script>
    </head>
    <body class="body-style">
        <%
            String error = (String) session.getAttribute("error");
            String success = (String) session.getAttribute("success");
        %>

        <script>
           mensajeGestion('<%=error%>','<%=success%>');
        </script>

        <% 
           //Necesario para que no salga repetidamente cualquier mensaje
           //referente a esto, al recargar una pagina, en caso de que no
           //sean null.
           session.setAttribute("error", null);
           session.setAttribute("success", null);
        %>

        <div class="navbar-style" style="margin:auto; padding: 5px 5px 5px 5px;">
            <h1 style="margin:auto 15px auto;">Gestionar peliculas</h1>
            <div>
                <a href="/crearPelicula" class="button-link" style="margin: 5px 5px 5px 5px; ">Crear pelicula</a>
                <a href="/perfil" class="button-link" style="margin: 5px 5px 5px 5px;">Volver al menú</a>
            </div>

        </div>


        <table class="table-style">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Género</th>
                <th>Año</th>
                <th>Clasificación</th>

            </tr>
            </thead>
            <tbody>
        <%
            List<Pelicula> peliculasList = null;

            try {
                peliculasList = PeliculaDAO.selectPeliculasIdNombGenAnoClas();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (peliculasList != null && !peliculasList.isEmpty()) {
                for (Pelicula pelicula: peliculasList){
        %>
                    <tr>
                        <td><%=pelicula.getId()%></td>
                        <td><%=pelicula.getNombre()%></td>
                        <td><%=pelicula.getGenero()%></td>
                        <td><%=pelicula.getAno()%></td>
                        <td><%=pelicula.getClasificacionEdad()%></td>
                        <td style="border: none;"><a class="link-style" href="/editarPelicula/<%=pelicula.getId()%>">Editar</a></td>
                        <td style="border: none;"><a class="link-style" href="/eliminarPelicula/<%=pelicula.getId()%>" onclick="return confirm('¿Estas seguro que quieres eliminar?')">Eliminar</a></td>
                    </tr>
        <%
                }
            } 
        %>
            </tbody>
        </table>
        <!-- div donde se muestra el mensaje de error o exito -->
        <div id="message" class="message-style"></div>


    </body>
</html>

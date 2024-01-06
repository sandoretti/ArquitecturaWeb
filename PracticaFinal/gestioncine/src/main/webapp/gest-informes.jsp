<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Pelicula" %>
<%@ page import="java.util.HashMap" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Gestionar informes</title>
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
    <h1 style="margin:auto 15px auto;">Gestionar informes</h1>
    <div>
        <a href="/perfil" class="button-link" style="margin: 5px 5px 5px 5px;">Volver al menú</a>
    </div>
</div>
<h1 style="text-align: center">Peliculas por género</h1>
<div class="table-div">
<%
    HashMap<String, List<Pelicula>> peliculasGeneros = (HashMap<String, List<Pelicula>>) request.getAttribute("peliculasGen");

    if (peliculasGeneros != null && !peliculasGeneros.isEmpty()) {
        for (String genero: peliculasGeneros.keySet()){
            List<Pelicula> peliculas = peliculasGeneros.get(genero);
%>
    <div>
        <h2 style="text-align: center"><%=genero%></h2>
        <table class="table-style">
            <thead>
                <tr>
                    <th>Nombre</th>
                </tr>
            </thead>
            <tbody>
    <%
                for(Pelicula pelicula: peliculas) {
    %>
                <tr><td><%=pelicula.getNombre()%></td></tr>
    <%
                }
    %>
            </tbody>
        </table>
    </div>
    <%
            }
        }
    %>
</div>
<!-- div donde se muestra el mensaje de error o exito -->
<div id="message" class="message-style"></div>


</body>
</html>

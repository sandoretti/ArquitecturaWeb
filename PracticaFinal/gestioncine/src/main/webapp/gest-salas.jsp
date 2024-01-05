<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Sala" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar salas</title>
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
        <div class="navbar-style" style="max-width: 65%; margin:auto; padding: 5px 5px 5px 5px;">
            <h1 style="margin:auto 15px auto;">Gestiona las salas admin</h1>
            <div>
                <a class="button-link" style="margin: 5px 5px 5px 5px" href="/crearSala">Crear nueva sala</a>
                <a href="/perfil" class="button-link" style="margin: 5px 5px 5px 5px;">Volver al menú</a>
            </div>
        </div>
        
        <table class="table-style" style="max-width: 60%">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Filas</th>
                    <th>Columnas</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Sala> salaList = (List<Sala>) session.getAttribute("salas");
                    if (salaList != null && !salaList.isEmpty()) {
                        for (Sala salita: salaList){
                %>
                <tr>
                    <td><%=salita.getId()%></td>
                    <td><%=salita.getNombreSala()%></td>
                    <td><%=salita.getFila()%></td>
                    <td><%=salita.getColumna()%></td>
                    <td style="border: none; text-align:center; vertical-align: middle"><a class="link-style" href="/editarSala/<%=salita.getId()%>">Editar</a></td>
                    <td style="border: none;"><a class="link-style" href="/eliminarSala/<%=salita.getId()%>" onclick="return confirm('¿Estas seguro que quieres eliminar esta sala?')">Eliminar</a></td>
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

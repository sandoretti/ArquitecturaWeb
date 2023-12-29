<%@ page import="es.uah.grupo2.gestioncine.app.model.Sala" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.SalaDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar salas</title>
    </head>
    <body>
        <%
        String error = (String) session.getAttribute("error");
        if(error != null) {
            out.println("<div>Error: ".concat(error).concat("</div>"));
            session.removeAttribute("error");
        }

        String success = (String) session.getAttribute("success");
        if(success != null) {
            out.println("<div>Success: ".concat(success).concat("</div>"));
            session.removeAttribute("success");
        }
        %>
        <h1>Gestiona las salas admin</h1>
        <a href="/crearSala">Crear nueva sala</a>
        <table>
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
                    <td><a href="/editarSala/<%=salita.getId()%>">Editar</a></td>
                    <td><a href="/eliminarSala/<%=salita.getId()%>" onclick="return confirm('¿Estas seguro que quieres eliminar esta sala?')">Eliminar</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </body>
</html>

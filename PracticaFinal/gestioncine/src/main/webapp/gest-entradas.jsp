<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Entrada" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%List<Entrada> entradas = (List<Entrada>) request.getAttribute("entradas");%>
<%int idProyeccion = (int) request.getAttribute("proyeccion");%>
<!DOCTYPE html>
<html>
    <head>
        <title>Gestionar entradas <%=idProyeccion%></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/css/styles.css">
        <script src="/javaScript/scripts.js"></script>
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
            <h1 style="margin:auto 15px auto;">Gestionar entradas de proyeccion <%=idProyeccion%></h1>
            <div>
                <a href="/gestionProyecciones" class="button-link" style="margin: 5px 5px 5px 5px;">Volver a proyecciones</a>
                <a href="/perfil" class="button-link" style="margin: 5px 5px 5px 5px;">Volver al menú</a>
            </div>

        </div>

        <table class="table-style">
            <thead>
            <tr>
                <th>ID</th>
                <th>Fila</th>
                <th>Columna</th>
                <th>Estado</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (entradas != null){
                    for (Entrada entrada: entradas) {
            %>
            <tr>
                <td><%=entrada.getId()%></td>
                <td><%=entrada.getFila()%></td>
                <td><%=entrada.getColumna()%></td>
                <td><%
                    switch (entrada.getIdReserva()){
                        case 0:
                            out.print("Sin reserva");
                            break;
                        case 1:
                            out.print("Descartado");
                            break;
                        default:
                            out.print("Reservado");
                    }
                %></td>
                <td style="border: none;"><a class="link-style" href="/cambiarEntrada/<%=entrada.getId()%>"><%
                    switch (entrada.getIdReserva()){
                        case 0:
                            out.print("Descartar");
                            break;
                        case 1:
                            out.print("Habilitar");
                            break;
                        default:
                            out.print("Quitar reserva");
                    }
                %></a>
                </td>
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

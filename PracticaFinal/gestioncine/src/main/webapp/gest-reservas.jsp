<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Reserva" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Gestionar reservas</title>
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
    <h1 style="margin:auto 15px auto;">Gestionar reservas</h1>
    <div>
        <a href="/perfil" class="button-link" style="margin: 5px 5px 5px 5px;">Volver al menú</a>
    </div>

</div>


<table class="table-style">
    <thead>
    <tr>
        <th>ID</th>
        <th>Referencia</th>
        <th>Precio</th>
        <th>Num Tarjeta</th>
        <th>ID Cliente</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Reserva> reservaList = (List<Reserva>) request.getAttribute("reservas");

        if (reservaList != null && !reservaList.isEmpty()) {
            for (Reserva reserva: reservaList){
    %>
    <tr>
        <td><%=reserva.getId()%></td>
        <td><%=reserva.getReferenciaReserva()%></td>
        <td><%=reserva.getPrecio()%></td>
        <td><%=reserva.getNumeroTarjeta()%></td>
        <td><%=reserva.getIdCliente()%></td>
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

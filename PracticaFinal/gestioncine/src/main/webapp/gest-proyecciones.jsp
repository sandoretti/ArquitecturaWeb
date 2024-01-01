<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Proyeccion" %>
<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.dao.ProyeccionDAO" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gestionar proyecciones</title>
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
    <h1 style="margin:auto 15px auto;">Gestionar proyecciones</h1>
    <div>
        <a href="/crearProyeccion" class="button-link" style="margin: 5px 5px 5px 5px; ">Crear proyección</a>
        <a href="/perfil" class="button-link" style="margin: 5px 5px 5px 5px;">Volver al menú</a>
    </div>

</div>


<table class="table-style">
    <thead>
    <tr>
        <th>ID</th>
        <th>Pelicula</th>
        <th>Sala</th>
        <th>Fecha y hora</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Proyeccion> proyecciones = null;

        try {
            proyecciones = ProyeccionDAO.obtenerProyecciones();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (proyecciones != null) {
            for (Proyeccion proyeccion: proyecciones){
    %>
    <tr>
        <td><%=proyeccion.getId()%></td>
        <td><%=proyeccion.getNombrePelicula()%></td>
        <td><%=proyeccion.getNombreSala()%></td>
        <td><%=proyeccion.getFechaHora()%></td>
        <td style="border: none;"><a class="link-style" href="/editarProyeccion/<%=proyeccion.getId()%>">Editar</a></td>
        <td style="border: none;"><a class="link-style" href="/eliminarProyeccion/<%=proyeccion.getId()%>" onclick="return confirm('¿Estas seguro que quieres eliminar?')">Eliminar</a></td>
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
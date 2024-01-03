<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Cliente" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./css/styles.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body class="body-style">
    <div class="banner-style banner-left-style"></div> <!-- Banner izquierdo -->
    <div class="banner-style banner-right-style"></div> <!-- Banner derecho -->
    <div class="container-style">
        <div class="navbar-style"> <!-- Insertar enlaces a ventanas -->
            <div class="logo-style">50CINES</div>
            <a class="link-style nav-item-style" href="./">Inicio</a>
            <a class="link-style nav-item-style" href="peliculas">Peliculas</a>
            <% if(session.getAttribute("usuario") == null) { %>
                <a class="link-style nav-item-style" href="/signup">Registro</a>
                <a class="link-style nav-item-style" href="/login">Inicio Sesión</a>
            <% } else { %>
                <% Cliente cliente = (Cliente) session.getAttribute("usuario"); 
                        if (cliente.isAdmin())
                        request.getRequestDispatcher(request.getContextPath() + "./perfil").forward(request, response);
                %>
                <a class="link-style nav-item-style" href="/logout">Cerrar Sesión</a>
            <% } %>
        </div>
        <div class="header-style">
            <img class="header-img-style" src="./imagenes/Sala_Cine.jpg" alt="Cine">
        </div>
        <div class="columns-container-style">
            <div class="column-style">
                <h2>Novedades</h2>
                <p>Las mejores películas del momento.</p>
            </div>
            <div class="column-style">
                <h2>Clasicos</h2>
                <p>Reposiciones de películas clasicas. Para los más nostalgicos</p>
            </div>
            <div class="column-style">
                <h2>Familiar</h2>
                <p>Películas para ver en familia. Desde los más pequeños a los mas mayores.</p>
            </div>
        </div>
        <div class="footer-style">
            <p>© 2023 50CINES. Todos los derechos reservados.</p>
            <p> Propiedad intelectual del Grupo 2 de Arquitectura y Diseño de sistemas Web y C/S</p>
            <p> Cualquier duda por favor remitase a cualquier local de nuestra franquicia para consulta o llame al 999999999 </p>
        </div>
    </div>
</body>
</html>


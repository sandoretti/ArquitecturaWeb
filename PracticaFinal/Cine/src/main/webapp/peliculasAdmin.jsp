<%-- 
    Document   : peliculas
    Created on : 31 dic 2023, 5:03:04
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="grupo2.modelo.Pelicula" %>

<!-- Otras importaciones y configuraciones necesarias -->

<html lang="es" class="no-js">
<%@include file="componentsAdmin/head.jsp"%>
<body>
    <%@include file="componentsAdmin/preloading.jsp"%>
    <%@include file="componentsAdmin/login.jsp"%>
    <%@include file="componentsAdmin/singup.jsp"%>
    <%@include file="componentsAdmin/header.jsp"%>

    <div class="hero common-hero">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="hero-ct">
                        <h1>Películas</h1>
                        <ul class="breadcumb">
                            <li class="active"><a href="#">Home</a></li>
                            <li> <span class="ion-ios-arrow-right"></span> Lista de Películas</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="page-single movie_list">
        <div class="container">
            <div class="row ipad-width2">
                <div id="results" class="movie-items">
                    <% 
                        List<Pelicula> peliculas = (List<Pelicula>) request.getAttribute("peliculas");
                        for (Pelicula pelicula : peliculas) {
                    %>
                        <div class="col-md-12 col-lg-12 col-xl-6">
                            <div class="movie-item">
                                <div class="mv-img">
                                    <img src="<%= pelicula.getPortada() %>" alt="<%= pelicula.getNombre() %>">
                                </div>
                                <div class="title-in">
                                    <div class="cate">
                                        <span class="blue"><%= pelicula.getGenero() %></span>
                                    </div>
                                    <h6><a href="single.html"><%= pelicula.getTitulo() %></a></h6>
                                    <p><i class="ion-android-star"></i><span><%= pelicula.getClasificacionEdad() %></span> / <%= pelicula.getDuracion() %> min</p>
                                    <p> <%= pelicula.getDirector() %> (dir.), <%= pelicula.getAno() %></p>
                                    <p><%= pelicula.getSinopsis() %></p>
                                </div>
                            </div>
                        </div>
                    <% } %>
                </div>
            </div>
        </div>
    </div>

    <%@include file="componentsAdmin/footer.jsp"%>
</body>
</html>








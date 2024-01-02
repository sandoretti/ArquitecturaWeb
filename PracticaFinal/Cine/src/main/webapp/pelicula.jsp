<%-- 
    Document   : pelicula
    Created on : 31 dic 2023, 5:10:37
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="grupo2.modelo.Pelicula" %>
<%@ page import="grupo2.modelo.Actor" %>
<%@ page import="grupo2.modelo.Comentario" %>

<html lang="es" class="no-js">
    <%@include file="components/head.jsp"%>
    <body>
        <%@include file="components/preloading.jsp"%>
        <%@include file="components/login.jsp"%>
        <%@include file="components/singup.jsp"%>
        <%@include file="components/header.jsp"%>

        <div class="hero mv-single-hero">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                    </div>
                </div>
            </div>
        </div>

        <%
        // Declaraciónes
        Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
        List<Actor> actores = pelicula.getActores();
        List<Comentario> comentarios = pelicula.getComentarios();
        %>

        <div class="page-single movie-single movie_single">
            <div class="container">
                <div class="row ipad-width2">
                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="movie-img sticky-sb">
                            <img src="<%= pelicula.getPortada() %>" alt="<%= pelicula.getNombre() %>">
                            <div class="movie-btn">
                                <div class="btn-transform transform-vertical red">
                                    <div><a href="#" class="item item-1 redbtn"> <i class="ion-play"></i> Ver Trailer</a></div>
                                    <div><a href="<%=pelicula.getTrailer()%>" class="item item-2 redbtn fancybox-media hvr-grow"><i class="ion-play"></i></a></div>
                                </div>
                                <div class="btn-transform transform-vertical">
                                    <div><a href=proyecciones" class="item item-1 yellowbtn"> <i class="ion-card"></i> Hacer reserva</a></div>
                                    <div><a href="pelicula?id=<%= pelicula.getId() %>&to=reserva" class="item item-2 yellowbtn"><i class="ion-card"></i></a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8 col-sm-12 col-xs-12">
                        <div class="movie-single-ct main-content">
                            <h1 class="bd-hd"><%= pelicula.getNombre() %> <span><%= pelicula.getAno() %></span></h1>

                            <div class="movie-tabs">
                                <div class="tabs">
                                    <div class="cate">
                                        <span class="green"><a><%= pelicula.getClasificacionEdad() %></a></span>
                                    </div>
                                    <ul class="tab-links tabs-mv">
                                        <li class="active"><a href="#overview">Visión general</a></li>
                                        <li><a href="#reviews"> Comentarios</a></li>
                                    </ul>
                                    <div class="tab-content">
                                        <div id="overview" class="tab active">
                                            <div class="row">
                                                <div class="col-md-8 col-sm-12 col-xs-12">
                                                    <p><%= pelicula.getSinopsis() %></p>
                                                    <div class="title-hd-sm">
                                                        <h4>Reparto</h4>
                                                    </div>


                                                    <!-- movie cast -->
                                                    <div class="mvcast-item">
                                                        <% 
                                                        for (Actor actor : actores) { 
                                                        %>
                                                        <div class="cast-it">
                                                            <div class="cast-left">
                                                                <img src="images/uploads/cast1.jpg" alt="">
                                                                <a href="#"><%= actor.getNombre() %><%= actor.getApellido() %></a>
                                                            </div>
                                                        </div>
                                                        <% } %>

                                                    </div>
                                                    <div class="title-hd-sm">
                                                        <h4>Comentarios</h4>
                                                    </div>
                                                    <!-- movie user review -->
                                                    <div class="mv-user-review-item">
                                                        <% 
                                                        for (Comentario comentario : comentarios) {
                                                        %>
                                                        <p class="time">
                                                            <%= comentario.getFecha() %> por <a href="#"> <%= comentario.getUsuario() %></a>
                                                        </p>
                                                        <p><%= comentario.getTexto() %></p>
                                                        <% } %>
                                                    </div>
                                                </div>
                                                <div class="col-md-4 col-xs-12 col-sm-12">
                                                    <div class="sb-it">
                                                        <h6><p><a href="<%= pelicula.getPagina() %>">Página oficial</a></p></h6>
                                                    </div>
                                                    <div class="sb-it">
                                                        <h6>Director: </h6>
                                                        <p><%= pelicula.getDirector() %></p>
                                                    </div>
                                                    <div class="sb-it">
                                                        <h6>Género:</h6>
                                                        <p><%= pelicula.getGenero() %> </p>
                                                    </div>
                                                    <div class="sb-it">
                                                        <h6>Año de lanzamiento:</h6>
                                                        <p><%= pelicula.getAno() %></p>
                                                    </div>
                                                    <div class="sb-it">
                                                        <h6>Duración:</h6>
                                                        <p><%= pelicula.getDuracion() %> min</p>
                                                    </div>
                                                    <div class="sb-it">
                                                        <h6>Nacionalidad:</h6>
                                                        <p><%= pelicula.getNacionalidad() %></p>
                                                    </div>
                                                    <div class="sb-it">
                                                        <h6>Distribuidora</h6>
                                                        <p><%= pelicula.getDistribuidora() %></p>
                                                    </div>
                                                    <div class="sb-it">
                                                        <h6>Otros datos:</h6>
                                                        <p><%= pelicula.getOtrosDatos() %></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div id="reviews" class="tab review">
                                            <div class="row">
                                                <div class="rv-hd">
                                                    <div class="div">
                                                        <h2><%= pelicula.getTitulo() %></h2>
                                                    </div>
                                                    <a href="comentario" class="redbtn" style="margin-right: 50px;" >Escribir comentario</a>
                                                </div>
                                                <div class="topbar-filter">
                                                    <p>Se han encontrado <span><%= comentarios.size() %> </span>comentarios en total</p>
                                                </div>
                                                <% 
                                                        for (Comentario comentario : comentarios) { 
                                                %>
                                                <div class="mv-user-review-item">
                                                    <div class="user-infor">
                                                        <img src="images/uploads/userava1.jpg" alt="">
                                                        <div>
                                                            <h3>Comentario de <%= comentario.getUsuario() %></h3>
                                                            <div class="no-star">
                                                                <i class="ion-android-star"></i>
                                                                <i class="ion-android-star"></i>
                                                                <i class="ion-android-star"></i>
                                                                <i class="ion-android-star"></i>
                                                                <i class="ion-android-star last"></i>
                                                            </div>
                                                            <p class="time">
                                                                <%= comentario.getFecha() %> por <a href="#"> <%= comentario.getUsuario() %></a>
                                                            </p>
                                                        </div>
                                                    </div>
                                                    <p><%= comentario.getTexto() %></p>
                                                </div>
                                                <% } %>
                                                <div class="topbar-filter">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="components/footer.jsp"%>
    </body>

</html>

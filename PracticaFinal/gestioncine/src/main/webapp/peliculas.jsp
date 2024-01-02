<%-- 
    Document   : peliculas
    Created on : 31 dic 2023, 5:03:04
    Author     : Jorge
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Pelicula" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.dao.PeliculaDAO" %>
<%@ page import="java.sql.SQLException" %>

<html lang="es" class="no-js">
    <%@include file="components/head.jsp"%>
    <body style="width: 100%; margin: 0 auto;">
        <%@include file="components/preloading.jsp"%>
        <%@include file="components/login.jsp"%>
        <%@include file="components/singup.jsp"%>
        <%@include file="components/header.jsp"%>
        <%@include file="components/hero.jsp"%>

        <div class="page-single movie_list">
            <div class="container">
                <div class="row ipad-width2">
                    <% 
                    List<Pelicula> peliculas = null;

                    try {
                        peliculas = PeliculaDAO.obtenerTodasLasPeliculas();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    %>


                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="topbar-filter">
                            <p>Se han encontrado <span><%= peliculas.size() %> </span> películas en total</p>
                        </div>
                        <% for (Pelicula pelicula : peliculas) { %>
                        <div class="movie-item-style-2">
                            <img src="<%= pelicula.getPortad() %>" alt="" style="width: 200px;">
                            <div class="mv-item-infor">
                                <h6><a href="pelicula?id=<%= pelicula.getId() %>"><%= pelicula.getNombre() %> <span>(<%= pelicula.getAno() %>)</span></a></h6>
                                <p class="describe"><%= pelicula.getSipnosis() %>.</p>
                                <p class="run-time"> Duración: <%= pelicula.getDuracion() %> min </p>
                                <p>Director: <a><%= pelicula.getDirector() %></a></p>
                            </div>
                        </div>
                        <% } %>
                        <div class="topbar-filter">
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="sidebar">
                            <div class="ads">
                                <img src="images/uploads/ads1.png" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="components/footer.jsp"%>
    </body>
</html>


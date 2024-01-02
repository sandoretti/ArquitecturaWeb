<%-- 
    Document   : reserva
    Created on : 2 ene 2024, 3:17:18
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="grupo2.modelo.Pelicula" %>
<%@ page import="grupo2.modelo.Proyeccion" %>

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
        List<Proyeccion> proyecciones = pelicula.getProyecciones();
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
                                        <li class="active"><a>Fechas disponibles</a></li>
                                    </ul>
                                    <div class="tab-content">
                                        <div id="overview" class="tab active">
                                            <div class="row">
                                                <div class="col-md-8 col-sm-12 col-xs-12">
                                                    <div class="topbar-filter">
                                                        <p>Se han encontrado <span><%= proyecciones.size() %> </span> fechas disponibles</p>
                                                    </div>
                                                    <% for (Proyeccion proyeccion : proyecciones) { %>
                                                    <div class="row">
                                                        <div class="col-md-6">
                                                            <div class="movie-item-style-2" style="margin-left: 50px;">
                                                                <div class="mv-item-infor">
                                                                    <h6><a><%= proyeccion.getNombreSala() %> </a></h6>
                                                                    <p class="run-time"> Día: <%= proyeccion.getFecha() %> </p>
                                                                    <p>Hora: <%= proyeccion.getHora() %></p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6 text-center">
                                                            <div class="cate">
                                                                <span class="blue"><a href="asientos.jsp" class="btn-ver-asientos">Ver asientos</a></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="topbar-filter">
                                                    </div>

                                                    <% } %>
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

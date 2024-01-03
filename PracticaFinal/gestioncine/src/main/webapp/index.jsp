<%-- 
    Document   : index
    Created on : 31 dic 2023, 4:54:47
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Pelicula" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Cliente" %>

<html lang="es" class="no-js">
    <%@include file="components/head.jsp"%>
    <body>
        <%@include file="components/preloading.jsp"%>
        <%@include file="components/header.jsp"%>

        <%
        List<Pelicula> peliculas = (List<Pelicula>) request.getAttribute("peliculas");

        // Verificar si la lista de películas está vacía
        if (peliculas == null || peliculas.isEmpty()) {
            // Redirigir al servlet
            response.sendRedirect("peliculas?from=index");
        }
        else {
            // Renderizar la lista de películas
        %>
        <div class="slider movie-items">
            <div class="container">
                <div class="row">
                    <div  class="slick-multiItemSlider">
                        <% 
                            for (Pelicula pelicula : peliculas) {
                        %>
                        <div class="movie-item">
                            <div class="mv-img">
                                <a href="pelicula?id=<%= pelicula.getId() %>"><img src="<%= pelicula.getPortad() %>" alt="" width="285" height="437"></a>
                            </div>
                            <div class="title-in">
                                <div class="cate">
                                    <span class="blue"><a><%= pelicula.getGenero() %></a></span>
                                </div>
                                <h6><a href="pelicula?id=<%= pelicula.getId() %>"><%= pelicula.getNombre() %></a></h6>
                                <!-- comment <p><i class="ion-android-star"></i><span>7.4</span> /10</p>-->
                            </div>
                        </div>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
        %>

        <div class="trailers">
            <div class="container">
                <div class="row ipad-width">
                    <div class="col-md-12">
                        <div class="title-hd">
                            <h2>Trailers</h2>
                        </div>
                        <div class="videos">
                            <div class="slider-for-2 video-ft">
                                <div>
                                    <iframe class="item-video" src="#" data-src="https://www.youtube.com/embed/1Q8fG0TtVAY"></iframe>
                                </div>
                                <div>
                                    <iframe class="item-video" src="#" data-src="https://www.youtube.com/embed/w0qQkSuWOS8"></iframe>
                                </div>
                            </div>

                            <div class="slider-nav-2 thumb-ft">
                                <div class="item">
                                    <div class="trailer-img">
                                        <img src="images/uploads/trailer7.jpg"  alt="photo by Barn Images" width="4096" height="2737">
                                    </div>
                                    <div class="trailer-infor">
                                        <h4 class="desc">Wonder Woman</h4>
                                        <p>2:30</p>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="trailer-img">
                                        <img src="images/uploads/trailer2.jpg"  alt="photo by Barn Images" width="350" height="200">
                                    </div>
                                    <div class="trailer-infor">
                                        <h4 class="desc">Oblivion: Official Teaser Trailer</h4>
                                        <p>2:37</p>
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



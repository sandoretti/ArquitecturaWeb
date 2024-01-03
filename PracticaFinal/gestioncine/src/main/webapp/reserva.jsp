<%-- 
    Document   : reserva
    Created on : 2 ene 2024, 3:17:18
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Pelicula" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Proyeccion" %>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Sala" %>

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
        // Declaraciones
        Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
        List<Proyeccion> proyecciones = pelicula.getProyecciones();
        // Sala sala = (Sala) request.getAttribute("sala");
        %>

        <div class="page-single movie-single movie_single">
            <div class="container">
                <div class="row ipad-width2">
                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="movie-img sticky-sb">
                            <img src="<%= pelicula.getPortad() %>" alt="<%= pelicula.getNombre() %>">
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
                                                                    <p class="run-time"> Fecha: <%= proyeccion.getFechaHora() %> </p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-md-6 text-center">
                                                            <div class="cate">
                                                                <span class="blue"><a href="#" class="btn btn-primary" data-toggle="modal" data-target="#ventanaObjetos">Ver asientos</a></span>
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

                            <!-- Modal de asientos -->
                            <div class="modal fade" id="ventanaObjetos" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h1 class="modal-title" id="exampleModalLabel">Selecciona tus asientos.</h1>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <script>
                                                function cambiarEstadoAsiento(id) {
                                                    var asiento = document.getElementById(id);

                                                    if (asiento.src.endsWith("images/butaca-gris.png")) {
                                                        asiento.src = "images/butaca-verde.png";
                                                    } else if (asiento.src.endsWith("images/butaca-verde.png")) {
                                                        asiento.src = "images/butaca-gris.png";
                                                    }
                                                }

                                                function cargarAsientos(filas, columnas) {
                                                    var contenedor = document.getElementById("sala");

                                                    var tamañoAsiento = Math.min(400 / columnas, 400 / filas); // Ajusta el 400 según tus necesidades
                                                    tamañoAsiento = Math.max(20, tamañoAsiento); // Tamaño mínimo para evitar que los asientos sean demasiado pequeños

                                                    for (var fila = 1; fila <= filas; fila++) {
                                                        for (var columna = 1; columna <= columnas; columna++) {
                                                            var idAsiento = "asiento_" + fila + "_" + columna;
                                                            var imgSrc = "images/butaca-gris.png";

                                                            // Lógica para determinar la disponibilidad del asiento
                                                            // Puedes personalizar esta lógica según tus necesidades

                                                            var random = Math.random();
                                                            if (random < 0.2) {
                                                                imgSrc = "images/butaca-rojo.png";
                                                            }

                                                            var img = document.createElement("img");
                                                            img.id = idAsiento;
                                                            img.className = "seat";
                                                            img.src = imgSrc;
                                                            img.style.width = tamañoAsiento + "px";
                                                            img.style.height = tamañoAsiento + "px";
                                                            img.onclick = function () {
                                                                cambiarEstadoAsiento(this.id);
                                                            };

                                                            contenedor.appendChild(img);
                                                        }
                                                        contenedor.appendChild(document.createElement("br"));
                                                    }
                                                }

                                                // Llama a la función cargarAsientos al cargar la página
                                                window.onload = function () {
                                                    cargarAsientos(15, 15); // Ajusta la cantidad de filas y columnas según tus necesidades
                                                };
                                            </script>

                                            <div id="sala" style="text-align: center;"></div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                            <button type="button" class="btn btn-primary" onclick="reservarAsientos()">Reservar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <%@include file="components/footer.jsp"%>
            </div>
        </div>
    </body>
</html>

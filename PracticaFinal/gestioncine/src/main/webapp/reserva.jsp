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
                                                                <span class="blue"><a href="#" class="btn btn-primary" onclick="verAsientos(<%= proyeccion.getIdSala() %>, <%= proyeccion.getId() %>)" data-toggle="modal" data-target="#ventanaObjetos">Ver asientos</a></span>
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
                                            <!-- Tu contenido de asientos aquí -->
                                            <div id="sala" style="text-align: center;"></div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                            <!-- Llama a la función reservarAsientos al hacer clic en "Reservar" -->
                                            <button type="button" class="btn btn-primary" onclick="reservarAsientos()">Reservar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <script>
                                function verAsientos(salaId, proyeccionId) {
                                    // Limpia el contenido del contenedor de asientos
                                    var contenedor = document.getElementById("sala");
                                    contenedor.innerHTML = "";

                                    // Llama al servlet para obtener filas y columnas
                                    fetch("sala?id=" + salaId)
                                            .then(response => response.json())
                                            .then(data => {
                                                // Utiliza los datos para cargar los asientos
                                                cargarAsientos(data.salaFilas, data.salaColumnas, proyeccionId);
                                            })
                                            .catch(error => console.error('Error:', error));
                                }


                                function cambiarEstadoAsiento(id) {
                                    var asiento = document.getElementById(id);

                                    if (asiento.src.endsWith("images/butaca-gris.png")) {
                                        asiento.src = "images/butaca-verde.png";
                                    } else if (asiento.src.endsWith("images/butaca-verde.png")) {
                                        asiento.src = "images/butaca-gris.png";
                                    }
                                }

                                function cargarAsientos(filas, columnas, proyeccionId) {
                                    var contenedor = document.getElementById("sala");

                                    var tamañoAsiento = Math.min(400 / columnas, 400 / filas);
                                    tamañoAsiento = Math.max(20, tamañoAsiento);

                                    // Limpia el contenido del contenedor de asientos
                                    contenedor.innerHTML = "";

                                    // Llama al servlet para obtener las entradas
                                    fetch("entradas?proyeccionId=" + proyeccionId)
                                            .then(response => response.json())
                                            .then(data => {
                                                for (var fila = 1; fila <= filas; fila++) {
                                                    for (var columna = 1; columna <= columnas; columna++) {
                                                        var idFilaColumna = fila + "_" + columna;
                                                        var imgSrc = "images/butaca-gris.png";

                                                        // Busca la entrada correspondiente al asiento en las entradas obtenidas
                                                        var entrada = data.find(e => e.fila === fila && e.columna === columna);

                                                        if (entrada && entrada.idReserva !== 0) { // Parece que cuando es null en la base de datos aqui es 0
                                                            imgSrc = "images/butaca-rojo.png";

                                                            // Imprime el valor de idReserva
                                                            console.log("idReserva para el asiento " + idFilaColumna + ": " + entrada.idReserva);
                                                        }

                                                        var img = document.createElement("img");
                                                        img.id = "asiento_" + idFilaColumna;
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
                                            })
                                            .catch(error => console.error('Error:', error));
                                }

                                function reservarAsientos() {
                                    // Array para almacenar los asientos seleccionados
                                    var asientosSeleccionados = [];

                                    // Obtén todos los elementos con la clase 'seat' (asientos)
                                    var asientos = document.getElementsByClassName('seat');

                                    // Itera sobre los asientos para identificar los seleccionados
                                    for (var i = 0; i < asientos.length; i++) {
                                        var asiento = asientos[i];

                                        // Verifica si el asiento está en verde (seleccionado)
                                        if (asiento.src.endsWith('images/butaca-verde.png')) {
                                            // Obtiene el ID del asiento a partir del ID de la imagen
                                            var idAsiento = asiento.id.replace('asiento_', '');

                                            // Agrega el asiento a la lista de seleccionados
                                            asientosSeleccionados.push(idAsiento);
                                        }
                                    }

                                    // Realiza la lógica de reserva con los asientos seleccionados
                                    if (asientosSeleccionados.length > 0) {
                                        // Puedes enviar la información al servidor para procesar la reserva
                                        // Por ejemplo, puedes usar una solicitud fetch a un servlet de reserva
                                        // Aquí solo imprimo los asientos seleccionados en la consola como ejemplo
                                        console.log('Asientos seleccionados:', asientosSeleccionados);

                                        // Aquí puedes agregar la lógica para enviar los datos al servidor y procesar la reserva
                                        // Utiliza una solicitud fetch o AJAX para enviar los datos al backend
                                    } else {
                                        alert('Debes seleccionar al menos un asiento para realizar la reserva.');
                                    }
                                }

                            </script>
                        </div>
                    </div>
                </div>

                <%@include file="components/footer.jsp"%>
            </div>
        </div>
    </body>
</html>

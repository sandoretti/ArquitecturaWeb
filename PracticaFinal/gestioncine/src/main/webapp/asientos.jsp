<%-- 
    Document   : asientos
    Created on : 3 ene 2024, 18:52:22
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

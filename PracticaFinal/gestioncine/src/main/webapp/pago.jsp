<%-- 
    Document   : paog
    Created on : 3 ene 2024, 23:22:00
    Author     : Jorge
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" class="no-js">
    <%@include file="components/head.jsp"%>
    <link rel="stylesheet" href="css/styles.css">
    <body>
        <%@include file="components/preloading.jsp"%>

        <div class="page-single-2">
            <div class="container">
                <div class="row">
                    <div class="middle-content">
                        <form action="/reserva" method="post">
                            <div class="container">
                                <div class="columna">
                                    <!-- Formulario de pago ficticio -->
                                    <section class="pago-section">
                                        <h2>Detalles de Pago</h2><br><br>

                                        <!-- Campos de información del cliente (adaptar según tu necesidad) -->
                                        <div class="form-group">
                                            <label for="nombre">Nombre del titular:</label>
                                            <input type="text" id="nombre" name="nombre" class="form-control">
                                        </div>

                                        <div class="form-group">
                                            <label for="numeroTarjeta">Número de tarjeta:</label>
                                            <input type="text" id="numeroTarjeta" name="numeroTarjeta" class="form-control" required>
                                        </div>

                                        <div class="form-group">
                                            <label for="fechaExpiracion">Fecha de expiración:</label>
                                            <input type="text" id="fechaExpiracion" name="fechaExpiracion" class="form-control-inline-1" placeholder="MM/AA"><br>
                                            <label for="codigoSeguridad">Código de seguridad:</label>
                                            <input type="text" id="codigoSeguridad" name="codigoSeguridad" class="form-control-inline-2" placeholder="CVV">
                                        </div>

                                        <!-- Campos ocultos para enviar detalles adicionales al servidor -->
                                        <input type="hidden" name="idReserva" value="123"> <!-- Adaptar según tu lógica de reserva -->
                                        <input type="hidden" name="montoTotal" value="45.00"> <!-- Adaptar según tu lógica de precios -->
                                    </section>
                                </div>
                                <div class="columna">
                                    <section class="detalles-section">
                                        <div class="detalles-header">
                                            <h2>Detalles de la Reserva</h2><br><br>
                                        </div>
                                        <ul class="detalles-lista">
                                            <li class="detalles-item"><span>Número de Entradas:</span> 3</li>
                                            <li class="detalles-item"><span>Precio por Entrada:</span> $15.00</li>
                                            <li class="detalles-item"><span>Precio Total:</span> $45.00</li>
                                        </ul>
                                    </section>
                                    <!-- Botón de pago centrado -->
                                    <div style="text-align: center;">
                                        <button type="submit" class="redbtn">Pagar Ahora</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/jquery.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/plugins2.js"></script>
        <script src="js/custom.js"></script>
    </body>
</html>










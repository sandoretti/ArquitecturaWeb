<%-- 
    Document   : paog
    Created on : 3 ene 2024, 23:22:00
    Author     : Jorge
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
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
                                        <input type="hidden" name="proyeccionId" value="<%= request.getParameter("proyeccionId") %>">
                                        <input type="hidden" name="asientos" value="<%= request.getParameter("asientos") %>">
                                        <%-- Obtener la cantidad de asientos seleccionados --%>
                                        <% String[] asientosSeleccionados = request.getParameter("asientos").split(","); %>
                                    </section>
                                </div>
                                <div class="columna">
                                    <section class="detalles-section">
                                        <div class="detalles-header">
                                            <h2>Detalles de la Reserva</h2><br><br>
                                        </div>
                                        <% Random random = new Random(); %>
                                        <% int precioUnitario = random.nextInt(8) + 3; // Rango entre 3 y 10 %>
                                        <% int cantidadAsientos = asientosSeleccionados.length; %>
                                        <% int precioTotal = precioUnitario * cantidadAsientos; %>
                                        <ul class="detalles-lista">
                                            <li class="detalles-item"><span>Número de Entradas:</span> <%= cantidadAsientos %></li>
                                            <li class="detalles-item"><span>Precio por Entrada:</span> <%= precioUnitario %>.00 €</li>
                                            <li class="detalles-item"><span>Precio Total:</span> <%= precioTotal %>.00 €</li>
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










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
                                        <%
                                            Random random = new Random();
                                            // Calcular el precio unitario con decimales en el rango de 3 a 10
                                            double precioUnitario = 3 + (random.nextDouble() * 7);
                                            // Formatear el precio unitario a dos decimales
                                            String precioFormateado = String.format("%.2f", precioUnitario);
                                           
                                            int cantidadAsientos = asientosSeleccionados.length;
                                            double precioTotal = precioUnitario * cantidadAsientos;
                                            String precioTotalFormateado = String.format("%.2f", precioTotal);
                                        %>
                                        <ul class="detalles-lista">
                                            <li class="detalles-item"><span>Número de Entradas:</span> <%= cantidadAsientos %></li>
                                            <li class="detalles-item"><span>Precio por Entrada:</span> <%= precioFormateado %> €</li>
                                            <li class="detalles-item"><span>Precio Total:</span> <%= precioTotalFormateado %> €</li>
                                        </ul>
                                        <!-- Campo oculto para enviar el precio total al servlet -->
                                        <input type="hidden" name="precioTotal" value="<%= precioTotalFormateado %>">

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










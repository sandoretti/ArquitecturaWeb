<%-- 
    Document   : confirmacionPago
    Created on : 3 ene 2024, 23:41:00
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" class="no-js">
    <%@include file="components/head.jsp"%>
    <body>
        <%@include file="components/preloading.jsp"%>

        <div class="page-single-2">
            <div class="container">
                <div class="row">
                    <div class="middle-content">
                        <a href="./"><img class="md-logo" src="images/logo1.png" alt="" width="100"></a>
                        <h1>Reserva realizada con éxito, presenta este número de referencia en el cine para poder acceder:</h1>
                        <h1><%= request.getParameter("referencia") %></h1>
                        <br><br><br><br><br>
                        <a href="./" class="redbtn">Volver al inicio</a>
                        
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

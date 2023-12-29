<%-- 
    Document   : salaCine
    Created on : 28 dic 2023, 18:22:06
    Author     : flapv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="../css/styles.css">
        <script>
            function selectSeat(event) {
                event.target.classList.toggle('selected');
            }
        </script>
    </head>
    <body class="body-style">
        <div class="navbar-style" style="margin: auto; max-width: 20%">
            <a class="link-style nav-item-style" href="./" style="margin: auto;">Volver a inicio</a>
        </div>
        <form class="container-style" style="background-color: #2c2b2b; max-width: 45%; margin:70px auto;">
            <div class="screen">Pantalla</div>
          <!-- Repite el div de fila para cada fila de asientos -->
          <% for(int i = 0; i < 10; i++) { %>
            <div class="row">
              <!-- Repite el div de asiento para cada asiento en la fila -->
              <% for(int j = 0; j < 15; j++) { %>
                <div class="seat" onclick="selectSeat(event)"></div>
              <% } %>
            </div>
          <% } %>
          <input type="submit" value="Reservar" class="submit-button">
        </form>
    </body>
</html>



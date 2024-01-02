<%-- 
    Document   : asientos
    Created on : 2 ene 2024, 17:59:48
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Selección de Asientos</title>
    <style>
        .seat {
            width: 50px;
            height: 50px;
            margin: 5px;
            cursor: pointer;
        }
    </style>
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
                    img.onclick = function() { cambiarEstadoAsiento(this.id); };

                    contenedor.appendChild(img);
                }
                contenedor.appendChild(document.createElement("br"));
            }
        }
    </script>
</head>
<body onload="cargarAsientos(5, 8)">
    <h1>Selección de Asientos</h1>
    <div id="sala"></div>
</body>
</html>





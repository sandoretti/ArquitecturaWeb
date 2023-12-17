<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crear Circuito</title>
        <link rel="stylesheet" href="../estilos/estilo.css"/>
    </head>
    <body>
        <h2>Crear Circuito</h2>
        <form action="${pageContext.request.contextPath}/CircuitoControlador" method="post">
            Nombre del Circuito: <input type="text" name="nombreCircuito"><br>
            Ciudad: <input type="text" name="ciudad"><br>
            País: <input type="text" name="pais"><br>
            Número de Vueltas (40-80): <input type="number" name="numVueltas" min="40" max="80"><br>
            Longitud de Vuelta (3000-9000 metros): <input type="number" name="longitudVuelta" min="3000" max="9000"><br>
            Número de Curvas por Vuelta (6-20): <input type="number" name="numCurvas" min="6" max="20"><br>
            <input type="submit" value="Crear Circuito">
        </form> 
    </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Crear Coche</title>
        <link rel="stylesheet" href="../estilos/estilo.css"/>
    </head>
    <body>
        <h2>Crear Coche</h2>
        <form action="${pageContext.request.contextPath}/CocheControlador" method="post">
            Nombre del Coche: <input type="text" name="nombreCoche"><br>
            Ganancia de Potencia por Curva (4-10 kW): <input type="number" name="gananciaPotencia" min="4" max="10"><br>
            <input type="submit" value="Crear Coche">
        </form>
    </body>
</html>


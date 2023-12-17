<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Calcular Ganancia de Potencia</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/estilos/estilo.css"/>
        <script src="${pageContext.request.contextPath}/scripts/app.js"></script>
    </head>
    <body>
        <h2>Calcular Ganancia de Potencia</h2>
        <form action="#" method="post">
            Seleccionar Circuito: 
            <!-- Aquí debes cargar los circuitos desde tu BBDD -->
            <select name="circuitoSeleccionado" id="circuitoSelect">
                <c:forEach items="${listaCircuitos}" var="circuito">
                    <option value="${circuito.nombre}" data-numvueltas="${circuito.getNumeroVueltas()}" data-numcurvas="${circuito.getLongitudVueltas()}">${circuito.nombre}</option>
                </c:forEach>
            </select><br>
            Seleccionar Coche: 
            <!-- Aquí debes cargar los coches desde tu BBDD -->
            <select name="cocheSeleccionado" id="cocheSelect">
                <c:forEach items="${listaCoches}" var="coche">
                    <option value="${coche.nombre}" data-gananciapotenciaporcurva="${coche.getGananciaPotenciaCurva()}">${coche.nombre}</option>
                </c:forEach>
                <!-- Opciones de coches -->
            </select><br>
            <input type="button" value="Calcular Ganancia" id="btnPotencia">
        </form>
        <div id="resultadoPotencia"></div>
    </body>
</html>

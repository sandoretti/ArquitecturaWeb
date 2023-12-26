<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crea una Cuenta!!!!</h1>
        <form action="/cuentaNueva" method="POST">
            Nombre:
            <input type="text" name="nombre">
            Apellido:
            <input type="text" name="apellido">
            Email:
            <input type="email" name="email">
            Password:
            <input type="password" name="passwd">
            <button>Enviar</button> 
        </form>
    </body>
</html>

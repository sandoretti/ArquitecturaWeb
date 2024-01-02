<%-- 
    Document   : entradasAdmin
    Created on : 31 dic 2023, 6:48:19
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" class="no-js">
    <%@include file="componentsAdmin/head.jsp"%>
    <body>
        <%@include file="componentsAdmin/preloading.jsp"%>
        <%@include file="componentsAdmin/login.jsp"%>
        <%@include file="componentsAdmin/singup.jsp"%>
        <%@include file="componentsAdmin/header.jsp"%>

        <div class="hero common-hero">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="hero-ct">
					<h1>Entradas</h1>
					<ul class="breadcumb">
						<li class="active"><a href="#">Home</a></li>
						<li> <span class="ion-ios-arrow-right"></span> Gestión de Entradas</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
        

        <%@include file="componentsAdmin/footer.jsp"%>

    </body>
    
</html>

<%-- 
    Document   : informesAdmin
    Created on : 31 dic 2023, 6:50:03
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
					<h1>Informes</h1>
					<ul class="breadcumb">
						<li class="active"><a href="#">Home</a></li>
						<li> <span class="ion-ios-arrow-right"></span> Gestión de Informes</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
        

        <%@include file="components/footer.jsp"%>

    </body>
    
</html>

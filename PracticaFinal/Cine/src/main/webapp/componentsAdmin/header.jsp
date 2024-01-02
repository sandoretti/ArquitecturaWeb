<%-- 
    Document   : header
    Created on : 31 dic 2023, 4:50:36
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- BEGIN | Header -->
<header class="ht-header">
	<div class="container">
		<nav class="navbar navbar-default navbar-custom">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header logo">
				    <div class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					    <span class="sr-only">Toggle navigation</span>
					    <div id="nav-icon1">
							<span></span>
							<span></span>
							<span></span>
						</div>
				    </div>
				    <a href="indexAdmin.jsp"><img class="logo" src="images/logo1.png" alt="" width="119" height="58"></a>
			    </div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse flex-parent" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav flex-child-menu menu-left">
						<li class="hidden">
							<a href="#page-top"></a>
						</li>
						<li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown">
							principal <i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
                                                        <ul class="dropdown-menu level1">
								<li class="it-last"><a href="indexAdmin.jsp">Home</a></li>
							</ul>
						</li>
						<li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							películas<i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
                                                        <ul class="dropdown-menu level1">
								<li class="it-last"><a href="pelicula">Gestión de Películas</a></li>
							</ul>
						</li>
                                                <li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							salas<i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
                                                        <ul class="dropdown-menu level1">
								<li class="it-last"><a href="salas.jsp">Gestión de Salas</a></li>
							</ul>
						</li>
                                                <li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							Entradas<i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
                                                        <ul class="dropdown-menu level1">
								<li class="it-last"><a href="entradas.jsp">Gestión de Entradas</a></li>
							</ul>
						</li>
                                                <li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							Reservas<i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
                                                        <ul class="dropdown-menu level1">
								<li class="it-last"><a href="reservas.jsp">Gestión de Reservas</a></li>
							</ul>
						</li>
                                                <li class="dropdown first">
							<a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
							Informes<i class="fa fa-angle-down" aria-hidden="true"></i>
							</a>
                                                        <ul class="dropdown-menu level1">
								<li class="it-last"><a href="informes.jsp">Gestión de Informes</a></li>
							</ul>
						</li>
					</ul>
					<ul class="nav navbar-nav flex-child-menu menu-right">
						<li class="btn"><a href="index.jsp">Cerrar Sesión</a></li>
					</ul>
				</div>
			<!-- /.navbar-collapse -->
	    </nav>
	    
	</div>
</header>
<!-- END | Header -->

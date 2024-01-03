<%-- 
    Document   : header
    Created on : 31 dic 2023, 4:50:36
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="es.uah.grupo2.gestioncine.app.model.entity.Cliente" %>
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
                <a href="index.jsp"><img class="logo" src="images/logo1.png" alt="" width="119" height="58"></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse flex-parent" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav flex-child-menu menu-left">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="dropdown first">
                        <a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown">
                            Inicio <i class="fa fa-angle-down" aria-hidden="true"></i>
                        </a>
                        <ul class="dropdown-menu level1">
                            <li class="it-last"><a href="index.jsp">Home</a></li>
                        </ul>
                    </li>
                    <li class="dropdown first">
                        <a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
                            películas<i class="fa fa-angle-down" aria-hidden="true"></i>
                        </a>
                        <ul class="dropdown-menu level1">
                            <li class="it-last"><a href="peliculas">Lista de Películas</a></li>
                        </ul>
                    </li>
                    <!--
                    <li class="dropdown first">
                        <a href="actores.jsp" class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
                            actores <i class="fa fa-angle-down" aria-hidden="true"></i>
                        </a>
                        <ul class="dropdown-menu level1">
                            <li class="it-last"><a href="actores.jsp">Lista de Actores</a></li>
                        </ul>
                    </li>
                    
                    <li class="dropdown first">
                        <a class="btn btn-default dropdown-toggle lv1" data-toggle="dropdown" data-hover="dropdown">
                            community <i class="fa fa-angle-down" aria-hidden="true"></i>
                        </a>
                        <ul class="dropdown-menu level1">
                            <li><a href="#">user favorite grid</a></li>
                            <li><a href="#">user favorite list</a></li>
                            <li><a href="#">user profile</a></li>
                            <li class="it-last"><a href="#">user rate</a></li>
                        </ul>
                    </li>
                    -->
                </ul>
                <ul class="nav navbar-nav flex-child-menu menu-right">               
                    <li><a href="#">Ayuda</a></li>
                        <% if(session.getAttribute("usuario") == null) { %>
                    <li class=""><a href="login">iniciar Sesión</a></li>
                    <li class="btn "><a href="signup">Registrarse</a></li>
                        <% } else { %>
                        <% Cliente cliente = (Cliente) session.getAttribute("usuario");
                                if (cliente.isAdmin())
                                request.getRequestDispatcher(request.getContextPath() + "./perfil").forward(request, response);
                        %>
                    <li class="btn"><a href="/logout">Cerrar Sesión</a></li>
                    <% } %>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <!-- top search form -->
        <div class="top-search">
            <input type="text" placeholder="Busca películas o actores">
        </div>
    </div>
</header>
<!-- END | Header -->

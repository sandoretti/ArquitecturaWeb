<%-- 
    Document   : singup
    Created on : 31 dic 2023, 4:49:49
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--signup form popup-->
<div class="login-wrapper"  id="signup-content">
    <div class="login-content">
        <a href="#" class="close">x</a>
        <h3>Registrarse</h3>
        <form method="post" action="registro">
            <div class="row">
                 <label for="nombre">
                    Nombre:
                    <input type="text" name="nombre" id="nombre" placeholder="" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{8,20}$" required="required" />
                </label>
            </div>
            
            <div class="row">
                 <label for="apellido">
                    Apellido:
                    <input type="text" name="apellido" id="apellido" placeholder="" pattern="^[a-zA-Z][a-zA-Z0-9-_\.]{8,20}$" required="required" />
                </label>
            </div>
           
            <div class="row">
                <label for="email">
                    Email:
                    <input type="email" name="email" id="email-2" placeholder="" pattern=".*@.*" required="required" />
                </label>
            </div>
             <div class="row">
                <label for="password-2">
                    Contraseña:
                    <input type="password" name="password" id="password-2" placeholder="" pattern=".*" required="required" />
                </label>
            </div>
             <div class="row">
                <label for="repassword-2">
                    Confirmar contraseña:
                    <input type="password" name="password" id="repassword-2" placeholder="" pattern=".*" required="required" />
                </label>
            </div>
           <div class="row">
             <button type="submit">Registrarse</button>
           </div>
        </form>
    </div>
</div>
<!--end of signup form popup-->

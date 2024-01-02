<%-- 
    Document   : login
    Created on : 31 dic 2023, 4:49:18
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--login form popup-->
<div class="login-wrapper" id="login-content">
    <div class="login-content">
        <a href="#" class="close">x</a>
        <h3>Iniciar Sesión</h3>
        <form method="post" action="login">
        	<div class="row">
        		 <label for="email">
                    Email:
                    <input type="text" name="email" id="email" placeholder="" pattern=".*@.*" required="required" />
                </label>
        	</div>
           
            <div class="row">
            	<label for="password">
                    Contraseña:
                    <input type="password" name="password" id="password" placeholder="" pattern=".*" required="required" />
                </label>
            </div>
            <div class="row">
            	<div class="remember">
					<div>
						<input type="checkbox" name="remember" value="Remember me"><span>Recuerdame</span>
					</div>
            		<a href="#">Has olvidado la contraseña?</a>
            	</div>
            </div>
           <div class="row">
           	 <button type="submit">Iniciar Sesión</button>
           </div>
        </form>
    </div>
</div>
<!--end of login form popup-->

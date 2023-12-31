/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

//Mostrar el error o el 'success' en un recuadro que desaparece
//a los 5 segundos.
function mensajeGestion(error, success){
    var errorMessage = error;
    var successMessage = success;
    console.log(successMessage);
    window.onload = function() {
        var messageDiv = document.getElementById('message');
        if (errorMessage !== "null") {
            messageDiv.textContent = "Error: " + errorMessage;
        } else if (successMessage !== "null") {
            messageDiv.textContent = "Success: " + successMessage;
        } else {
            messageDiv.style.display = "none";
        }
       
        setTimeout(function() {
            messageDiv.style.display = "none"; /* Esto hace que el div desaparezca */
        }, 5000);
    };
}
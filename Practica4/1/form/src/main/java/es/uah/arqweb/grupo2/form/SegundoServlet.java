package es.uah.arqweb.grupo2.form;

//
// SegundoServlet.java
//
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet(name = "segundoServlet", value = "/SegundoServlet")
public class SegundoServlet extends HttpServlet
{
    String nombre;
    public void service( HttpServletRequest peticion, HttpServletResponse
            respuesta ) throws ServletException, IOException
    {
        nombre = peticion.getParameter("NOMBRE");
        ServletOutputStream out = respuesta.getOutputStream();
        out.println("<html>");
        out.println("<head><title>Hola Servlet</title></head>");
        out.println("<body>");
        out.println("<p><h1><center>Su nombre es: <B>"+nombre+"</B></center></h1></p>");
        out.println("</body></html>");
        out.close();
    }
}

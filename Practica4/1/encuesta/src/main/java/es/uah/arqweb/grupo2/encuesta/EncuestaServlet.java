package es.uah.arqweb.grupo2.encuesta;
//
// Encuesta.java
//
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "encuestaServlet", value = "/EncuestaServlet")
public class EncuestaServlet extends HttpServlet
{
    Statement mandato = null;
    PreparedStatement insertar = null;
    Connection conexion = null;

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        try
        {
            // Iniciamos la conexion a una base de datos iniciada en localhost y llamada sample
            conexion = DriverManager.getConnection ("jdbc:derby://localhost:1527/sample");

            // Creamos un statement para poder ver las respuestas
            mandato = conexion.createStatement();

            // Iniciamos el statement para poder insertar los datos recibidos
            insertar = conexion.prepareStatement("INSERT INTO ENCUESTA VALUES(?, ?, ?)");

            if (mandato == null)
            {
                throw new Exception("mandato es nulo");
            }
        }
        catch (Exception e)
        {
            System.out.println("Problemas al conectar con la base de datos: ".concat(e.toString()));
        }


    }

    public void service( HttpServletRequest peticion, HttpServletResponse
            respuesta ) throws ServletException, IOException
    {
        /* creación del flujo de salida hacia el cliente */
        ServletOutputStream out = respuesta.getOutputStream();
        respuesta.setContentType("text/html");
        /* recuperamos los valores que nos manda el cliente */
        String strNombre = peticion.getParameter("NOMBRE");
        String strEmail = peticion.getParameter("EMAIL");
        String strRespuesta = peticion.getParameter("RESPUESTA");
        /* insertamos los datos en la base de datos */
        try
        {
            // Preparamos el statement
            insertar.setString(1, strNombre);
            insertar.setString(2, strEmail);
            insertar.setString(3, strRespuesta);

            // Ejecutamos la sentencia para insertar los datos en la tabla
            insertar.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return;
        }
        /* leemos todos los registros para crear la estadística */
        try
        {
            int intSI = 0;
            int intNO = 0;
            ResultSet resultado = mandato.executeQuery("SELECT RESPUESTA FROM ENCUESTA");
            while(resultado.next())
            {
                String resp = resultado.getString("RESPUESTA");
                if(resp.compareTo("NO")==0) intNO++;
                else intSI++;
            }
            out.println("<h2><center>Encuesta Servlet</center></h2>");
            out.println("<BR>Gracias por participar en esta encuesta.");
            out.println("<BR>Los resultados hasta este momento son :");
            out.println("<BR> SI : "+intSI);
            out.println("<BR> NO : "+intNO);
        }
        catch(Exception e)
        {
            System.out.println(e);
            return;
        }
    }
    public void destroy()
    {
        try
        {
            conexion.close();
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return;
        }
    }
}
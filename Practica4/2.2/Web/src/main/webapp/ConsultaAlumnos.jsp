<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Consulta de Alumnos por Profesor</title>
</head>
<body>

    <h2>Consulta de Alumnos por Profesor</h2>

    <form action="ConsultaAlumnos.jsp" method="post">
        <label>Nombre del Profesor:</label>
        <input type="text" name="nombreProfesor" required>
        <input type="submit" value="Consultar">
    </form>

    <%
        // Procesar la solicitud cuando se envíe el formulario
        if (request.getMethod().equalsIgnoreCase("POST")) {
            String nombreProfesor = request.getParameter("nombreProfesor");

            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/clase");

                // Consulta SQL para obtener los alumnos que reciben clases del profesor
                String sql = "SELECT DISTINCT A.Nombre, A.Apellido " +
                             "FROM Alumno A " +
                             "JOIN Asistencia AS AST ON A.DNI = AST.DNIAlumno " +
                             "JOIN Asignatura AS ASG ON AST.IDAsignatura = ASG.IDAsignatura " +
                             "JOIN Profesor P ON ASG.DNIProfesor = P.DNI " +
                             "WHERE P.Nombre = ?";

                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nombreProfesor);

                ResultSet resultSet = statement.executeQuery();

                // Mostrar los resultados
                out.println("<h3>Alumnos que reciben clases del profesor " + nombreProfesor + ":</h3>");
                out.println("<ul>");

                while (resultSet.next()) {
                    String nombreAlumno = resultSet.getString("Nombre");
                    String apellidoAlumno = resultSet.getString("Apellido");
                    out.println("<li>" + nombreAlumno + " " + apellidoAlumno + "</li>");
                }

                out.println("</ul>");

                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        }
    %>

</body>
</html>
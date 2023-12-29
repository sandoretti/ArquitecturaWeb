package es.uah.grupo2.gestioncine.app.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {
    public static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/shopmedb");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return c;
    }

    /**
     * Inserta una pelicula en la base de datos y si se hace correctamente, este devuelve true. Si no, este devuelve
     * false.
     *
     * @param nombre
     * @param sinopsis
     * @param pagina
     * @param titulo
     * @param genero
     * @param nacionalidad
     * @param duracion
     * @param ano
     * @param distribuidora
     * @param director
     * @param otros
     * @param clasificacion
     * @param portada
     * @return
     */
    public static boolean insertarPelicula(
            String nombre, String sinopsis, String pagina, String titulo, String genero,
            String nacionalidad, int duracion, int ano, String distribuidora,
            String director, String otros, String clasificacion, String portada
    ) {
        Connection conn = getConnection();
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO Pelicula (nombre_pelicula, sinopsis, pagina_oficial, titulo_oficial," +
                    "genero, nacionalidad, duracion, ano, distribuidora, director, otros_datos, class_edad, " +
                    "portada) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, sinopsis);
            ps.setString(3, pagina);
            ps.setString(4, titulo);
            ps.setString(5, genero);
            ps.setString(6, nacionalidad);
            ps.setInt(7, duracion);
            ps.setInt(8, ano);
            ps.setString(9, distribuidora);
            ps.setString(10, director);
            ps.setString(11, otros);
            ps.setString(12, clasificacion);
            ps.setString(13, portada);

            ps.executeUpdate();

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * Obtiene el id de una pelicula dada por su nombre. Si no se encuentra o salta un error, devuelve -1.
     *
     * @param nombre
     * @return
     */
    public static int obtenerId(String nombre){
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT id FROM PELICULA WHERE nombre_pelicula = ?";

            ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);

            rs = ps.executeQuery();

            if (rs.next()){
                return rs.getInt(1);
            } else {
                return -1;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return -1;
    }

    public static List<Pelicula> selectPeliculasIdNombGenAnoClas(){
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT ID, NOMBRE_PELICULA, GENERO, ANO, CLASS_EDAD FROM PELICULA ";

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            String nombre, genero, clasificacionEdad;
            int id, ano;

            List<Pelicula> peliculasList = new ArrayList<>();

            while(rs.next()){
                id = rs.getInt(1);
                nombre = rs.getString(2);
                genero = rs.getString(3);
                ano = rs.getInt(4);
                clasificacionEdad = rs.getString(5);

                peliculasList.add(new Pelicula(id, nombre, genero, ano, clasificacionEdad));
            }

            return peliculasList;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}

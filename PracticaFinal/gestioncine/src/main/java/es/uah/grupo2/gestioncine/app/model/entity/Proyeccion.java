package es.uah.grupo2.gestioncine.app.model.entity;

import java.util.Date;

/**
 *
 * @author serchio
 */
public class Proyeccion {
    private int id;
    private int idPelicula;
    private int idSala;
    private String nombrePelicula;
    private String nombreSala;
    private Date fechaHora;

    public Proyeccion(int id, String nombrePelicula, String nombreSala, Date fechaHora) {
        this.id = id;
        this.nombrePelicula = nombrePelicula;
        this.nombreSala = nombreSala;
        this.fechaHora = fechaHora;
    }

    public Proyeccion(int id, int idPelicula, int idSala, Date fechaHora) {
        this.id = id;
        this.idPelicula = idPelicula;
        this.idSala = idSala;
        this.fechaHora = fechaHora;
    }

    public Proyeccion(int idPelicula, int idSala, Date fechaHora) {
        this.idPelicula = idPelicula;
        this.idSala = idSala;
        this.fechaHora = fechaHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
}

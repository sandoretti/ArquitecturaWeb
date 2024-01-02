package es.uah.grupo2.gestioncine.app.model.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Comentario {

    private int id;
    private int idCliente;
    private int idPelicula;
    private String texto;
    private LocalDateTime fechaComentario;
    private String usuario;

    public Comentario() {
    }
    
    

    public Comentario(int id, int id_cliente, int id_pelicula, String texto, LocalDateTime fechaComentario) {
        this.id = id;
        this.idCliente = id_cliente;
        this.idPelicula = id_pelicula;
        this.texto = texto;
        this.fechaComentario = fechaComentario;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @return the idPelicula
     */
    public int getIdPelicula() {
        return idPelicula;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @return the fechaComentario
     */
    public Timestamp getFechaComentario() {
        return Timestamp.valueOf(fechaComentario);
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @param idPelicula the idPelicula to set
     */
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @param fechaComentario the fechaComentario to set
     */
    public void setFechaComentario(Timestamp timestamp) {
        this.fechaComentario = timestamp.toLocalDateTime();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}

package es.uah.grupo2.gestioncine.app.model.entity;

import java.sql.Timestamp;

public class Comentario {

    private int id;
    private int idCliente;
    private int idPelicula;
    private String texto;
    private Timestamp fechaComentario;
    private String usuario;
    
    public Comentario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Timestamp getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Timestamp fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    
    

}

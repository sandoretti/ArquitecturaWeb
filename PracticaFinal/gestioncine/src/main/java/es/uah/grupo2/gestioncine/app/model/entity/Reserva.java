package es.uah.grupo2.gestioncine.app.model.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Reserva {

    private int id;
    private int idCliente;
    private int idProyeccion;
    private LocalDateTime fechaReserva;
    private String numeroTarjeta;
    private String referenciaReserva;

    public Reserva(int id, int idCliente, int idProyeccion, LocalDateTime fechaReserva, String numeroTarjeta, String referenciaReserva) {
        this.id = id;
        this.idCliente = idCliente;
        this.idProyeccion = idProyeccion;
        this.fechaReserva = fechaReserva;
        this.numeroTarjeta = numeroTarjeta;
        this.referenciaReserva = referenciaReserva;
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
     * @return the idProyeccion
     */
    public int getIdProyeccion() {
        return idProyeccion;
    }

    /**
     * @return the fechaReserva
     */
    public Timestamp getFechaReserva() {
        return Timestamp.valueOf(fechaReserva);
    }

    /**
     * @return the numeroTarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * @return the referenciaReserva
     */
    public String getReferenciaReserva() {
        return referenciaReserva;
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
     * @param idProyeccion the idProyeccion to set
     */
    public void setIdProyeccion(int idProyeccion) {
        this.idProyeccion = idProyeccion;
    }

    /**
     * @param fechaReserva the fechaReserva to set
     */
    public void setFechaReserva(Timestamp timestamp) {
        this.fechaReserva = timestamp.toLocalDateTime();
    }

    /**
     * @param numeroTarjeta the numeroTarjeta to set
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * @param referenciaReserva the referenciaReserva to set
     */
    public void setReferenciaReserva(String referenciaReserva) {
        this.referenciaReserva = referenciaReserva;
    }
}

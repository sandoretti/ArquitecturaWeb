package es.uah.grupo2.gestioncine.app.model.entity;

import java.util.Date;

public class Reserva {

    private int id;
    private int idCliente;
    private Date fechaReserva;
    private String numeroTarjeta;
    private String referenciaReserva;
    private Float precio;

    public Reserva() {
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

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getReferenciaReserva() {
        return referenciaReserva;
    }

    public void setReferenciaReserva(String referenciaReserva) {
        this.referenciaReserva = referenciaReserva;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}

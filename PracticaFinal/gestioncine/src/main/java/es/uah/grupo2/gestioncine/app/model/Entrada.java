package es.uah.grupo2.gestioncine.app.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Entrada {

    private int id;
    private int idProyeccion;
    private int fila;
    private int columna;
    private LocalDateTime fecha;

    public Entrada(int id, int idProyeccion, int fila, int columna, LocalDateTime fecha) {
        this.id = id;
        this.idProyeccion = idProyeccion;
        this.fila = fila;
        this.columna = columna;
        this.fecha = fecha;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the idProyeccion
     */
    public int getIdProyeccion() {
        return idProyeccion;
    }

    /**
     * @return the fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * @return the columna
     */
    public int getColumna() {
        return columna;
    }

    /**
     * @return the fecha
     */
    public Timestamp getFecha() {
        return Timestamp.valueOf(fecha);
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param idProyeccion the idProyeccion to set
     */
    public void setIdProyeccion(int idProyeccion) {
        this.idProyeccion = idProyeccion;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * @param columna the columna to set
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Timestamp timestamp) {
        this.fecha = timestamp.toLocalDateTime();
    }
}

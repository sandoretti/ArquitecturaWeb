package es.uah.grupo2.gestioncine.app.model;

public class Sala {

    private int id;
    private String nombreSala;
    private int fila;
    private int columna;

    public Sala(int id, String nombreSala, int fila, int columna) {
        this.id = id;
        this.nombreSala = nombreSala;
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nombreSala
     */
    public String getNombreSala() {
        return nombreSala;
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
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param nombreSala the nombreSala to set
     */
    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
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
}

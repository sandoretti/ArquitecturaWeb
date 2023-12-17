package modelo;

public class Circuito {

    private String nombre;
    private String ciudad;
    private String pais;
    private int numeroVueltas;
    private int longitudVueltas;
    private int numeroCurvas;

    public Circuito(String nombre, String ciudad, String pais, int numeroVueltas, int longitudVueltas, int numeroCurvas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.numeroVueltas = numeroVueltas;
        this.longitudVueltas = longitudVueltas;
        this.numeroCurvas = numeroCurvas;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the numeroVueltas
     */
    public int getNumeroVueltas() {
        return numeroVueltas;
    }

    /**
     * @param numeroVueltas the numeroVueltas to set
     */
    public void setNumeroVueltas(int numeroVueltas) {
        this.numeroVueltas = numeroVueltas;
    }

    /**
     * @return the longitudVueltas
     */
    public int getLongitudVueltas() {
        return longitudVueltas;
    }

    /**
     * @param longitudVueltas the longitudVueltas to set
     */
    public void setLongitudVueltas(int longitudVueltas) {
        this.longitudVueltas = longitudVueltas;
    }

    /**
     * @return the numeroCurvas
     */
    public int getNumeroCurvas() {
        return numeroCurvas;
    }

    /**
     * @param numeroCurvas the numeroCurvas to set
     */
    public void setNumeroCurvas(int numeroCurvas) {
        this.numeroCurvas = numeroCurvas;
    }

}

package modelo;

public class Coche {

    private String nombre;
    private int gananciaPotenciaCurva;

    public Coche(String nombre, int gananciaPotenciaCurva) {
        this.nombre = nombre;
        this.gananciaPotenciaCurva = gananciaPotenciaCurva;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the gananciaPotenciaCurva
     */
    public int getGananciaPotenciaCurva() {
        return gananciaPotenciaCurva;
    }

}

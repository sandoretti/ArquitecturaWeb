package es.uah.grupo2.gestioncine.app.model.entity;

/**
 *
 * @author serchio
 */
public class Proyeccion {

    private int id;
    private int idPelicula;
    private int idSala;

    public Proyeccion(int id, int idPelicula, int idSala) {
        this.id = id;
        this.idPelicula = idPelicula;
        this.idSala = idSala;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the idPelicula
     */
    public int getIdPelicula() {
        return idPelicula;
    }

    /**
     * @return the idSala
     */
    public int getIdSala() {
        return idSala;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param idPelicula the idPelicula to set
     */
    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    /**
     * @param idSala the idSala to set
     */
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

}

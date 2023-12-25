package es.uah.grupo2.gestioncine.app.model;

public class Pelicula {

    private int id;
    private String nombrePelicula;
    private String sipnosis;
    private String paginaOficial;
    private String tituloOficial;
    private String genero;
    private String nacionalidad;
    private int duracion;
    private int ano;
    private String distribuidora;
    private String director;
    private String actor;
    private String clasificacionEdad;
    private String otrosDatos;

    public Pelicula(int id, String nombrePelicula, String sipnosis, String paginaOficial, String tituloOficial, String genero, String nacionalidad, int duracion, int ano, String distribuidora, String director, String actor, String clasificacionEdad, String otrosDatos) {
        this.id = id;
        this.nombrePelicula = nombrePelicula;
        this.sipnosis = sipnosis;
        this.paginaOficial = paginaOficial;
        this.tituloOficial = tituloOficial;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.duracion = duracion;
        this.ano = ano;
        this.distribuidora = distribuidora;
        this.director = director;
        this.actor = actor;
        this.clasificacionEdad = clasificacionEdad;
        this.otrosDatos = otrosDatos;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the nombrePelicula
     */
    public String getNombrePelicula() {
        return nombrePelicula;
    }

    /**
     * @return the sipnosis
     */
    public String getSipnosis() {
        return sipnosis;
    }

    /**
     * @return the paginaOficial
     */
    public String getPaginaOficial() {
        return paginaOficial;
    }

    /**
     * @return the tituloOficial
     */
    public String getTituloOficial() {
        return tituloOficial;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @return the distribuidora
     */
    public String getDistribuidora() {
        return distribuidora;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @return the actor
     */
    public String getActor() {
        return actor;
    }

    /**
     * @return the clasificacionEdad
     */
    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    /**
     * @return the otrosDatos
     */
    public String getOtrosDatos() {
        return otrosDatos;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param nombrePelicula the nombrePelicula to set
     */
    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    /**
     * @param sipnosis the sipnosis to set
     */
    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

    /**
     * @param paginaOficial the paginaOficial to set
     */
    public void setPaginaOficial(String paginaOficial) {
        this.paginaOficial = paginaOficial;
    }

    /**
     * @param tituloOficial the tituloOficial to set
     */
    public void setTituloOficial(String tituloOficial) {
        this.tituloOficial = tituloOficial;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @param distribuidora the distribuidora to set
     */
    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @param actor the actor to set
     */
    public void setActor(String actor) {
        this.actor = actor;
    }

    /**
     * @param clasificacionEdad the clasificacionEdad to set
     */
    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    /**
     * @param otrosDatos the otrosDatos to set
     */
    public void setOtrosDatos(String otrosDatos) {
        this.otrosDatos = otrosDatos;
    }
}

package es.uah.grupo2.gestioncine.app.model.entity;

import java.util.List;

public class Pelicula {

    private int id;
    private String nombre;
    private String sipnosis;
    private String pagina;
    private String titulo;
    private String genero;
    private String nacionalidad;
    private int duracion;
    private int ano;
    private String distribuidora;
    private String director;
    private String otrosDatos;
    private String clasificacionEdad;
    private String portad;
    private List<Actor> actores;
    private List<Comentario> comentarios;
    private String trailer;
    private List<Proyeccion> proyecciones;
    

    public Pelicula(int id, String nombre, String sipnosis, String pagina, String titulo, String genero,
                    String nacionalidad, int duracion, int ano, String distribuidora, String director,
                    String otrosDatos, String clasificacionEdad, String portad, List<Actor> actores
    ) {
        this.id = id;
        this.nombre = nombre;
        this.sipnosis = sipnosis;
        this.pagina = pagina;
        this.titulo = titulo;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.duracion = duracion;
        this.ano = ano;
        this.distribuidora = distribuidora;
        this.director = director;
        this.otrosDatos = otrosDatos;
        this.clasificacionEdad = clasificacionEdad;
        this.portad = portad;
        this.actores = actores;
    }

    public Pelicula() {
    }

    public Pelicula(int id, String nombre, String genero, int ano, String clasificacionEdad) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.ano = ano;
        this.clasificacionEdad = clasificacionEdad;
    }

    public Pelicula(int id, String nombre, String portad) {
        this.id = id;
        this.nombre = nombre;
        this.portad = portad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getOtrosDatos() {
        return otrosDatos;
    }

    public void setOtrosDatos(String otrosDatos) {
        this.otrosDatos = otrosDatos;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public String getPortad() {
        return portad;
    }

    public void setPortad(String portad) {
        this.portad = portad;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }
    
     public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public String getTrailer() {
        return "https://www.youtube.com/embed/o-0hcF97wy0";
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public List<Proyeccion> getProyecciones() {
        return proyecciones;
    }

    public void setProyecciones(List<Proyeccion> proyecciones) {
        this.proyecciones = proyecciones;
    }
}

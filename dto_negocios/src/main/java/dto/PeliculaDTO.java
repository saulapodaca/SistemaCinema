package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
public class PeliculaDTO {

    private String id;
    private String titulo;
    private String rutaImagen;
    private String duracion;
    private String idioma;

    public PeliculaDTO() {
    }

    public PeliculaDTO(String id, String titulo, String rutaImagen, String duracion, String idioma) {
        this.id = id;
        this.titulo = titulo;
        this.rutaImagen = rutaImagen;
        this.duracion = duracion;
        this.idioma = idioma;
    }

    public PeliculaDTO(String titulo, String rutaImagen, String duracion, String idioma) {
        this.titulo = titulo;
        this.rutaImagen = rutaImagen;
        this.duracion = duracion;
        this.idioma = idioma;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

}

package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
public class PeliculaDTO {

    private String id;
    private String titulo;
    private String rutaImagen;
    private String duracion;
    private String idioma;

    public PeliculaDTO(String id, String titulo, String rutaImagen, String duracion, String idioma) {
        this.id = id;
        this.titulo = titulo;
        this.rutaImagen = rutaImagen;
        this.duracion = duracion;
        this.idioma = idioma;
    }

    public String getId(){
        return id;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getIdioma() {
        return idioma;
    }

}

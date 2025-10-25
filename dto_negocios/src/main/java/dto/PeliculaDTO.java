package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
public class PeliculaDTO {

    private String titulo;
    private String rutaImagen;
    private String duracion;
    private String idioma;

    public PeliculaDTO(String titulo, String rutaImagen, String duracion, String idioma) {
        this.titulo = titulo;
        this.rutaImagen = rutaImagen;
        this.duracion = duracion;
        this.idioma = idioma;
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

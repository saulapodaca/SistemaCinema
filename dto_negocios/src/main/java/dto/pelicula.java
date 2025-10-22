package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
public class pelicula {

    private String titulo;
    private String rutaImagen;

    public pelicula(String titulo, String rutaImagen) {
        this.titulo = titulo;
        this.rutaImagen = rutaImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

}

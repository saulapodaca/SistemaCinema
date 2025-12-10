package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class SaborPalomitasDTO {

    private String id;
    private String nombre;
    private double precioExtra;
    private String rutaImagen;

    public SaborPalomitasDTO() {
    }

    public SaborPalomitasDTO(String id, String nombre, double precioExtra, String rutaImagen) {
        this.id = id;
        this.nombre = nombre;
        this.precioExtra = precioExtra;
        this.rutaImagen = rutaImagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioExtra() {
        return precioExtra;
    }

    public void setPrecioExtra(double precioExtra) {
        this.precioExtra = precioExtra;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
}

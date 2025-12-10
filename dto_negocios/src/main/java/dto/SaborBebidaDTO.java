package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class SaborBebidaDTO {
    
    private String id;
    private String nombre;
    private String rutaImagen;
    private double precioExtra;

    public SaborBebidaDTO() {
    }

    public SaborBebidaDTO(String id, String nombre, double precioExtra, String rutaImagen) {
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

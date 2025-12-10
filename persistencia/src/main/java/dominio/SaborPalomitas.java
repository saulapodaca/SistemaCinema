package dominio;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import org.bson.types.ObjectId;

public class SaborPalomitas {

    private ObjectId id;
    private String nombre;
    private double precioExtra;
    private String rutaImagen;

    public SaborPalomitas() {
    }

    public SaborPalomitas(ObjectId id, String nombre, double precioExtra, String rutaImagen) {
        this.id = id;
        this.nombre = nombre;
        this.precioExtra = precioExtra;
        this.rutaImagen = rutaImagen;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

package dominio;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import org.bson.types.ObjectId;

public class SaborBebida {

    private ObjectId id;
    private String nombre;
    private String rutaImagen;
    private double precioExtra;

    public SaborBebida() {
    }

    public SaborBebida(ObjectId id, String nombre, String rutaImagen, double precioExtra) {
        this.id = id;
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
        this.precioExtra = precioExtra;
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

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public double getPrecioExtra() {
        return precioExtra;
    }

    public void setPrecioExtra(double precioExtra) {
        this.precioExtra = precioExtra;
    }
    
}

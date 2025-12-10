package dominio;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;


public class Combo {
    private ObjectId id;
    private String nombre;
    private String rutaImagen;
    private String descripcion;
    private ObjectId tamanoPalomitasId;
    private ObjectId saborPalomitasId;
    private List<ObjectId> bebidasIds = new ArrayList<>();
    private ObjectId dulceId;
    private double precio;

    public Combo(ObjectId id, String nombre, String rutaImagen, String descripcion, ObjectId tamanoPalomitasId, ObjectId saborPalomitasId, ObjectId dulceId, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
        this.descripcion = descripcion;
        this.tamanoPalomitasId = tamanoPalomitasId;
        this.saborPalomitasId = saborPalomitasId;
        this.dulceId = dulceId;
        this.precio = precio;
    }

    public Combo() {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ObjectId getTamanoPalomitasId() {
        return tamanoPalomitasId;
    }

    public void setTamanoPalomitasId(ObjectId tamanoPalomitasId) {
        this.tamanoPalomitasId = tamanoPalomitasId;
    }

    public ObjectId getSaborPalomitasId() {
        return saborPalomitasId;
    }

    public void setSaborPalomitasId(ObjectId saborPalomitasId) {
        this.saborPalomitasId = saborPalomitasId;
    }

    public List<ObjectId> getBebidasIds() {
        return bebidasIds;
    }

    public void setBebidasIds(List<ObjectId> bebidasIds) {
        this.bebidasIds = bebidasIds;
    }

    public ObjectId getDulceId() {
        return dulceId;
    }

    public void setDulceId(ObjectId dulceId) {
        this.dulceId = dulceId;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}

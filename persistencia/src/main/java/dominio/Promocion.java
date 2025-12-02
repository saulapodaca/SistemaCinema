package dominio;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.util.Date;
import org.bson.types.ObjectId;


public class Promocion {

    private ObjectId id;
    private String descripcion;
    private String nombre;
    private double descuento;
    private Date fechaInicio;
    private Date fechaFin;

    public Promocion() {
    }

    public Promocion(ObjectId id, String descripcion, String nombre, double descuento, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
}

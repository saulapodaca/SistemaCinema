package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.util.Date;


public class PromocionDTO {
    
    private String id;
    private String descripcion;
    private String nombre;
    private double descuento;
    private Date fechaInicio;
    private Date fechaFin;

    public PromocionDTO(String id, String nombre,String descripcion, double descuento, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDescuento() {
        return descuento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
   
}

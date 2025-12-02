package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.time.LocalDate;

public class PromocionDTO {

    private String id;
    private String descripcion;
    private String nombre;
    private double descuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public PromocionDTO() {
    }

    public PromocionDTO(String id, String descripcion, String nombre, double descuento, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public PromocionDTO(String descripcion, String nombre, double descuento, LocalDate fechaInicio, LocalDate fechaFin) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.descuento = descuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

}

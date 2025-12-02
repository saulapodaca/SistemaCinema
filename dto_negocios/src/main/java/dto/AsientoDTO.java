package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.enums.EstadoAsiento;

public class AsientoDTO {

    private int fila;
    private int columna;
    private EstadoAsiento estado;
    private String nombre;

    public AsientoDTO() {
    }

    public AsientoDTO(int fila, int columna, EstadoAsiento estado, String nombre) {
        this.fila = fila;
        this.columna = columna;
        this.estado = estado;
        this.nombre = nombre;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public EstadoAsiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsiento estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}

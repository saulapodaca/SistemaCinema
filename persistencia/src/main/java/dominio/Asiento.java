package dominio;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.enums.EstadoAsiento;

public class Asiento {

    private int fila;
    private int columna;
    private EstadoAsiento estadoAsiento;
    private String nombre;

    public Asiento() {
    }

    public Asiento(int fila, int columna, EstadoAsiento estadoAsiento) {
        this.fila = fila;
        this.columna = columna;
        this.estadoAsiento = estadoAsiento;
        char letra = (char) ('A' + (fila-1));
        this.nombre = letra + "-" + columna;
    }

    public Asiento(int fila, int columna, EstadoAsiento estadoAsiento, String nombre) {
        this.fila = fila;
        this.columna = columna;
        this.estadoAsiento = estadoAsiento;
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

    public EstadoAsiento getEstadoAsiento() {
        return estadoAsiento;
    }

    public void setEstadoAsiento(EstadoAsiento estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

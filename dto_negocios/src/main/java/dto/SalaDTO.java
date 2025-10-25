package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class SalaDTO {
    private String nombre;
    private int filas;
    private int columnas;

    public SalaDTO(String nombre, int filas, int columnas) {
        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
    
}

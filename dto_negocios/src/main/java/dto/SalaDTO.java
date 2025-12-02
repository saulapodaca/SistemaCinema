package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
public class SalaDTO {

    private String id;
    private String nombre;
    private int filas;
    private int columnas;

    public SalaDTO() {
    }

    public SalaDTO(String id, String nombre, int filas, int columnas) {
        this.id = id;
        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
    }

    public SalaDTO(String nombre, int filas, int columnas) {
        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
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

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    
}

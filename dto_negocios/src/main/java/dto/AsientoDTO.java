package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
public class AsientoDTO {

    //cambiar esto cuando tengamos dominio
    public enum Estado {
        DISPONIBLE, OCUPADO, APARTADO
    };

    private int fila;
    private int columna;
    private Estado estado;

    public AsientoDTO(int fila, int columna, Estado estado) {
        this.fila = fila;
        this.columna = columna;
        this.estado = estado;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}

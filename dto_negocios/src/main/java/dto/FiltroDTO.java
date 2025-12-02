package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.time.LocalDate;

public class FiltroDTO {
    
    private int pagina;
    private int tamanoPagina;
    private String titulo;
    private LocalDate fecha;

    public FiltroDTO() {
    }

    public FiltroDTO(int pagina, int tamanoPagina, String titulo) {
        this.pagina = pagina;
        this.tamanoPagina = tamanoPagina;
        this.titulo = titulo;
    }

    public FiltroDTO(int pagina, int tamanoPagina, LocalDate fecha) {
        this.pagina = pagina;
        this.tamanoPagina = tamanoPagina;
        this.fecha = fecha;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getTamanoPagina() {
        return tamanoPagina;
    }

    public void setTamanoPagina(int tamanoPagina) {
        this.tamanoPagina = tamanoPagina;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
}

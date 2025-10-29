package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class FiltroDTO {
    
    private int pagina;
    private int tamanoPagina;
    private String titulo;

    public FiltroDTO(int pagina, int tamanoPagina, String titulo) {
        this.pagina = pagina;
        this.tamanoPagina = tamanoPagina;
        this.titulo = titulo;
    }

    public int getPagina() {
        return pagina;
    }

    public int getTamanoPagina() {
        return tamanoPagina;
    }

    public String getTitulo() {
        return titulo;
    }
    
}

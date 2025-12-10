package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.time.LocalDate;


public class ReciboAlimentoDTO {
    private String id;
    private VentaAlimentoDTO venta;
    private String rutaQr;
    private String rutaPdf;
    private LocalDate fechaCompra;

    public ReciboAlimentoDTO() {
    }

    public ReciboAlimentoDTO(String id, VentaAlimentoDTO venta, String rutaQr, String rutaPdf, LocalDate fechaCompra) {
        this.id = id;
        this.venta = venta;
        this.rutaQr = rutaQr;
        this.rutaPdf = rutaPdf;
        this.fechaCompra = fechaCompra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VentaAlimentoDTO getVenta() {
        return venta;
    }

    public void setVenta(VentaAlimentoDTO venta) {
        this.venta = venta;
    }

    public String getRutaQr() {
        return rutaQr;
    }

    public void setRutaQr(String rutaQr) {
        this.rutaQr = rutaQr;
    }

    public String getRutaPdf() {
        return rutaPdf;
    }

    public void setRutaPdf(String rutaPdf) {
        this.rutaPdf = rutaPdf;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    
}

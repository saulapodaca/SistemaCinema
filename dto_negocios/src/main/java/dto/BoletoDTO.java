package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import java.time.LocalDate;
import dto.enums.EstadoBoleto;

public class BoletoDTO {

    private String id;
    private VentaDTO venta;
    private String rutaQr;
    private String rutaPdf;
    private LocalDate fechaCompra;
    private EstadoBoleto estado;

    public BoletoDTO() {
    }

    public BoletoDTO(String id, VentaDTO venta, String rutaQr, String rutaPdf, LocalDate fechaCompra, EstadoBoleto estado) {
        this.id = id;
        this.venta = venta;
        this.rutaQr = rutaQr;
        this.rutaPdf = rutaPdf;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
    }

    public BoletoDTO(VentaDTO venta, String rutaQr, String rutaPdf, LocalDate fechaCompra, EstadoBoleto estado) {
        this.venta = venta;
        this.rutaQr = rutaQr;
        this.rutaPdf = rutaPdf;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VentaDTO getVenta() {
        return venta;
    }

    public void setVenta(VentaDTO venta) {
        this.venta = venta;
    }

    public String getRutaQr() {
        return rutaQr;
    }

    public void setRutaQr(String rutaQr) {
        this.rutaQr = rutaQr;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getRutaPdf() {
        return rutaPdf;
    }

    public void setRutaPdf(String rutaPdf) {
        this.rutaPdf = rutaPdf;
    }

    public EstadoBoleto getEstado() {
        return estado;
    }

    public void setEstado(EstadoBoleto estado) {
        this.estado = estado;
    }
}

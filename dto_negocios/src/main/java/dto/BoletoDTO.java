package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.util.Date;
import java.util.List;


public class BoletoDTO {
    
    private String id;
    private VentaDTO venta;
    private String qr;
    private Date fechaCompra;

    public BoletoDTO(String id, VentaDTO venta) {
        this.id = id;
        this.venta = venta;
        this.fechaCompra = new Date();
    }

    public String getId() {
        return id;
    }

    public VentaDTO getVenta() {
        return venta;
    }

    public String getQr() {
        return qr;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }
   
    @Override
    public String toString() {
        return "BoletoDTO{"
                + "id='" + id + '\''
                + ", funcion=" + venta.getFuncion().getPelicula().getTitulo()
                + ", asientos=" + venta.getAsientos().size()
                + ", costo=" + venta.getTotal()
                + ", fechaCompra=" + fechaCompra
                + '}';
    }
}

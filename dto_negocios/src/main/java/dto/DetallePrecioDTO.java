package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class DetallePrecioDTO {

    private double subtotal;
    private double descuento;
    private double total;

    public DetallePrecioDTO() {
    }

    public DetallePrecioDTO(double subtotal, double descuento, double total) {
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    
}

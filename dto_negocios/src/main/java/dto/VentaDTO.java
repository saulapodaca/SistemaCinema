package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.util.Date;
import java.util.List;

public class VentaDTO {

    private String id;
    private FuncionDTO funcion;
    private List<AsientoDTO> asientos;
    private EmpleadoDTO empleado;
    private PromocionDTO promocion;
    private double subtotal;
    private double descuento;
    private double total;
    private String formaPago;
    private Date fecha;

    public VentaDTO(String id, FuncionDTO funcion, List<AsientoDTO> asientos, EmpleadoDTO empleado, PromocionDTO promocion, double subtotal, double descuento, double total, String formaPago) {
        this.id = id;
        this.funcion = funcion;
        this.asientos = asientos;
        this.empleado = empleado;
        this.promocion = promocion;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
        this.formaPago = formaPago;
        this.fecha = new Date();
    }

    public VentaDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FuncionDTO getFuncion() {
        return funcion;
    }

    public void setFuncion(FuncionDTO funcion) {
        this.funcion = funcion;
    }

    public List<AsientoDTO> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<AsientoDTO> asientos) {
        this.asientos = asientos;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    public PromocionDTO getPromocion() {
        return promocion;
    }

    public void setPromocion(PromocionDTO promocion) {
        this.promocion = promocion;
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

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}

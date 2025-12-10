package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.enums.FormaPago;
import java.time.LocalDate;


public class VentaAlimentoDTO {
    private String id;
    private FormaPago formaPago;
    private double subtotal;
    private double total;
    private LocalDate fecha;
    private ComboDTO combo;
    private EmpleadoDTO empleado;

    public VentaAlimentoDTO() {
    }

    public VentaAlimentoDTO(String id, FormaPago formaPago, double subtotal, double total, LocalDate fecha, ComboDTO combo, EmpleadoDTO empleado) {
        this.id = id;
        this.formaPago = formaPago;
        this.subtotal = subtotal;
        this.total = total;
        this.fecha = fecha;
        this.combo = combo;
        this.empleado = empleado;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public ComboDTO getCombo() {
        return combo;
    }

    public void setCombo(ComboDTO combo) {
        this.combo = combo;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}

package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.enums.FormaPago;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VentaDTO {

    private String id;
    private FuncionDTO funcion;
    private List<AsientoDTO> asientos = new ArrayList<>();
    private EmpleadoDTO empleado;
    private String promocionId;
    private double subtotal;
    private double descuento;
    private double total;
    private FormaPago formaPago;
    private LocalDate fecha;

    public VentaDTO() {
    }

    public VentaDTO(String id, FuncionDTO funcion, List<AsientoDTO> asientos, EmpleadoDTO empleado, String promocionId, double subtotal, double descuento, double total, FormaPago formaPago, LocalDate fecha) {
        this.id = id;
        this.funcion = funcion;
        this.asientos = asientos;
        this.empleado = empleado;
        this.promocionId = promocionId;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
        this.formaPago = formaPago;
        this.fecha = fecha;
    }

    public VentaDTO(FuncionDTO funcion, List<AsientoDTO> asientos, EmpleadoDTO empleado, String promocionId, double subtotal, double descuento, double total, FormaPago formaPago, LocalDate fecha) {
        this.funcion = funcion;
        this.asientos = asientos;
        this.empleado = empleado;
        this.promocionId = promocionId;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.total = total;
        this.formaPago = formaPago;
        this.fecha = fecha;
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

    public String getPromocionId() {
        return promocionId;
    }

    public void setPromocionId(String promocionId) {
        this.promocionId = promocionId;
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

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}

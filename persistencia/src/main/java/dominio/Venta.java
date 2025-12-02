package dominio;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.enums.FormaPago;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;


public class Venta {
    
    private ObjectId id;
    private ObjectId funcionId;
    private List<Asiento> asientos;
    private ObjectId empleadoId;
    private double subtotal;
    private double total;
    private double descuento;
    private FormaPago formaPago;
    private Date fecha;
    private ObjectId promocionId;

    public Venta() {
    }

    public Venta(ObjectId id, ObjectId funcionId, List<Asiento> asientos, ObjectId empleadoId, double subtotal, double total, double descuento, FormaPago formaPago, Date fecha, ObjectId promocionId) {
        this.id = id;
        this.funcionId = funcionId;
        this.asientos = asientos;
        this.empleadoId = empleadoId;
        this.subtotal = subtotal;
        this.total = total;
        this.descuento = descuento;
        this.formaPago = formaPago;
        this.fecha = fecha;
        this.promocionId = promocionId;
    }

    public Venta(ObjectId id, ObjectId funcionId, List<Asiento> asientos, ObjectId empleadoId, double subtotal, double total, double descuento, FormaPago formaPago, Date fecha) {
        this.id = id;
        this.funcionId = funcionId;
        this.asientos = asientos;
        this.empleadoId = empleadoId;
        this.subtotal = subtotal;
        this.total = total;
        this.descuento = descuento;
        this.formaPago = formaPago;
        this.fecha = fecha;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getFuncionId() {
        return funcionId;
    }

    public void setFuncionId(ObjectId funcionId) {
        this.funcionId = funcionId;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }

    public ObjectId getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(ObjectId empleadoId) {
        this.empleadoId = empleadoId;
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

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ObjectId getPromocionId() {
        return promocionId;
    }

    public void setPromocionId(ObjectId promocionId) {
        this.promocionId = promocionId;
    }
    
}

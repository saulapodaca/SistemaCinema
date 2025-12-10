package dominio;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.enums.FormaPago;
import java.util.Date;
import org.bson.types.ObjectId;


public class VentaAlimento {
    private ObjectId id;
    private FormaPago formaPago;
    private double subtotal;
    private double total;
    private Date fecha;
    private ObjectId comboId;
    private ObjectId empleadoId;

    public VentaAlimento() {
    }

    public VentaAlimento(ObjectId id, FormaPago formaPago, double subtotal, double total, Date fecha, ObjectId comboId, ObjectId empleadoId) {
        this.id = id;
        this.formaPago = formaPago;
        this.subtotal = subtotal;
        this.total = total;
        this.fecha = fecha;
        this.comboId = comboId;
        this.empleadoId = empleadoId;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ObjectId getComboId() {
        return comboId;
    }

    public void setComboId(ObjectId comboId) {
        this.comboId = comboId;
    }

    public ObjectId getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(ObjectId empleadoId) {
        this.empleadoId = empleadoId;
    }
    
}

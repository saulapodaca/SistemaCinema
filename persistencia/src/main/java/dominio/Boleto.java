package dominio;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import java.util.Date;
import org.bson.types.ObjectId;
import dto.enums.EstadoBoleto;

public class Boleto {

    private ObjectId id;
    private ObjectId ventaId;
    private String rutaQr;
    private String rutaPdf;
    private Date fechaCompra;
    private EstadoBoleto estado;

    public Boleto() {
    }

    public Boleto(ObjectId id, ObjectId ventaId, String rutaQr, Date fechaCompra, String rutaPdf, EstadoBoleto estado) {
        this.id = id;
        this.ventaId = ventaId;
        this.rutaQr = rutaQr;
        this.fechaCompra = fechaCompra;
        this.rutaPdf = rutaPdf;
        this.estado = estado;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getVentaId() {
        return ventaId;
    }

    public void setVentaId(ObjectId ventaId) {
        this.ventaId = ventaId;
    }

    public String getRutaQr() {
        return rutaQr;
    }

    public void setRutaQr(String rutaQr) {
        this.rutaQr = rutaQr;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
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

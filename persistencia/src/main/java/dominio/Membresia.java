package dominio;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.enums.TipoMembresia;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;


public class Membresia {
    
    private ObjectId id;
    private String codigoMembresia;
    private TipoMembresia tipoMembresia;
    private String nombreCliente;
    private Date fechaRegistro;
    private boolean activa;
    private int saldo;
    private List<ObjectId> promocionesIds;

    public Membresia() {
    }

    public Membresia(ObjectId id, String codigoMembresia, TipoMembresia tipoMembresia, String nombreCliente, Date fechaRegistro, boolean activa, List<ObjectId> promocionesIds) {
        this.id = id;
        this.codigoMembresia = codigoMembresia;
        this.tipoMembresia = tipoMembresia;
        this.nombreCliente = nombreCliente;
        this.fechaRegistro = fechaRegistro;
        this.activa = activa;
        this.promocionesIds = promocionesIds;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCodigoMembresia() {
        return codigoMembresia;
    }

    public void setCodigoMembresia(String codigoMembresia) {
        this.codigoMembresia = codigoMembresia;
    }

    public TipoMembresia getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(TipoMembresia tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public List<ObjectId> getPromocionesIds() {
        return promocionesIds;
    }

    public void setPromocionesIds(List<ObjectId> promocionesIds) {
        this.promocionesIds = promocionesIds;
    }
    
}

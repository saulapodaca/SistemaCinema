package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.enums.TipoMembresia;
import java.time.LocalDate;
import java.util.List;


public class MembresiaDTO {
    
    private String id;
    private String codigoMembresia;
    private TipoMembresia tipoMembresia;
    private String nombreCliente;
    private LocalDate fechaRegistro;
    private boolean activa;
    private List<String> promocionesIds;

    public MembresiaDTO() {
    }

    public MembresiaDTO(String id, String codigoMembresia, TipoMembresia tipoMembresia, String nombreCliente, LocalDate fechaRegistro, boolean activa, List<String> promocionesIds) {
        this.id = id;
        this.codigoMembresia = codigoMembresia;
        this.tipoMembresia = tipoMembresia;
        this.nombreCliente = nombreCliente;
        this.fechaRegistro = fechaRegistro;
        this.activa = activa;
        this.promocionesIds = promocionesIds;
    }

    public MembresiaDTO(String codigoMembresia, TipoMembresia tipoMembresia, String nombreCliente, LocalDate fechaRegistro, boolean activa, List<String> promocionesIds) {
        this.codigoMembresia = codigoMembresia;
        this.tipoMembresia = tipoMembresia;
        this.nombreCliente = nombreCliente;
        this.fechaRegistro = fechaRegistro;
        this.activa = activa;
        this.promocionesIds = promocionesIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public List<String> getPromocionesIds() {
        return promocionesIds;
    }

    public void setPromociones(List<String> promocionesIds) {
        this.promocionesIds = promocionesIds;
    }

}

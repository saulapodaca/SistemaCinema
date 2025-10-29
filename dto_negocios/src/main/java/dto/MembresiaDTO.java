package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MembresiaDTO {
    public enum TipoMembresia {ESTUDIANTE, ADULTO_MAYOR}
    
    private String codigoMembresia;
    private TipoMembresia tipoMembresia;
    private String nombreCliente;
    private Date fechaRegistro;
    private boolean activa;
    private List<PromocionDTO> promociones;

    public MembresiaDTO(String codigoMembresia, TipoMembresia tipoMembresia, String nombreCliente, Date fechaRegistro, boolean activa) {
        this.codigoMembresia = codigoMembresia;
        this.tipoMembresia = tipoMembresia;
        this.nombreCliente = nombreCliente;
        this.fechaRegistro = fechaRegistro;
        this.activa = activa;
        this.promociones = new ArrayList<>();
    }

    public String getCodigoMembresia() {
        return codigoMembresia;
    }

    public TipoMembresia getTipoMembresia() {
        return tipoMembresia;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public boolean isActiva() {
        return activa;
    }

    public List<PromocionDTO> getPromociones() {
        return promociones;
    }
    
    
}

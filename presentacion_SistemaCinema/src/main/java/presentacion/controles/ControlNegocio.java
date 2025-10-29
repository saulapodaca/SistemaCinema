package presentacion.controles;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.AsientoDTO;
import dto.BoletoDTO;
import dto.EmpleadoDTO;
import dto.FiltroDTO;
import dto.FuncionDTO;
import dto.MembresiaDTO;
import dto.PeliculaDTO;
import dto.PromocionDTO;
import itson.negocios_venderboleto.fabrica.GestorFactory;
import itson.negocios_venderboleto.fachada.IVentaBoletoFacade;
import itson.negocios_venderboleto.fachada.VentaBoletoFacade;
import java.util.Date;
import java.util.List;


public class ControlNegocio {
    
    private static ControlNegocio instance;

    private final IVentaBoletoFacade facade;

    private ControlNegocio() {
        this.facade = new VentaBoletoFacade(new GestorFactory()); 
    }
    
    public static ControlNegocio getInstance() {
        if (instance == null) {
            instance = new ControlNegocio();
        }
        return instance;
    }
    
    public List<PeliculaDTO> obtenerCartelera(FiltroDTO filtro) {
        return facade.obtenerPeliculas(filtro);
    }

    public List<FuncionDTO> obtenerFunciones(PeliculaDTO pelicula, Date fecha) {
        return facade.listarFunciones(pelicula, fecha);
    }

    public List<AsientoDTO> obtenerAsientos(FuncionDTO funcion) {
        return facade.obtenerAsientos(funcion);
    }

    public BoletoDTO vender(FuncionDTO funcion,
            List<AsientoDTO> asientos,
            EmpleadoDTO empleado,
            MembresiaDTO membresia,
            PromocionDTO promo) {
        return facade.venderBoleto(funcion, asientos, empleado, membresia, promo);
    }
    
    public void mandarCorreo(BoletoDTO boleto, String correo){
        facade.mandarBoletoCorreo(boleto, correo);
    }
}

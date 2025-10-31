package presentacion.controles;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.AsientoDTO;
import dto.BoletoDTO;
import dto.DetallePrecioDTO;
import dto.EmpleadoDTO;
import dto.FiltroDTO;
import dto.FuncionDTO;
import dto.MembresiaDTO;
import dto.PeliculaDTO;
import dto.PromocionDTO;
import dto.VentaDTO;
import itson.negocios_venderboleto.fabrica.GestorFactory;
import itson.negocios_venderboleto.fachada.IVentaBoletoFacade;
import itson.negocios_venderboleto.fachada.VentaBoletoFacade;
import java.util.Date;
import java.util.List;
import presentacion.utilerias.GestorSesion;


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
    
    public List<PromocionDTO> obtenerPromocionesMembresia (MembresiaDTO membresia){
        return facade.listarPromocionesMembresia(membresia);
    }
    
    public List<PromocionDTO> obtenerPromocionesGenerales(){
        return facade.listarPromocionesGenerales();
    }
    
    public MembresiaDTO buscarMembresia(String codigoMembresia){
        return facade.verificarMembresia(codigoMembresia);
    }

    public BoletoDTO registrarVenta(VentaDTO venta) {
        return facade.venderBoleto(venta);
    }
    
    public void mandarCorreo(BoletoDTO boleto, String correo){
        facade.mandarBoletoCorreo(boleto, correo);
    }

    public DetallePrecioDTO calcularPrecios(List<AsientoDTO> asientos, PromocionDTO promo){
        return facade.calcularPrecios(asientos, promo);
    }
    
    public PromocionDTO obtenerPromocionPorNombre(String nombrePromo){
        return facade.obtenerPromocionPorNombre(nombrePromo);
    }
    
    public PromocionDTO validarCupon(String codigoCupon){
        return facade.validarCupon(codigoCupon);
    }
    
    public EmpleadoDTO getEmpleadoActual(String idEmpleado){
        return facade.obtenerEmpleadoSesion(idEmpleado);
    }
    
}

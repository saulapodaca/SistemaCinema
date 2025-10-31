package itson.negocios_venderboleto.fachada;

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
import itson.negocios_gestorasientos.IGestorAsientos;
import itson.negocios_gestorempleados.IGestorEmpleados;
import itson.negocios_gestorfunciones.IGestorFunciones;
import itson.negocios_gestormembresias.IGestorMembresias;
import itson.negocios_gestorpeliculas.IGestorPeliculas;
import itson.negocios_gestorpromociones.IGestorPromociones;
import itson.negocios_gestorventas.IGestorVentas;
import itson.negocios_venderboleto.IVentaBoleto;
import itson.negocios_venderboleto.VentaBoleto;
import itson.negocios_venderboleto.fabrica.GestorFactory;
import java.util.Date;
import java.util.List;

public class VentaBoletoFacade implements IVentaBoletoFacade {

    private final IVentaBoleto ventaBoleto;
    private final IGestorPeliculas gestorPeliculas;
    private final IGestorFunciones gestorFunciones;
    private final IGestorAsientos gestorAsientos;
    private final IGestorEmpleados gestorEmpleados;
    private final IGestorMembresias gestorMembresias;
    private final IGestorVentas gestorVentas;
    private final IGestorPromociones gestorPromociones;

    public VentaBoletoFacade(GestorFactory factory) {
        this.gestorPeliculas = factory.crearGestorPeliculas();
        this.gestorFunciones = factory.crearGestorFunciones();
        this.gestorAsientos = factory.crearGestorAsientos();
        this.gestorEmpleados = factory.crearGestorEmpleados();
        this.gestorMembresias = factory.crearGestorMembresias();
        this.gestorVentas = factory.crearGestorVentas();
        this.gestorPromociones = factory.crearGestorPromociones();

        IVentaBoleto venta = new VentaBoleto(
                gestorVentas,
                factory.crearGestorBoletos(),
                gestorAsientos,
                factory.crearGeneradorQR(),
                factory.crearCorreoElectronico()
        );
        this.ventaBoleto = venta;
    }

    @Override
    public BoletoDTO venderBoleto(VentaDTO venta) {
        return ventaBoleto.venderBoleto(venta);
    }

    @Override
    public void mandarBoletoCorreo(BoletoDTO boleto, String correo) {
        ventaBoleto.mandarBoletoCorreo(boleto, correo);
    }

    @Override
    public List<PeliculaDTO> obtenerPeliculas(FiltroDTO filtro) {
        return gestorPeliculas.listarCartelera(filtro);
    }

    @Override
    public List<FuncionDTO> listarFunciones(PeliculaDTO pelicula, Date fecha) {
        return gestorFunciones.obtenerFuncionesPorPelícula(pelicula, fecha);
    }

    @Override
    public List<AsientoDTO> obtenerAsientos(FuncionDTO funcion) {
        return gestorAsientos.obtenerAsientos(funcion);
    }

    @Override
    public EmpleadoDTO obtenerEmpleadoSesion(String idEmpleado) {
        return gestorEmpleados.obtenerSesion();
    }

    @Override
    public List<PromocionDTO> listarPromocionesMembresia(MembresiaDTO membresia) {
        return gestorPromociones.obtenerPromocionesMembresia(membresia.getCodigoMembresia());
    }
    
    @Override
    public List<PromocionDTO> listarPromocionesGenerales(){
        return gestorPromociones.obtenerPromocionesGenerales();
    }

    @Override
    public MembresiaDTO verificarMembresia(String codigo) {
        return gestorMembresias.buscarMembresia(codigo);
    }

    @Override
    public VentaDTO obtenerVentaPorId(String idVenta) {
        return gestorVentas.obtenerVentaPorID(idVenta);
    }
    
    @Override
    public DetallePrecioDTO calcularPrecios(List<AsientoDTO> asientos, PromocionDTO promo){
        return gestorVentas.calcularPrecios(asientos, promo);
    }
    
    @Override
    public PromocionDTO obtenerPromocionPorNombre(String nombrePromo){
        return gestorPromociones.obtenerPromocionPorNombre(nombrePromo);
    }

    @Override
    public PromocionDTO validarCupon(String codigoCupon){
        return gestorPromociones.validarCupon(codigoCupon);
    }
}

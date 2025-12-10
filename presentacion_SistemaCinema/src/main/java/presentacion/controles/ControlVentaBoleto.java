package presentacion.controles;

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
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.PeliculaNoExistenteException;
import exceptions.SalaNoExistenteException;
import exceptions.SucursalNoExistenteException;
import itson.negocios_generadorqr.exceptions.QRGeneradorException;
import itson.negocios_venderboleto.fabrica.GestorFactory;
import itson.negocios_venderboleto.fachada.IVentaBoletoFacade;
import itson.negocios_venderboleto.fachada.VentaBoletoFacade;
import java.util.List;

/**
 *
 * @author Saul Isaac Apodaca Baldenegro - 00000252020
 * @author Alejandro Rodríguez Lugo - 00000251622
 */
public class ControlVentaBoleto {

    private static ControlVentaBoleto instance;

    private final IVentaBoletoFacade facade;

    private ControlVentaBoleto() {
        this.facade = new VentaBoletoFacade(new GestorFactory());
    }

    public static synchronized ControlVentaBoleto getInstance() {
        if (instance == null) {
            instance = new ControlVentaBoleto();
        }
        return instance;
    }

    public List<PeliculaDTO> obtenerCartelera(FiltroDTO filtro) {
        return facade.obtenerPeliculas(filtro);
    }

    public List<FuncionDTO> obtenerFunciones(PeliculaDTO pelicula, FiltroDTO filtro) throws FuncionNoEncontradaException {
        return facade.listarFunciones(pelicula, filtro);
    }

    public List<AsientoDTO> obtenerAsientos(FuncionDTO funcion) throws FuncionNoEncontradaException, PeliculaNoExistenteException, SalaNoExistenteException {
        return facade.obtenerAsientos(funcion);
    }

    public List<PromocionDTO> obtenerPromocionesMembresia(MembresiaDTO membresia) {
        return facade.listarPromocionesMembresia(membresia);
    }

    public List<PromocionDTO> obtenerPromocionesGenerales() {
        return facade.listarPromocionesGenerales();
    }

    public MembresiaDTO buscarMembresia(String codigoMembresia) {
        return facade.verificarMembresia(codigoMembresia);
    }

    public BoletoDTO registrarVenta(VentaDTO venta) throws QRGeneradorException {
        return facade.venderBoleto(venta);
    }

    public void mandarCorreo(String destino, String asunto, String mensajeHtml, byte[] jasper) throws Exception {
        facade.mandarBoletoCorreo(destino, asunto, mensajeHtml, jasper);
    }

    public DetallePrecioDTO calcularPrecios(List<AsientoDTO> asientos, PromocionDTO promo) {
        return facade.calcularPrecios(asientos, promo);
    }

    public PromocionDTO validarCupon(String codigoCupon) {
        return facade.validarCupon(codigoCupon);
    }

    public EmpleadoDTO getEmpleadoActual(String idEmpleado) throws EmpleadoNoEncontradoException, SucursalNoExistenteException {
        return facade.obtenerEmpleadoPorId(idEmpleado);
    }

    public byte[] generarPDFBoleto(BoletoDTO boleto) throws Exception {
        return facade.generarPDFBoleto(boleto);
    }
}
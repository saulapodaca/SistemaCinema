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
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.PeliculaNoExistenteException;
import exceptions.SalaNoExistenteException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import itson.negocios_generadorqr.exceptions.QRGeneradorException;
import itson.negocios_gestorempleados.IGestorEmpleados;
import itson.negocios_gestorfunciones.IGestorFunciones;
import itson.negocios_gestormembresias.IGestorMembresias;
import itson.negocios_gestorpeliculas.IGestorPeliculas;
import itson.negocios_gestorpromociones.IGestorPromociones;
import itson.negocios_gestorventas.IGestorVentas;
import itson.negocios_venderboleto.IVentaBoleto;
import itson.negocios_venderboleto.VentaBoleto;
import itson.negocios_venderboleto.fabrica.GestorFactory;
import java.util.List;

public class VentaBoletoFacade implements IVentaBoletoFacade {

    private final IVentaBoleto ventaBoleto;
    private final IGestorPeliculas gestorPeliculas;
    private final IGestorFunciones gestorFunciones;
    private final IGestorEmpleados gestorEmpleados;
    private final IGestorMembresias gestorMembresias;
    private final IGestorVentas gestorVentas;
    private final IGestorPromociones gestorPromociones;

    public VentaBoletoFacade(GestorFactory factory) {
        this.gestorPeliculas = factory.crearGestorPeliculas();
        this.gestorFunciones = factory.crearGestorFunciones();
        this.gestorEmpleados = factory.crearGestorEmpleados();
        this.gestorMembresias = factory.crearGestorMembresias();
        this.gestorVentas = factory.crearGestorVentas();
        this.gestorPromociones = factory.crearGestorPromociones();

        IVentaBoleto venta = new VentaBoleto(
                gestorVentas,
                factory.crearGestorBoletos(),
                factory.crearGestorFunciones(),
                factory.crearGeneradorQR(),
                factory.crearCorreoElectronico()
        );
        this.ventaBoleto = venta;
    }

    @Override
    public BoletoDTO venderBoleto(VentaDTO venta) throws QRGeneradorException {
        try {
            return ventaBoleto.venderBoleto(venta);
        } catch (QRGeneradorException e) {
            throw new QRGeneradorException(e.getMessage());
        } catch (Exception e) {
            throw new QRGeneradorException(e.getMessage());
        }
    }

    @Override
    public void mandarBoletoCorreo(String destino, String asunto, String mensajeHtml, byte[] jasper) throws Exception {
        ventaBoleto.mandarBoletoCorreo(destino, asunto, mensajeHtml, jasper);
    }

    @Override
    public List<PeliculaDTO> obtenerPeliculas(FiltroDTO filtro) {
        return gestorPeliculas.obtenerPeliculas(filtro);
    }

    @Override
    public List<FuncionDTO> listarFunciones(PeliculaDTO pelicula, FiltroDTO filtro) throws FuncionNoEncontradaException {
        return gestorFunciones.obtenerFuncionesPorPelícula(pelicula, filtro);
    }

    @Override
    public List<AsientoDTO> obtenerAsientos(FuncionDTO funcion) throws FuncionNoEncontradaException, PeliculaNoExistenteException, SalaNoExistenteException {
        return gestorFunciones.obtenerAsientos(funcion);
    }

    @Override
    public EmpleadoDTO obtenerEmpleadoPorId(String idEmpleado) throws EmpleadoNoEncontradoException, SucursalNoExistenteException {
        return gestorEmpleados.obtenerPorId(idEmpleado);
    }

    @Override
    public List<PromocionDTO> listarPromocionesMembresia(MembresiaDTO membresia) {
        return gestorPromociones.obtenerPromocionesMembresia(membresia.getCodigoMembresia());
    }

    @Override
    public List<PromocionDTO> listarPromocionesGenerales() {
        return gestorPromociones.obtenerPromocionesGenerales();
    }

    @Override
    public MembresiaDTO verificarMembresia(String codigo) {
        return gestorMembresias.buscarMembresia(codigo);
    }

    @Override
    public VentaDTO obtenerVentaPorId(String idVenta) throws EmpleadoNoEncontradoException, FuncionNoEncontradaException, SucursalNoExistenteException, VentaNoEncontradaException {
        return gestorVentas.obtenerVentaPorID(idVenta);
    }

    @Override
    public DetallePrecioDTO calcularPrecios(List<AsientoDTO> asientos, PromocionDTO promo) {
        return gestorVentas.calcularPrecios(asientos, promo);
    }

    @Override
    public PromocionDTO validarCupon(String codigoCupon) {
        return gestorPromociones.validarCupon(codigoCupon);
    }
}

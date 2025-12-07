package itson.negocios_venderboleto.fachada;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
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
import exceptions.BoletoNoExistenteException;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.PeliculaNoExistenteException;
import exceptions.PromocionNoExistenteException;
import exceptions.SalaNoExistenteException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import itson.negocios_generadorqr.exceptions.QRGeneradorException;
import itson.negocios_gestorboletos.IGestorBoletos;
import itson.negocios_gestorempleados.IGestorEmpleados;
import itson.negocios_gestorfunciones.IGestorFunciones;
import itson.negocios_gestormembresias.IGestorMembresias;
import itson.negocios_gestorpeliculas.IGestorPeliculas;
import itson.negocios_gestorpromociones.IGestorPromociones;
import itson.negocios_gestorventas.IGestorVentas;
import itson.negocios_venderboleto.IVentaBoleto;
import itson.negocios_venderboleto.VentaBoleto;
import itson.negocios_venderboleto.fabrica.GestorFactory;
import itson.infraestructura_lectorqr.LectorQR;
import itson.infraestructura_lectorqr.ILectorQR;
import itson.infraestructura_generadorpdf.IGeneradorPDF;
import java.time.LocalDate;
import java.util.List;

public class VentaBoletoFacade implements IVentaBoletoFacade {

    private final IVentaBoleto ventaBoleto;
    private final IGestorPeliculas gestorPeliculas;
    private final IGestorFunciones gestorFunciones;
    private final IGestorEmpleados gestorEmpleados;
    private final IGestorMembresias gestorMembresias;
    private final IGestorVentas gestorVentas;
    private final IGestorPromociones gestorPromociones;
    private final ILectorQR gestorLectorQR;
    private final IGestorBoletos gestorBoletos;
    private final IGeneradorPDF gestorGeneradorPDF;

    public VentaBoletoFacade(GestorFactory factory) {
        this.gestorPeliculas = factory.crearGestorPeliculas();
        this.gestorFunciones = factory.crearGestorFunciones();
        this.gestorEmpleados = factory.crearGestorEmpleados();
        this.gestorMembresias = factory.crearGestorMembresias();
        this.gestorVentas = factory.crearGestorVentas();
        this.gestorPromociones = factory.crearGestorPromociones();
        this.gestorLectorQR = factory.crearLectorQR();
        this.gestorBoletos = factory.crearGestorBoletos();
        this.gestorGeneradorPDF = factory.crearGeneradorPDF();

        IVentaBoleto venta = new VentaBoleto(
                gestorVentas,
                factory.crearGestorBoletos(),
                factory.crearGestorFunciones(),
                factory.crearGeneradorQR(),
                factory.crearCorreoElectronico(),
                factory.crearGeneradorPDF()
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

    @Override
    public VentaDTO actualizarVenta(VentaDTO ventaDTO) throws PromocionNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, IllegalArgumentException, SucursalNoExistenteException, VentaNoEncontradaException {
        return gestorVentas.actualizarVenta(ventaDTO);
    }

    @Override
    public VentaDTO reagendarBoleto(VentaDTO ventaAntigua, VentaDTO ventaNueva, List<AsientoDTO> asientosLiberar, List<AsientoDTO> asientosNuevos) throws FuncionNoEncontradaException, PromocionNoExistenteException, EmpleadoNoEncontradoException, IllegalArgumentException, VentaNoEncontradaException, SucursalNoExistenteException {
        return ventaBoleto.reagendarBoleto(ventaAntigua, ventaNueva, asientosLiberar, asientosNuevos);
    }

    @Override
    public String escanearQR(Webcam webcam) {
        return gestorLectorQR.escanearQR(webcam);
    }

    @Override
    public WebcamPanel getPanelCamara() {
        return gestorLectorQR.getPanelCamara();
    }

    @Override
    public BoletoDTO buscarBoletoPorId(String id) throws BoletoNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, SucursalNoExistenteException, VentaNoEncontradaException {
        return gestorBoletos.buscarBoletoPorId(id);
    }

    @Override
    public byte[] generarPDFBoleto(BoletoDTO boleto) throws Exception {
        return gestorGeneradorPDF.generarPDFBoleto(boleto);
    }

    @Override
//    public byte[] generarPDFPelicula(PeliculaDTO pelicula) throws Exception {
//        return gestorGeneradorPDF.generarPDFPelicula(pelicula);
//    }

    public byte[] generarPDFPelicula(PeliculaDTO peliculaDTO, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        return gestorGeneradorPDF.generarPDFPelicula(peliculaDTO, fechaInicio, fechaFin);
    }

    @Override
    public BoletoDTO actualizar(BoletoDTO boleto) throws BoletoNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, IllegalArgumentException, SucursalNoExistenteException, VentaNoEncontradaException {
        return gestorBoletos.actualizar(boleto);
    }
}

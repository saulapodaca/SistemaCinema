package itson.negocios_venderboleto;

import dto.AsientoDTO;
import dto.BoletoDTO;
import dto.VentaDTO;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.PromocionNoExistenteException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import itson.negocios_correoelectronico.ICorreoElectronico;
import itson.negocios_generadorqr.IGeneradorQR;
import itson.negocios_generadorqr.exceptions.QRGeneradorException;
import itson.negocios_gestorboletos.IGestorBoletos;
import itson.negocios_gestorfunciones.IGestorFunciones;
import itson.negocios_gestorventas.IGestorVentas;
import java.util.List;

/**
 *
 * @author saula
 */
public class VentaBoleto implements IVentaBoleto {

    private final IGestorVentas gestorVentas;
    private final IGestorBoletos gestorBoletos;
    private final IGestorFunciones gestorFunciones;
    private final IGeneradorQR generadorQR;
    private final ICorreoElectronico correoElectronico;

    /**
     *
     * @param gestorVentas
     * @param gestorBoletos
     * @param gestorFunciones
     * @param generadorQR
     * @param correoElectronico
     */
    public VentaBoleto(IGestorVentas gestorVentas,
            IGestorBoletos gestorBoletos,
            IGestorFunciones gestorFunciones,
            IGeneradorQR generadorQR,
            ICorreoElectronico correoElectronico) {
        this.gestorVentas = gestorVentas;
        this.gestorBoletos = gestorBoletos;
        this.gestorFunciones = gestorFunciones;
        this.generadorQR = generadorQR;
        this.correoElectronico = correoElectronico;
    }

    /**
     *
     * @param venta
     * @return
     * @throws QRGeneradorException
     * @throws Exception
     */
    @Override
    public BoletoDTO venderBoleto(VentaDTO venta) throws QRGeneradorException, Exception {
        gestorFunciones.ocuparAsientos(venta.getFuncion(), venta.getAsientos());
        VentaDTO ventaRegistrada = gestorVentas.registrarVenta(venta);
        BoletoDTO boleto = gestorBoletos.generarBoleto(ventaRegistrada);
        try {
            boleto.setRutaQr(generadorQR.generarQR(boleto.getId()));
            BoletoDTO boletoActualizado = gestorBoletos.actualizar(boleto);
            return boletoActualizado;
        } catch (QRGeneradorException ex) {
            throw new QRGeneradorException(ex.getMessage());
        }
    }

    /**
     *
     * @param destino
     * @param asunto
     * @param mensajeHtml
     * @param jasper
     * @throws Exception 
     */
    @Override
    public void mandarBoletoCorreo(String destino, String asunto, String mensajeHtml, byte[] jasper) throws Exception {
        correoElectronico.enviarBoleto(destino, asunto, mensajeHtml, jasper);
    }

    /**
     * 
     * @param ventaAntigua
     * @param ventaNueva
     * @param asientosLiberar
     * @param asientosNuevos
     * @return
     * @throws FuncionNoEncontradaException
     * @throws PromocionNoExistenteException
     * @throws EmpleadoNoEncontradoException
     * @throws IllegalArgumentException
     * @throws VentaNoEncontradaException
     * @throws SucursalNoExistenteException 
     */
    @Override
    public VentaDTO reagendarBoleto(VentaDTO ventaAntigua, VentaDTO ventaNueva, List<AsientoDTO> asientosLiberar, List<AsientoDTO> asientosNuevos) throws FuncionNoEncontradaException, PromocionNoExistenteException, EmpleadoNoEncontradoException, IllegalArgumentException, VentaNoEncontradaException, SucursalNoExistenteException {
        gestorFunciones.liberarAsientos(ventaAntigua.getFuncion(), asientosLiberar);
        gestorFunciones.ocuparAsientos(ventaNueva.getFuncion(), asientosNuevos);
        VentaDTO ventaActualizada = gestorVentas.actualizarVenta(ventaNueva);
        return ventaActualizada;
    }
}

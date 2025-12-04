package itson.negocios_venderboleto;

import dto.BoletoDTO;
import dto.VentaDTO;
import itson.negocios_correoelectronico.ICorreoElectronico;
import itson.negocios_generadorqr.IGeneradorQR;
import itson.negocios_generadorqr.exceptions.QRGeneradorException;
import itson.negocios_gestorboletos.IGestorBoletos;
import itson.negocios_gestorfunciones.IGestorFunciones;
import itson.negocios_gestorventas.IGestorVentas;

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
     * @param boleto
     * @param correo 
     */
    @Override
    public void mandarBoletoCorreo(BoletoDTO boleto, String correo) {
        correoElectronico.enviarBoleto(correo, boleto);
    }
}

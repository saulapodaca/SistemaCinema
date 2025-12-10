package itson.negocios_vendercombos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.ReciboAlimentoDTO;
import dto.VentaAlimentoDTO;
import exceptions.ComboException;
import exceptions.ReciboAlimentoException;
import itson.negocios_correoelectronico.ICorreoElectronico;
import itson.negocios_generadorqr.IGeneradorQR;
import itson.negocios_generadorqr.exceptions.QRGeneradorException;
import itson.negocios_gestorreciboscombos.IGestorRecibosCombos;
import itson.negocios_gestorventas.IGestorVentas;
import itson.negocios_vendercombos.exceptions.VentaComboException;


public class VentaCombo implements IVentaCombo{

    private IGestorVentas gestorVentas;
    private IGestorRecibosCombos gestorRecibos;
    private final IGeneradorQR generadorQR;
    private final ICorreoElectronico correoElectronico;
    
    public VentaCombo(IGestorVentas gestorVentas,
            IGestorRecibosCombos gestorRecibos,
            IGeneradorQR generadorQR,
            ICorreoElectronico correoElectronico) {
        this.gestorVentas = gestorVentas;
        this.gestorRecibos = gestorRecibos;
        this.generadorQR = generadorQR;
        this.correoElectronico = correoElectronico;
    }
    
    @Override
    public ReciboAlimentoDTO venderCombo(VentaAlimentoDTO venta) throws VentaComboException {
        try {
            VentaAlimentoDTO ventaRegistrada = gestorVentas.registrarVentaCombo(venta);
            ReciboAlimentoDTO recibo = gestorRecibos.generarRecibo(ventaRegistrada);
            recibo.setRutaQr(generadorQR.generarQR(recibo.getId()));
            ReciboAlimentoDTO reciboActualizado = gestorRecibos.actualizar(recibo);
            return reciboActualizado;
        } catch (QRGeneradorException | ComboException | ReciboAlimentoException ex) {
            throw new VentaComboException(ex.getMessage());
        }
    }

    @Override
    public void mandarBoletoCorreoAlimento(ReciboAlimentoDTO recibo, String correo) {
        correoElectronico.enviarRecibo(correo, recibo);
    }

}

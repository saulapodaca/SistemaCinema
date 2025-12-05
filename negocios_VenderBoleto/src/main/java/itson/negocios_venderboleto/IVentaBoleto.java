package itson.negocios_venderboleto;

import dto.BoletoDTO;
import dto.VentaDTO;
import itson.negocios_generadorqr.exceptions.QRGeneradorException;

public interface IVentaBoleto {

    public BoletoDTO venderBoleto(VentaDTO venta) throws QRGeneradorException, Exception;

    void mandarBoletoCorreo(String destino, String asunto, String mensajeHtml, byte[] jasper) throws Exception;
}

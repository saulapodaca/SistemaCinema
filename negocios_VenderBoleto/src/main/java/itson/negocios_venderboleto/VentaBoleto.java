package itson.negocios_venderboleto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.BoletoDTO;
import dto.VentaDTO;
import itson.negocios_correoelectronico.ICorreoElectronico;
import itson.negocios_generadorqr.IGeneradorQR;
import itson.negocios_gestorasientos.IGestorAsientos;
import itson.negocios_gestorboletos.IGestorBoletos;
import itson.negocios_gestorventas.IGestorVentas;

public class VentaBoleto implements IVentaBoleto {

    private final IGestorVentas gestorVentas;
    private final IGestorBoletos gestorBoletos;
    private final IGestorAsientos gestorAsientos;
    private final IGeneradorQR generadorQR;
    private final ICorreoElectronico correoElectronico;

    public VentaBoleto(IGestorVentas gestorVentas,
            IGestorBoletos gestorBoletos,
            IGestorAsientos gestorAsientos,
            IGeneradorQR generadorQR,
            ICorreoElectronico correoElectronico) {
        this.gestorVentas = gestorVentas;
        this.gestorBoletos = gestorBoletos;
        this.gestorAsientos = gestorAsientos;
        this.generadorQR = generadorQR;
        this.correoElectronico = correoElectronico;
    }

    @Override
    public BoletoDTO venderBoleto(VentaDTO venta) {
        gestorAsientos.ocuparAsientos(venta.getFuncion(), venta.getAsientos());
        VentaDTO ventaRegistrada = gestorVentas.registrarVenta(venta);
        BoletoDTO boleto = gestorBoletos.generarBoleto(ventaRegistrada);
        boleto.setQr(generadorQR.generarQR(boleto.getId()));
        return boleto;
    }

    @Override
    public void mandarBoletoCorreo(BoletoDTO boleto, String correo) {
        correoElectronico.enviarBoleto(correo, boleto);
    }
}

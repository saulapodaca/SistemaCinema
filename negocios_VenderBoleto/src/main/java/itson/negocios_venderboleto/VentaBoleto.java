package itson.negocios_venderboleto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.AsientoDTO;
import dto.BoletoDTO;
import dto.EmpleadoDTO;
import dto.FiltroDTO;
import dto.FuncionDTO;
import dto.MembresiaDTO;
import dto.PeliculaDTO;
import dto.PromocionDTO;
import dto.VentaDTO;
import itson.negocios_correoelectronico.ICorreoElectronico;
import itson.negocios_generadorqr.IGeneradorQR;
import itson.negocios_gestorasientos.IGestorAsientos;
import itson.negocios_gestorboletos.IGestorBoletos;
import itson.negocios_gestorventas.IGestorVentas;
import java.util.Date;
import java.util.List;

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
    public BoletoDTO venderBoleto(FuncionDTO funcion, List<AsientoDTO> asientosSeleccionados, EmpleadoDTO empleado, MembresiaDTO membresia, PromocionDTO promoSeleccionada) {
        gestorAsientos.ocuparAsientos(funcion, asientosSeleccionados);
        VentaDTO venta = gestorVentas.registrarVenta(funcion, asientosSeleccionados, empleado, membresia, promoSeleccionada);
        BoletoDTO boleto = gestorBoletos.generarBoleto(venta);
        boleto.setQr(generadorQR.generarQR(boleto.getId()));
        return boleto;
    }

    @Override
    public void mandarBoletoCorreo(BoletoDTO boleto, String correo) {
        correoElectronico.enviarBoleto(correo, boleto);
    }
}

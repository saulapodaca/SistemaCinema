package itson.negocios_gestorboletos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.BoletoDTO;
import dto.VentaDTO;
import java.util.UUID;

public class GestorBoletos implements IGestorBoletos {

    @Override
    public BoletoDTO generarBoleto(VentaDTO venta) {
        // Generar ID único
        String id = UUID.randomUUID().toString();
        BoletoDTO boleto = new BoletoDTO("BOL01", venta);
        return boleto;
    }

    @Override
    public BoletoDTO buscarBoletoPorId(String id) {
        return null;
    }

}

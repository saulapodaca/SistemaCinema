package itson.negocios_correoelectronico;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import dto.BoletoDTO;
import dto.ReciboAlimentoDTO;

public class CorreoElectronico implements ICorreoElectronico {

    @Override
    public void enviarBoleto(String correoDestino, BoletoDTO boleto) {
        System.out.println("Enviando boleto " + boleto.getId()
                + " al correo: " + correoDestino);
        System.out.println("   Película: " + boleto.getVenta().getFuncion().getPelicula().getTitulo());
        System.out.println("   Asientos: " + boleto.getVenta().getAsientos().size());
        System.out.println("   Costo: $" + boleto.getVenta().getTotal());
        System.out.println("   QR: " + boleto.getRutaQr());
    }

    @Override
    public void enviarRecibo(String correoDestino, ReciboAlimentoDTO recibo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


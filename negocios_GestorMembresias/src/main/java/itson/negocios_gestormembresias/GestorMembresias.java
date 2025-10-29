package itson.negocios_gestormembresias;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.MembresiaDTO;
import dto.PromocionDTO;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class GestorMembresias implements IGestorMembresias{

    @Override
    public MembresiaDTO buscarMembresia(String codigoMembresia) {
        return new MembresiaDTO(codigoMembresia, MembresiaDTO.TipoMembresia.ESTUDIANTE, "Saul Apodaca", new Date(), true);
    }

    @Override
    public List<PromocionDTO> obtenerPromociones(String codigoMembresia) {
        return Arrays.asList( 
                new PromocionDTO("PR001", "2x1 Lunes", "Compra un boleto y obtén otro gratis", 0.5, new Date(), new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)),
                new PromocionDTO("PR002", "Descuento del 20%", "Descuento del 20% a estudiantes", 0.2, new Date(), new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
        );
    }

}

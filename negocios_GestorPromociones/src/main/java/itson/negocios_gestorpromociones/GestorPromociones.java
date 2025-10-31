package itson.negocios_gestorpromociones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.PromocionDTO;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class GestorPromociones implements IGestorPromociones{

    @Override
    public List<PromocionDTO> obtenerPromocionesGenerales() {
        return Arrays.asList( 
                new PromocionDTO("PR001", "2x1 Lunes", "Compra un boleto y obtén otro gratis", 0.5, new Date(), new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)),
                new PromocionDTO("PR002", "Descuento del 20%", "Descuento del 20% a estudiantes", 0.2, new Date(), new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
        );
    }

    @Override
    public List<PromocionDTO> obtenerPromocionesMembresia(String codigoMembresia) {
        return Arrays.asList( 
                new PromocionDTO("PR003", "3x2 Estudiantes", "Estudiantes al 3x2", 0.66, new Date(), new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)),
                new PromocionDTO("PR004", "Para viejitos", "Descuento del 20% a personas mayores", 0.2, new Date(), new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
        );
    }
    
    @Override
    public PromocionDTO obtenerPromocionPorNombre(String nombrePromo){
        return new PromocionDTO("PR015", nombrePromo, "La promo buscada", 0.2, new Date(), new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000));
    }

    @Override
    public PromocionDTO validarCupon(String codigoCupon) {
        return new PromocionDTO(codigoCupon, "SUPER PROMOCION", "La promo buscada", 0.2, new Date(), new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000));
    }

}

package itson.negocios_gestorpromociones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import bos.PromocionBO;
import dto.PromocionDTO;
import interfaces.IPromocionBO;
import java.util.List;


public class GestorPromociones implements IGestorPromociones{
    private final IPromocionBO promocionBO = PromocionBO.getInstancia();
    
    @Override
    public List<PromocionDTO> obtenerPromocionesGenerales() {
        return promocionBO.obtenerPromocionesGenerales();
    }

    @Override
    public List<PromocionDTO> obtenerPromocionesMembresia(String codigoMembresia) {
        return promocionBO.obtenerPromocionesMembresia(codigoMembresia);
    }
    
    @Override
    public PromocionDTO obtenerPromocionPorNombre(String nombrePromo) {
        return promocionBO.obtenerPromocionPorNombre(nombrePromo);
    }

    @Override
    public PromocionDTO validarCupon(String codigoCupon) {
        return promocionBO.validarCupon(codigoCupon);
    }

}

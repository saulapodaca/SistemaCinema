package itson.negocios_gestormembresias;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.MembresiaDTO;
import java.util.Date;

public class GestorMembresias implements IGestorMembresias {

    @Override
    public MembresiaDTO buscarMembresia(String codigoMembresia) {
        return new MembresiaDTO(codigoMembresia, MembresiaDTO.TipoMembresia.ESTUDIANTE, "Saul Apodaca", new Date(), true);
    }
}

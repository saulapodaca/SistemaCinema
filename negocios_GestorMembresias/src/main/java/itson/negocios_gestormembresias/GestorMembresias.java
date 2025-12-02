package itson.negocios_gestormembresias;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import bos.MembresiaBO;
import dto.MembresiaDTO;
import interfaces.IMembresiaBO;

public class GestorMembresias implements IGestorMembresias {

    private final IMembresiaBO membresiaBO = MembresiaBO.getInstancia();
    
    @Override
    public MembresiaDTO buscarMembresia(String codigoMembresia) {
        return membresiaBO.buscarMembresia(codigoMembresia);
    }
}

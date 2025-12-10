package itson.negocios_gestormembresias;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
/**
 * @author Héctor Javier Alonso Zaragoza - 00000252039
 * @author Saul Isaac Apodaca Baldenegro - 00000252020
 */

import bos.MembresiaBO;
import dto.MembresiaDTO;
import interfaces.IMembresiaBO;

public class GestorMembresias implements IGestorMembresias {

    private final IMembresiaBO membresiaBO = MembresiaBO.getInstancia();
    
    @Override
    public MembresiaDTO buscarMembresia(String codigoMembresia) {
        System.out.println("4. GestorMembresias - Buscando: '" + codigoMembresia + "'");
    try {
        MembresiaDTO resultado = membresiaBO.buscarMembresia(codigoMembresia);
        System.out.println("4. GestorMembresias - Resultado: " + (resultado != null ? "Encontrado" : "NULL"));
        return resultado;
    } catch (Exception e) {
        System.out.println("4. GestorMembresias - ERROR:");
        e.printStackTrace();
        throw e;
    }
    }
    
    @Override
    public boolean actualizarPuntos(String codigomembresia, int saldoNuevo){
        return membresiaBO.actualizarSaldo(codigomembresia, saldoNuevo);
    }
    
    
    
    
    
}

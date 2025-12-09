/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import com.mycompany.negocios_gestorcanjearbeneficios.GestorCanjearBeneficios;
import com.mycompany.negocios_gestorcanjearbeneficios.IGestorCanjearBeneficios;
import dominio.Membresia;
import dto.MembresiaDTO;
import dto.ObjetoBeneficioDTO;
import java.util.List;

/**
 *
 * @author Elite
 */
public class ControlCanjearBeneficios {
    
    /**
     * Instancia única del control
     */
    private static ControlCanjearBeneficios instance;
    
    private final IGestorCanjearBeneficios canjearbeneficiosfachada;
    
    private ControlCanjearBeneficios(){
        this.canjearbeneficiosfachada = new GestorCanjearBeneficios();
    }
    
    public static synchronized ControlCanjearBeneficios getInstance() {
        if (instance == null) {
            instance = new ControlCanjearBeneficios();
        }
        return instance;
    }
    
    public MembresiaDTO buscarMembresia(String codigoMembresia){
        return canjearbeneficiosfachada.buscarMembresia(codigoMembresia);
    }
    
    public boolean actualizarPuntos(String codigoMembresia, int saldoNuevo){
        return canjearbeneficiosfachada.actualizarPuntos(codigoMembresia, saldoNuevo);
    }
    
    public boolean actualizarStock(String idOB, int unidades_vendidas){
        return canjearbeneficiosfachada.actualizarStock(idOB, unidades_vendidas);
    }
    
    public List<ObjetoBeneficioDTO> obtenerObjetosDisponiblesPorMembresia(Membresia membresia){
        return canjearbeneficiosfachada.obtenerObjetosDisponiblesPorMembresia(membresia);
    } 
    
    
}

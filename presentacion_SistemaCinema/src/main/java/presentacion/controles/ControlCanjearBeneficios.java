/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;


import dominio.Membresia;
import dto.MembresiaDTO;
import dto.ObjetoBeneficioDTO;
import java.util.List;
import itson.negocios_gestorcanjearbeneficiosk.IGestorCanjearBeneficiosK;
import itson.negocios_gestorcanjearbeneficiosk.GestorCanjearBeneficios;

/**
 *
 * @author Elite
 */
public class ControlCanjearBeneficios {
    
    /**
     * Instancia única del control
     */
    private static ControlCanjearBeneficios instance;
    
    private final IGestorCanjearBeneficiosK canjearbeneficiosfachada;
    
    private ControlCanjearBeneficios(){
        System.out.println("Inicializando ControlCanjearBeneficios...");
        this.canjearbeneficiosfachada = new GestorCanjearBeneficios();
        System.out.println("ControlCanjearBeneficios inicializado");
    }
    
    public static synchronized ControlCanjearBeneficios getInstance() {
        if (instance == null) {
            instance = new ControlCanjearBeneficios();
        }
        return instance;
    }
    
    public MembresiaDTO buscarMembresia(String codigoMembresia){
        System.out.println("2. ControlCanjearBeneficios - Buscando: '" + codigoMembresia + "'");
    try {
        MembresiaDTO resultado = canjearbeneficiosfachada.buscarMembresia(codigoMembresia);
        System.out.println("2. ControlCanjearBeneficios - Resultado: " + (resultado != null ? "Encontrado" : "NULL"));
        return resultado;
    } catch (Exception e) {
        System.out.println("2. ControlCanjearBeneficios - ERROR:");
        e.printStackTrace();
        throw e;
    }
        
    }
    
    public boolean actualizarPuntos(String codigoMembresia, int saldoNuevo){
        return canjearbeneficiosfachada.actualizarPuntos(codigoMembresia, saldoNuevo);
    }
    
    public boolean actualizarStock(String idOB, int unidades_vendidas){
        return canjearbeneficiosfachada.actualizarStock(idOB, unidades_vendidas);
    }
    
    public List<ObjetoBeneficioDTO> obtenerObjetosDisponiblesPorMembresia(MembresiaDTO membresia){
        return canjearbeneficiosfachada.obtenerObjetosDisponiblesPorMembresia(membresia);
    } 
    
    
}

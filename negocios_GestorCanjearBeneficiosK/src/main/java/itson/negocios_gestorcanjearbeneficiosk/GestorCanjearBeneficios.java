/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.negocios_gestorcanjearbeneficiosk;

import bos.MembresiaBO;
import bos.ObjetoBeneficioBO;
import dominio.Membresia;
import dto.MembresiaDTO;
import dto.ObjetoBeneficioDTO;
import interfaces.IObjetoBeneficioBO;
import java.util.List;

/**
 *
 * @author Héctor Javier Alonso Zaragoza - 00000252039
 */
public class GestorCanjearBeneficios implements IGestorCanjearBeneficiosK {
    
    
    @Override
    public MembresiaDTO buscarMembresia (String codigoMembresia){
       
    }
    
    @Override
    public boolean actualizarPuntos(String codigomembresia, int saldonuevo){
        
    }
    
    @Override
    public boolean actualizarStock(String idOB, int unidades_vendidas){
         return fachada.actualizarStock(idOB, unidades_vendidas);
     }
    
    @Override
    public List<ObjetoBeneficioDTO> obtenerObjetosDisponiblesPorMembresia(Membresia membresia){
        return fachada.obtenerObjetosDisponiblesPorMembresia(membresia);
    }
    
    
    
    
    
    
    
}

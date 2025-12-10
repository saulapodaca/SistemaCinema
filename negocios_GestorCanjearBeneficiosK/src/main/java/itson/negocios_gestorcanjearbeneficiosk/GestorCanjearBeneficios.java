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
import itson.negocios_gestorObjetosBeneficio.GestorObjetosBeneficio;
import itson.negocios_gestorObjetosBeneficio.IGestorObjetosBeneficio;
import itson.negocios_gestormembresias.GestorMembresias;
import itson.negocios_gestormembresias.IGestorMembresias;
import java.util.List;

/**
 *
 * @author Héctor Javier Alonso Zaragoza - 00000252039
 */
public class GestorCanjearBeneficios implements IGestorCanjearBeneficiosK {
    
    private final IGestorMembresias fachadaMem = new GestorMembresias();
    private final IGestorObjetosBeneficio fachadaObj = new GestorObjetosBeneficio();
    
    @Override
    public MembresiaDTO buscarMembresia (String codigoMembresia){
       return fachadaMem.buscarMembresia(codigoMembresia);
    }
    
    @Override
    public boolean actualizarPuntos(String codigomembresia, int saldonuevo){
        return fachadaMem.actualizarPuntos(codigomembresia, saldonuevo);
    }
    
    @Override
    public boolean actualizarStock(String idOB, int unidades_vendidas){
         return fachadaObj.actualizarStock(idOB, unidades_vendidas);
     }
    
    @Override
    public List<ObjetoBeneficioDTO> obtenerObjetosDisponiblesPorMembresia(Membresia membresia){
        return fachadaObj.obtenerObjetosDisponiblesPorMembresia(membresia);
    }
    
    
    
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.negocios_gestorcanjearbeneficios;

import dominio.Membresia;
import dto.MembresiaDTO;
import dto.ObjetoBeneficioDTO;
import itson.negocios_gestorObjetosBeneficio.GestorObjetosBeneficio;
import itson.negocios_gestorObjetosBeneficio.IGestorObjetosBeneficio;
import itson.negocios_gestormembresias.GestorMembresias;
import itson.negocios_gestormembresias.IGestorMembresias;
import java.util.List;

/**
 *
 * @author Elite
 */
public class GestorCanjearBeneficios implements IGestorCanjearBeneficios {
    
    private final IGestorObjetosBeneficio gestorObjetosBeneficio;
    private final IGestorMembresias gestorMembresias;
    
    
    public GestorCanjearBeneficios(){
        this.gestorMembresias = new GestorMembresias();
        this.gestorObjetosBeneficio = new GestorObjetosBeneficio();
    }
    
    
    @Override
    public MembresiaDTO buscarMembresia (String codigoMembresia){
         return gestorMembresias.buscarMembresia(codigoMembresia);
    }
    
    @Override
    public boolean actualizarPuntos(String codigomembresia, int saldonuevo){
        return gestorMembresias.actualizarPuntos(codigomembresia, saldonuevo);
    }
    
    @Override
    public boolean actualizarStock(String idOB, int unidades_vendidas){
       return gestorObjetosBeneficio.actualizarStock(idOB, unidades_vendidas);
    }
    
    @Override
    public List<ObjetoBeneficioDTO> obtenerObjetosDisponiblesPorMembresia(Membresia membresia){
        return gestorObjetosBeneficio.obtenerObjetosDisponiblesPorMembresia(membresia);
    }
    
    
    
    
    
    
    
}

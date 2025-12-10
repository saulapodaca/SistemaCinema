/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.negocios_gestorObjetosBeneficio;

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
public class GestorObjetosBeneficio implements IGestorObjetosBeneficio {
    
    private final IObjetoBeneficioBO OBJBENBO = ObjetoBeneficioBO.getInstancia();
    
    @Override
    public boolean actualizarStock(String idOB, int unidades_vendidas){
        return OBJBENBO.actualizarStock(idOB, unidades_vendidas);
    }
    
    @Override
    public List<ObjetoBeneficioDTO> obtenerObjetosDisponiblesPorMembresia(MembresiaDTO membresia){
        return OBJBENBO.obtenerObjetosDisponiblesPorMembresia(membresia);
    }
    
    
}

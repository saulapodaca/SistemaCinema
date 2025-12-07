/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Membresia;
import dominio.ObjetoBeneficio;
import dto.ObjetoBeneficioDTO;
import java.util.List;

/**
 *
 * @author Elite
 */
public interface IObjetoBeneficioBO {
    
    
    boolean actualizarStock(String idOB, int unidades_vendidas);
    
    List<ObjetoBeneficioDTO> obtenerObjetosDisponiblesPorMembresia(Membresia membresia);
    
    
    
    
}

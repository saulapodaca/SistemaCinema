/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.negocios_gestorObjetosBeneficio;

import dominio.Membresia;
import dto.ObjetoBeneficioDTO;
import java.util.List;

/**
 *
 * @author Elite
 */
public interface IGestorObjetosBeneficio {
    
    boolean actualizarStock(String idOB, int unidades_vendidas);
    
    List<ObjetoBeneficioDTO> obtenerObjetosDisponiblesPorMembresia(Membresia membresia);
    
    
}

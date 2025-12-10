/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestorcanjearbeneficiosk;

import dominio.Membresia;
import dto.MembresiaDTO;
import dto.ObjetoBeneficioDTO;
import java.util.List;

/**
 *
 * @author Elite
 */
public interface IGestorCanjearBeneficiosK {
    
    
    MembresiaDTO buscarMembresia (String codigoMembresia);
    
    boolean actualizarPuntos(String codigomembresia, int saldonuevo);
    
    
    boolean actualizarStock(String idOB, int unidades_vendidas);
    
    List<ObjetoBeneficioDTO> obtenerObjetosDisponiblesPorMembresia(MembresiaDTO membresia);
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.PromocionDTO;
import exceptions.PromocionNoExistenteException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IPromocionBO {
    
    List<PromocionDTO> obtenerPromocionesGenerales();
    
    List<PromocionDTO> obtenerPromocionesMembresia(String codigoMembresia);
    
    PromocionDTO obtenerPromocionPorNombre(String nombre);
    
    PromocionDTO validarCupon(String codigoPromocion);
    
    PromocionDTO obtenerPorId(String id) throws PromocionNoExistenteException;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestorpromociones;

import dto.PromocionDTO;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IGestorPromociones {

    List<PromocionDTO> obtenerPromocionesGenerales();

    List<PromocionDTO> obtenerPromocionesMembresia(String codigoMembresia);
    
    PromocionDTO obtenerPromocionPorNombre(String nombrePromo);
    
    PromocionDTO validarCupon(String codigoCupon);
}

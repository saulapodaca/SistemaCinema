/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestormembresias;

import dto.MembresiaDTO;
import dto.PromocionDTO;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IGestorMembresias {
    MembresiaDTO buscarMembresia (String codigoMembresia);
    List<PromocionDTO> obtenerPromociones(String codigoMembresia);
}

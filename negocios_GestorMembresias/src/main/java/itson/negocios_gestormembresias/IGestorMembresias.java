/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestormembresias;

import dto.MembresiaDTO;

/**
 *
 * @author Héctor Javier Alonso Zaragoza - 00000252039
 * @author Saul Isaac Apodaca Baldenegro - 00000252020
 */
public interface IGestorMembresias {
    
    MembresiaDTO buscarMembresia (String codigoMembresia);
    
    boolean actualizarPuntos(String codigomembresia, int saldonuevo);
    
    
    
    
}

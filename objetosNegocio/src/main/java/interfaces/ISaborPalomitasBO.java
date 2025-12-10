/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.SaborPalomitasDTO;
import java.util.List;

/**
 *
 * @author saula
 */
public interface ISaborPalomitasBO {
    
    List<SaborPalomitasDTO> obtenerSaboresPalomitas();
    
    SaborPalomitasDTO obtenerPorId(String id);
}

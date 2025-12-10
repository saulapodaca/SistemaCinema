/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.TamanoPalomitasDTO;
import java.util.List;

/**
 *
 * @author saula
 */
public interface ITamanoPalomitasBO {
    
    List<TamanoPalomitasDTO> obtenerTamanosPalomitas();
    
    TamanoPalomitasDTO obtenerPorId(String id);
}

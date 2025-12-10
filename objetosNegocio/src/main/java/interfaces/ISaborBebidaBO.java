/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.SaborBebidaDTO;
import java.util.List;

/**
 *
 * @author saula
 */
public interface ISaborBebidaBO {
    
    List<SaborBebidaDTO> obtenerSaboresBebidas();
    
    SaborBebidaDTO obtenerPorId(String id);
    
    List<SaborBebidaDTO> obtenerPorIds(List<String> ids);
}

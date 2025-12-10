/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.ComboDTO;
import dto.FiltroDTO;
import exceptions.ComboException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IComboBO {

    List<ComboDTO> obtenerCombos(FiltroDTO filtro) throws ComboException;
    
    ComboDTO obtenerComboPorId(String id) throws ComboException;
}

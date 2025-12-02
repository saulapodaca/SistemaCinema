/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.SalaDTO;
import exceptions.SalaNoExistenteException;

/**
 *
 * @author saula
 */
public interface ISalaBO {
    SalaDTO obtenerPorId(String id) throws SalaNoExistenteException;
}

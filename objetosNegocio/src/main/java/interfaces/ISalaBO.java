/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.SalaDTO;
import exceptions.NegocioException;
import exceptions.SalaNoExistenteException;

/**
 *
 * @author saula
 */
public interface ISalaBO {
    
    SalaDTO insertarSala(SalaDTO salaDTO) throws NegocioException;
    
    SalaDTO obtenerPorId(String id) throws SalaNoExistenteException;
    
    SalaDTO obtenerPorNombre(String nombre) throws NegocioException;
    
}

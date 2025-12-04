/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.SucursalDTO;
import exceptions.NegocioException;
import exceptions.SucursalNoExistenteException;

/**
 *
 * @author saula
 */
public interface ISucursalBO {
    
    SucursalDTO insertarSucursal(SucursalDTO sucursalDTO) throws NegocioException;
    
    SucursalDTO obtenerPorId (String id) throws SucursalNoExistenteException;
    
    SucursalDTO obtenerPorNombre (String nombre) throws NegocioException;
    
}

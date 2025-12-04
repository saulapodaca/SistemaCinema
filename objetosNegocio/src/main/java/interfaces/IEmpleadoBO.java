/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.EmpleadoDTO;
import dto.SesionDTO;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.NegocioException;
import exceptions.SesionEmpleadoNoExistenteException;
import exceptions.SucursalNoExistenteException;

/**
 *
 * @author saula
 */
public interface IEmpleadoBO {

    EmpleadoDTO insertarEmpleado(EmpleadoDTO empleado) throws SucursalNoExistenteException, NegocioException ;
    
    EmpleadoDTO obtenerSesionEmpleado(SesionDTO sesion) throws SesionEmpleadoNoExistenteException;

    EmpleadoDTO obtenerPorId(String id) throws EmpleadoNoEncontradoException, SucursalNoExistenteException;
}

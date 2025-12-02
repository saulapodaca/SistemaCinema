/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestorempleados;

import dto.EmpleadoDTO;
import dto.SesionDTO;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.SesionEmpleadoNoExistenteException;
import exceptions.SucursalNoExistenteException;

/**
 *
 * @author saula
 */
public interface IGestorEmpleados {
    EmpleadoDTO obtenerSesionEmpleado (SesionDTO sesion) throws SesionEmpleadoNoExistenteException, SucursalNoExistenteException ;
    
    EmpleadoDTO obtenerPorId(String idEmpleado) throws EmpleadoNoEncontradoException, SucursalNoExistenteException ;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_iniciosesion;

import dto.EmpleadoDTO;
import dto.SesionDTO;
import exceptions.SesionEmpleadoNoExistenteException;

/**
 *
 * @author saula
 */
public interface IInicioSesionFachada {
    
    EmpleadoDTO iniciarSesion(SesionDTO sesion) throws SesionEmpleadoNoExistenteException;
    
}

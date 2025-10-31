/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestorempleados;

import dto.EmpleadoDTO;

/**
 *
 * @author saula
 */
public interface IGestorEmpleados {
    EmpleadoDTO obtenerSesion(String idEmpleado);
}

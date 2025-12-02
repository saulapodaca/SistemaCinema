/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Empleado;
import dto.SesionDTO;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public interface IEmpleadoDAO {

    Empleado insertar(Empleado empleado);

    Empleado actualizar(Empleado empleado);

    Empleado obtenerPorId(ObjectId id);

    Empleado obtenerSesion(SesionDTO sesion);
}

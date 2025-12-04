/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Sucursal;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public interface ISucursalDAO {

    Sucursal insertar(Sucursal sucursal);

    Sucursal actualizar(Sucursal sucursal);

    Sucursal obtenerPorId(ObjectId id);
    
    Sucursal obtenerPorNombre(String nombre);
}

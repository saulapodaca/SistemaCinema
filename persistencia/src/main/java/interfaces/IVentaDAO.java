/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Venta;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public interface IVentaDAO {

    Venta insertar(Venta venta);

    Venta actualizar(Venta venta);

    Venta obtenerPorId(ObjectId id);
}

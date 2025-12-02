/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Promocion;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public interface IPromocionDAO {

    Promocion insertar(Promocion promo);

    Promocion actualizar(Promocion promo);

    Promocion obtenerPorId(ObjectId id);

    List<Promocion> obtenerTodas();

    Promocion buscarPorNombre(String nombre);
}

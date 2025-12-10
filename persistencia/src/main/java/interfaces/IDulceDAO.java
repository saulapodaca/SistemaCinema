/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Dulce;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public interface IDulceDAO {
    Dulce insertar(Dulce dulce);

    Dulce actualizar(Dulce Dulce);

    Dulce obtenerPorId(ObjectId id);

    List<Dulce> obtenerDulces();
}

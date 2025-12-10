/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.SaborBebida;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public interface ISaborBebidaDAO {

    SaborBebida insertar(SaborBebida saborBebida);

    SaborBebida actualizar(SaborBebida saborBebida);

    SaborBebida obtenerPorId(ObjectId id);

    List<SaborBebida> obtenerSabores();

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Combo;
import dto.FiltroDTO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public interface IComboDAO {

    Combo insertar(Combo combo);

    Combo actualizar(Combo combo);

    Combo obtenerPorId(ObjectId id);

    List<Combo> obtenerCombos(FiltroDTO filtro);
}

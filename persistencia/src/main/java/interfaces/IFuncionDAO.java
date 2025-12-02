/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Funcion;
import dto.FiltroDTO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public interface IFuncionDAO {

    Funcion insertar(Funcion funcion);

    Funcion actualizar(Funcion funcion);

    Funcion obtenerPorId(ObjectId id);

    List<Funcion> obtenerTodas(ObjectId peliculaId, FiltroDTO filtro);

}

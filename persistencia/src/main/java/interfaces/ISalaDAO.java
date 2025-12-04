/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Sala;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public interface ISalaDAO {

    Sala insertar(Sala sala);

    Sala actualizar(Sala sala);

    Sala obtenerPorId(ObjectId id);
    
    Sala obtenerPorNombre(String nombre);
}

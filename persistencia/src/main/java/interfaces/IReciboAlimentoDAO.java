/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.ReciboAlimento;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public interface IReciboAlimentoDAO {
    
    ReciboAlimento insertar(ReciboAlimento recibo);
    
    ReciboAlimento actualizar(ReciboAlimento recibo);
    
    ReciboAlimento buscarPorId(ObjectId id);
}

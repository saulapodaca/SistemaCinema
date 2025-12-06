/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Membresia;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public interface IMembresiaDAO {

    Membresia insertar(Membresia membresia);

    Membresia actualizar(Membresia membresia);

    Membresia obtenerPorId(ObjectId id);

    Membresia buscarPorCodigo(String codigo);
    
    boolean actualizarSaldo(String codigo,int saldoNuevo);
}

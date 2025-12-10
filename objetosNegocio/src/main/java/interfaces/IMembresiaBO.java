/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.MembresiaDTO;
import exceptions.NegocioException;

/**
 *
 * @author Héctor Javier Alonso Zaragoza - 00000252039
 * @author Saul Isaac Apodaca Baldenegro - 00000252020
 */
public interface IMembresiaBO {

    MembresiaDTO buscarMembresia(String codigoMembresia);
    
    boolean actualizarSaldo(String codigomembresia, int saldoNuevo);
    
    MembresiaDTO insertarMembresia(MembresiaDTO membresiaDTO) throws NegocioException;
    
    void insertarMock() throws NegocioException;
}

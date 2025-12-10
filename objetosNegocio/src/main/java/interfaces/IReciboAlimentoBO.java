/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.ReciboAlimentoDTO;
import dto.VentaAlimentoDTO;
import exceptions.ReciboAlimentoException;

/**
 *
 * @author saula
 */
public interface IReciboAlimentoBO {

    ReciboAlimentoDTO generarRecibo(VentaAlimentoDTO venta);

    ReciboAlimentoDTO actualizar(ReciboAlimentoDTO recibo) throws ReciboAlimentoException;
}

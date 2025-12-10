/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.ComboDTO;
import dto.DetallePrecioDTO;
import dto.VentaAlimentoDTO;
import exceptions.ComboException;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;

/**
 *
 * @author saula
 */
public interface IVentaAlimentoBO {
    
    VentaAlimentoDTO registrarVentaCombo(VentaAlimentoDTO dto) throws VentaNoEncontradaException, EmpleadoNoEncontradoException, SucursalNoExistenteException,ComboException;

    DetallePrecioDTO calcularPreciosCombo(ComboDTO combo);
}

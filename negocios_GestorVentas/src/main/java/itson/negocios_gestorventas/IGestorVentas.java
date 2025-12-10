/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestorventas;

import dto.AsientoDTO;
import dto.ComboDTO;
import dto.DetallePrecioDTO;
import dto.PromocionDTO;
import dto.VentaAlimentoDTO;
import dto.VentaDTO;
import exceptions.ComboException;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IGestorVentas {

    VentaDTO registrarVenta(VentaDTO venta) throws EmpleadoNoEncontradoException, Exception;
    
    VentaDTO obtenerVentaPorID(String id)throws VentaNoEncontradaException, FuncionNoEncontradaException, EmpleadoNoEncontradoException, SucursalNoExistenteException;
    
    DetallePrecioDTO calcularPrecios(List<AsientoDTO> asientos, PromocionDTO promoSeleccionada);
    
    VentaAlimentoDTO registrarVentaCombo(VentaAlimentoDTO venta) throws ComboException;
    
    DetallePrecioDTO calcularPreciosCombo (ComboDTO combo);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.AsientoDTO;
import dto.DetallePrecioDTO;
import dto.PromocionDTO;
import dto.VentaDTO;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IVentaBO {

    VentaDTO registrarVenta(VentaDTO venta) throws EmpleadoNoEncontradoException, Exception;

    VentaDTO obtenerVentaPorID(String id) throws VentaNoEncontradaException, FuncionNoEncontradaException, EmpleadoNoEncontradoException, SucursalNoExistenteException;

    DetallePrecioDTO calcularPrecios(List<AsientoDTO> asientos, PromocionDTO promo);

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_venderboleto.fachada;

import dto.AsientoDTO;
import dto.BoletoDTO;
import dto.DetallePrecioDTO;
import dto.EmpleadoDTO;
import dto.FiltroDTO;
import dto.FuncionDTO;
import dto.MembresiaDTO;
import dto.PeliculaDTO;
import dto.PromocionDTO;
import dto.VentaDTO;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.PeliculaNoExistenteException;
import exceptions.SalaNoExistenteException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import itson.negocios_generadorqr.exceptions.QRGeneradorException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IVentaBoletoFacade {

    BoletoDTO venderBoleto(VentaDTO venta) throws QRGeneradorException;

    void mandarBoletoCorreo(BoletoDTO boleto, String correo);

    List<PeliculaDTO> obtenerPeliculas(FiltroDTO filtro);

    List<FuncionDTO> listarFunciones(PeliculaDTO pelicula, FiltroDTO filtro) throws FuncionNoEncontradaException;
    
    List<AsientoDTO> obtenerAsientos(FuncionDTO funcion) throws FuncionNoEncontradaException, PeliculaNoExistenteException, SalaNoExistenteException;

    EmpleadoDTO obtenerEmpleadoPorId(String idEmpleado) throws EmpleadoNoEncontradoException, SucursalNoExistenteException;

    List<PromocionDTO> listarPromocionesMembresia(MembresiaDTO membresia);
    
    List<PromocionDTO> listarPromocionesGenerales();

    MembresiaDTO verificarMembresia(String codigo);
    
    VentaDTO obtenerVentaPorId(String idVenta) throws EmpleadoNoEncontradoException, FuncionNoEncontradaException, SucursalNoExistenteException, VentaNoEncontradaException;
    
    DetallePrecioDTO calcularPrecios(List<AsientoDTO> asientos, PromocionDTO promo);
    
    PromocionDTO validarCupon(String codigoCupon);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_venderboleto.fachada;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
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
import exceptions.BoletoNoExistenteException;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.PeliculaNoExistenteException;
import exceptions.PromocionNoExistenteException;
import exceptions.SalaNoExistenteException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import itson.negocios_generadorqr.exceptions.QRGeneradorException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Saul Isaac Apodaca Baldenegro - 00000252020
 * @author Alejandro Rodríguez Lugo - 00000251622
 */
public interface IVentaBoletoFacade {

    BoletoDTO venderBoleto(VentaDTO venta) throws QRGeneradorException;

    void mandarBoletoCorreo(String destino, String asunto, String mensajeHtml, byte[] jasper) throws Exception;

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

    VentaDTO actualizarVenta(VentaDTO ventaDTO) throws PromocionNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, IllegalArgumentException, SucursalNoExistenteException, VentaNoEncontradaException;

    VentaDTO reagendarBoleto(VentaDTO ventaAntigua, VentaDTO ventaNueva, List<AsientoDTO> asientosLiberar, List<AsientoDTO> asientosNuevos) throws FuncionNoEncontradaException, PromocionNoExistenteException, EmpleadoNoEncontradoException, IllegalArgumentException, VentaNoEncontradaException, SucursalNoExistenteException;

    String escanearQR(Webcam webcam);

    WebcamPanel getPanelCamara();

    BoletoDTO buscarBoletoPorId(String id) throws BoletoNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, SucursalNoExistenteException, VentaNoEncontradaException;

    byte[] generarPDFBoleto(BoletoDTO boleto) throws Exception;

    byte[] generarPDFPelicula(PeliculaDTO peliculaDTO, LocalDate fechaInicio, LocalDate fechaFin) throws Exception;

    BoletoDTO actualizar(BoletoDTO boleto) throws BoletoNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, IllegalArgumentException, SucursalNoExistenteException, VentaNoEncontradaException;
}

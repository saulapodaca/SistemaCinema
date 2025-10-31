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
import java.util.Date;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IVentaBoletoFacade {

    BoletoDTO venderBoleto(VentaDTO venta);

    void mandarBoletoCorreo(BoletoDTO boleto, String correo);

    List<PeliculaDTO> obtenerPeliculas(FiltroDTO filtro);

    List<FuncionDTO> listarFunciones(PeliculaDTO pelicula, Date fecha);
    
    List<AsientoDTO> obtenerAsientos(FuncionDTO funcion);

    EmpleadoDTO obtenerEmpleadoSesion(String idEmpleado);

    List<PromocionDTO> listarPromocionesMembresia(MembresiaDTO membresia);
    
    List<PromocionDTO> listarPromocionesGenerales();

    MembresiaDTO verificarMembresia(String codigo);
    
    VentaDTO obtenerVentaPorId(String idVenta);
    
    DetallePrecioDTO calcularPrecios(List<AsientoDTO> asientos, PromocionDTO promo); 
    
    PromocionDTO obtenerPromocionPorNombre(String nombrePromo);
    
    PromocionDTO validarCupon(String codigoCupon);
}

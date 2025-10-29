/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_venderboleto.fachada;

import dto.AsientoDTO;
import dto.BoletoDTO;
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

    BoletoDTO venderBoleto(FuncionDTO funcion,
            List<AsientoDTO> asientosSeleccionados,
            EmpleadoDTO empleado,
            MembresiaDTO membresia,
            PromocionDTO promoSeleccionada);

    void mandarBoletoCorreo(BoletoDTO boleto, String correo);

    List<PeliculaDTO> obtenerPeliculas(FiltroDTO filtro);

    List<FuncionDTO> listarFunciones(PeliculaDTO pelicula, Date fecha);
    
    List<AsientoDTO> obtenerAsientos(FuncionDTO funcion);

    EmpleadoDTO obtenerEmpleadoSesion(String idEmpleado);

    List<PromocionDTO> listarPromocionesMembresia(MembresiaDTO membresia);

    MembresiaDTO verificarMembresia(String codigo);
    
    VentaDTO obtenerVentaPorId(String idVenta);
}

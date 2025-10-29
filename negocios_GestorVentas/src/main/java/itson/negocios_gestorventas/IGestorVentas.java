/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestorventas;

import dto.AsientoDTO;
import dto.EmpleadoDTO;
import dto.FuncionDTO;
import dto.MembresiaDTO;
import dto.PromocionDTO;
import dto.VentaDTO;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IGestorVentas {

    VentaDTO registrarVenta(FuncionDTO funcion,
            List<AsientoDTO> asientos,
            EmpleadoDTO empleado,
            MembresiaDTO membresia,
            PromocionDTO promoSeleccionada);
    
    VentaDTO obtenerVentaPorID(String id);
}

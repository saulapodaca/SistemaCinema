/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestorventas;

import dto.AsientoDTO;
import dto.DetallePrecioDTO;
import dto.PromocionDTO;
import dto.VentaDTO;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IGestorVentas {

    VentaDTO registrarVenta(VentaDTO venta);
    
    VentaDTO obtenerVentaPorID(String id);
    
    DetallePrecioDTO calcularPrecios(List<AsientoDTO> asientos, PromocionDTO promoSeleccionada);
}

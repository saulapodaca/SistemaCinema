/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_vendercombos.fachada;

import dto.ComboDTO;
import dto.DetallePrecioDTO;
import dto.DulceDTO;
import dto.FiltroDTO;
import dto.ReciboAlimentoDTO;
import dto.SaborBebidaDTO;
import dto.SaborPalomitasDTO;
import dto.TamanoPalomitasDTO;
import dto.VentaAlimentoDTO;
import exceptions.ComboException;
import itson.negocios_vendercombos.exceptions.VentaComboException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IVenderCombosFacade {
 
    List<ComboDTO> obtenerCombos(FiltroDTO filtro) throws ComboException;
    
    List<TamanoPalomitasDTO> obtenerTamanosPalomitas();
    
    List<SaborPalomitasDTO> obtenerSaboresPalomitas();
    
    List<SaborBebidaDTO> obtenerSaboresBebidas();
    
    List<DulceDTO> obtenerDulces();
    
    DetallePrecioDTO calcularPrecios(ComboDTO combo);
    
    ReciboAlimentoDTO registrarVenta(VentaAlimentoDTO venta) throws VentaComboException;
    
    void mandarCorreo(ReciboAlimentoDTO recibo, String correo);
}

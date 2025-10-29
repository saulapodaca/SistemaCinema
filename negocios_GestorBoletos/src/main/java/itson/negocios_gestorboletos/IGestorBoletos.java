/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestorboletos;

import dto.BoletoDTO;
import dto.VentaDTO;

/**
 *
 * @author saula
 */
public interface IGestorBoletos {
    BoletoDTO generarBoleto(VentaDTO venta);
    BoletoDTO buscarBoletoPorId(String id);
}

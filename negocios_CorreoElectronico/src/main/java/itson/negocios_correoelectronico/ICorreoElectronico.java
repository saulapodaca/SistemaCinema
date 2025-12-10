/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_correoelectronico;

import dto.BoletoDTO;
import dto.ReciboAlimentoDTO;

/**
 *
 * @author saula
 */
public interface ICorreoElectronico {
    
    void enviarBoleto(String correoDestino, BoletoDTO boleto);
    
    void enviarRecibo(String correoDestino, ReciboAlimentoDTO recibo);
}

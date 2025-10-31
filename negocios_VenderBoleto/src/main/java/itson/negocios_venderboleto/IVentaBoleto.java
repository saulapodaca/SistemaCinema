package itson.negocios_venderboleto;

import dto.BoletoDTO;
import dto.VentaDTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author saula
 */
public interface IVentaBoleto {

    BoletoDTO venderBoleto(VentaDTO venta);

    void mandarBoletoCorreo(BoletoDTO boleto, String correo);
}

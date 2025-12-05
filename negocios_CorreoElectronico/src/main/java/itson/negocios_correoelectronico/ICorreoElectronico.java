/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_correoelectronico;

import dto.BoletoDTO;

/**
 * Interfaz que define la operación del envío de boleto a correo.
 *
 * @author Saul Isaac Apodaca Baldenegro - 00000252020
 * @author Alejandor Rodríguez Lugo - 00000251622
 */
public interface ICorreoElectronico {

    void enviarBoleto(String destino, String asunto, String mensajeHtml, byte[] pdfBytes) throws Exception;
}

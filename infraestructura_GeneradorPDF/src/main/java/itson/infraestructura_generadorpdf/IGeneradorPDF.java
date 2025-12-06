/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.infraestructura_generadorpdf;

import dto.BoletoDTO;

/**
 *
 * @author PC
 */
public interface IGeneradorPDF {

    byte[] generarPDFBoleto(BoletoDTO boleto) throws Exception;
}

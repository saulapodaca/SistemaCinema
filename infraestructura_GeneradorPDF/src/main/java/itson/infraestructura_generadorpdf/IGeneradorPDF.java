/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.infraestructura_generadorpdf;

/**
 *
 * @author PC
 */
public interface IGeneradorPDF {

    byte[] generarPDFBoleto(String idBoleto) throws Exception;
}

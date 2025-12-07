/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.infraestructura_generadorpdf;

import dto.BoletoDTO;
import dto.PeliculaDTO;
import dto.VentaDTO;
import java.time.LocalDate;

/**
 *
 * @author Alejandro Rodríguez Lugo - 00000251622
 */
public interface IGeneradorPDF {

    byte[] generarPDFBoleto(BoletoDTO boleto) throws Exception;

    byte[] generarPDFPelicula(PeliculaDTO peliculaDTO, LocalDate fechaInicio, LocalDate fechaFin) throws Exception;

}

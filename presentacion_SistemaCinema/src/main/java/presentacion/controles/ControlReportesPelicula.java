/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import dto.PeliculaDTO;
import itson.negocios_venderboleto.fabrica.GestorFactory;
import itson.negocios_venderboleto.fachada.IVentaBoletoFacade;
import itson.negocios_venderboleto.fachada.VentaBoletoFacade;
import java.time.LocalDate;

/**
 *
 * @author Alejandro Rodríguez Lugo - 00000251622
 */
public class ControlReportesPelicula {

    private static ControlReportesPelicula instance;

    private final IVentaBoletoFacade facade;

    private ControlReportesPelicula() {
        this.facade = new VentaBoletoFacade(new GestorFactory());
    }

    public static ControlReportesPelicula getInstance() {
        if (instance == null) {
            instance = new ControlReportesPelicula();
        }
        return instance;
    }

//    public byte[] generarPDFPelicula(PeliculaDTO pelicula) throws Exception {
//        return facade.generarPDFPelicula(pelicula);
//    }
    
    public byte[] generarPDFPelicula(PeliculaDTO peliculaDTO, LocalDate fechaInicio, LocalDate fechaFin) throws Exception{
        return facade.generarPDFPelicula(peliculaDTO, fechaInicio, fechaFin);
    }
}

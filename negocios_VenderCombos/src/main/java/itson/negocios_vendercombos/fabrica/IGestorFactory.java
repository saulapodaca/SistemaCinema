/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_vendercombos.fabrica;

import itson.negocios_correoelectronico.ICorreoElectronico;
import itson.negocios_generadorqr.IGeneradorQR;
import itson.negocios_gestorcombos.IGestorCombos;
import itson.negocios_gestorempleados.IGestorEmpleados;
import itson.negocios_gestorreciboscombos.IGestorRecibosCombos;
import itson.negocios_gestorventas.IGestorVentas;

/**
 *
 * @author saula
 */
public interface IGestorFactory {
    
    IGestorEmpleados crearGestorEmpleados();
    
    IGeneradorQR crearGeneradorQR();

    ICorreoElectronico crearCorreoElectronico();
    
    IGestorVentas crearGestorVentas();
    
    IGestorRecibosCombos crearGestorRecibosAlimentos();
   
    IGestorCombos crearGestorCombos();
}

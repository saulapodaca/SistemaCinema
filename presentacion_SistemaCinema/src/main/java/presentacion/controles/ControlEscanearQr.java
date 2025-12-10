/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import com.github.sarxos.webcam.Webcam;
import itson.negocios_venderboleto.fabrica.GestorFactory;
import itson.negocios_venderboleto.fachada.IVentaBoletoFacade;
import itson.negocios_venderboleto.fachada.VentaBoletoFacade;

/**
 *
 * @author Elite
 */
public class ControlEscanearQr {
    
    private static ControlEscanearQr instance;
    
    private final IVentaBoletoFacade facade;

    public ControlEscanearQr() {
        this.facade = new VentaBoletoFacade(new GestorFactory());
    }
    
    public static ControlEscanearQr getInstance() {
        if (instance == null) {
            instance = new ControlEscanearQr();
        }
        return instance;
    }
    
    
     public String escanearQR(Webcam webcam) {
        return facade.escanearQR(webcam);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import dto.BoletoDTO;
import exceptions.BoletoNoExistenteException;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
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
     
      public WebcamPanel getPanelCamara() {
        return facade.getPanelCamara();
    }
      
    public BoletoDTO buscarBoletoPorId(String id) throws BoletoNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, SucursalNoExistenteException, VentaNoEncontradaException {
        return facade.buscarBoletoPorId(id);
    }
    
    public BoletoDTO actualizar(BoletoDTO boleto) throws BoletoNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, IllegalArgumentException, SucursalNoExistenteException, VentaNoEncontradaException {
        return facade.actualizar(boleto);
    }
     
     
     
}

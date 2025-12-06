/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.controles;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import dto.AsientoDTO;
import dto.BoletoDTO;
import dto.VentaDTO;
import exceptions.*;
import itson.negocios_venderboleto.fabrica.*;
import itson.negocios_venderboleto.fachada.*;
import java.util.List;

/**
 *
 * @author Alejandor Rodríguez Lugo - 00000251622
 */
public class ControlReagendarBoleto {

    private static ControlReagendarBoleto instance;

    private final IVentaBoletoFacade facade;

    private ControlReagendarBoleto() {
        this.facade = new VentaBoletoFacade(new GestorFactory());
    }

    public static ControlReagendarBoleto getInstance() {
        if (instance == null) {
            instance = new ControlReagendarBoleto();
        }
        return instance;
    }

    public BoletoDTO buscarBoletoPorId(String id) throws BoletoNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, SucursalNoExistenteException, VentaNoEncontradaException {
        return facade.buscarBoletoPorId(id);
    }

    public VentaDTO reagendarBoleto(VentaDTO ventaAntigua, VentaDTO ventaNueva, List<AsientoDTO> asientosLiberar, List<AsientoDTO> asientosNuevos) throws FuncionNoEncontradaException, PromocionNoExistenteException, EmpleadoNoEncontradoException, IllegalArgumentException, VentaNoEncontradaException, SucursalNoExistenteException {
        return facade.reagendarBoleto(ventaAntigua, ventaNueva, asientosLiberar, asientosNuevos);
    }

    public String escanearQR(Webcam webcam) {
        return facade.escanearQR(webcam);
    }

    public WebcamPanel getPanelCamara() {
        return facade.getPanelCamara();
    }
}

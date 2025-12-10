package presentacion.controles;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.ComboDTO;
import dto.DetallePrecioDTO;
import dto.DulceDTO;
import dto.FiltroDTO;
import dto.ReciboAlimentoDTO;
import dto.SaborBebidaDTO;
import dto.SaborPalomitasDTO;
import dto.TamanoPalomitasDTO;
import dto.VentaAlimentoDTO;
import exceptions.ComboException;
import itson.negocios_vendercombos.exceptions.VentaComboException;
import itson.negocios_vendercombos.fabrica.GestorFactory;
import itson.negocios_vendercombos.fachada.IVenderCombosFacade;
import itson.negocios_vendercombos.fachada.VenderCombosFacade;
import java.util.List;


public class ControlVentaCombo {

    private static ControlVentaCombo instance;
    private final IVenderCombosFacade facade;

    private ControlVentaCombo() {
        this.facade = new VenderCombosFacade(new GestorFactory()); 
    }
    
    public static synchronized ControlVentaCombo getInstance() {
        if (instance == null) {
            instance = new ControlVentaCombo();
        }
        return instance;
    }
    
    public List<ComboDTO> obtenerCombos(FiltroDTO filtro) throws ComboException{
        return facade.obtenerCombos(filtro);
    }
    
    public List<TamanoPalomitasDTO> obtenerTamanosPalomitas(){
        return facade.obtenerTamanosPalomitas();
    }
    
    public List<SaborPalomitasDTO> obtenerSaboresPalomitas(){
        return facade.obtenerSaboresPalomitas();
    }
    
    public List<SaborBebidaDTO> obtenerSaboresBebidas(){
        return facade.obtenerSaboresBebidas();
    }
    
    public List<DulceDTO> obtenerDulces(){
        return facade.obtenerDulces();
    }
    
    public DetallePrecioDTO calcularPrecios(ComboDTO combo){
        return facade.calcularPrecios(combo);
    }
    
    public ReciboAlimentoDTO registrarVenta(VentaAlimentoDTO venta) throws VentaComboException{
        return facade.registrarVenta(venta);
    }
    
    public void mandarCorreo(ReciboAlimentoDTO recibo, String correo){
        facade.mandarCorreo(recibo, correo);
    }
}

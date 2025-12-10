package itson.negocios_vendercombos.fachada;

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
import itson.negocios_gestorcombos.IGestorCombos;
import itson.negocios_gestorventas.IGestorVentas;
import itson.negocios_vendercombos.IVentaCombo;
import itson.negocios_vendercombos.VentaCombo;
import itson.negocios_vendercombos.exceptions.VentaComboException;
import itson.negocios_vendercombos.fabrica.GestorFactory;
import java.util.List;

public class VenderCombosFacade implements IVenderCombosFacade {

    private final IVentaCombo ventaCombo;
    private final IGestorCombos gestorCombos;
    private final IGestorVentas gestorVentas;

    public VenderCombosFacade(GestorFactory factory) {
        this.gestorCombos = factory.crearGestorCombos();
        this.gestorVentas = factory.crearGestorVentas();

        this.ventaCombo = new VentaCombo(
                gestorVentas,
                factory.crearGestorRecibosAlimentos(),
                factory.crearGeneradorQR(),
                factory.crearCorreoElectronico()
        );
    }

    @Override
    public List<ComboDTO> obtenerCombos(FiltroDTO filtro) throws ComboException{
       return gestorCombos.obtenerCombos(filtro);
    }

    @Override
    public List<TamanoPalomitasDTO> obtenerTamanosPalomitas() {
        return gestorCombos.obtenerTamanosPalomitas();
    }

    @Override
    public List<SaborPalomitasDTO> obtenerSaboresPalomitas() {
        return gestorCombos.obtenerSaboresPalomitas();        
    }

    @Override
    public List<SaborBebidaDTO> obtenerSaboresBebidas() {
        return gestorCombos.obtenerSaboresBebidas();
    }

    @Override
    public List<DulceDTO> obtenerDulces() {
        return gestorCombos.obtenerDulces();
    }

    @Override
    public DetallePrecioDTO calcularPrecios(ComboDTO combo) {
        return gestorVentas.calcularPreciosCombo(combo);
    }

    @Override
    public ReciboAlimentoDTO registrarVenta(VentaAlimentoDTO venta) throws VentaComboException{
        return ventaCombo.venderCombo(venta);
    }

    @Override
    public void mandarCorreo(ReciboAlimentoDTO recibo, String correo) {
        ventaCombo.mandarBoletoCorreoAlimento(recibo, correo);
    }

}

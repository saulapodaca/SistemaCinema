package itson.negocios_gestorventas;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import bos.VentaAlimentoBO;
import bos.VentaBO;
import dto.AsientoDTO;
import dto.ComboDTO;
import dto.DetallePrecioDTO;
import dto.PromocionDTO;
import dto.VentaAlimentoDTO;
import dto.VentaDTO;
import exceptions.ComboException;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import interfaces.IVentaAlimentoBO;
import interfaces.IVentaBO;
import java.util.List;

public class GestorVentas implements IGestorVentas {

    private static IVentaBO ventaBO = VentaBO.getInstancia();
    private static IVentaAlimentoBO ventaAlimentoBO = VentaAlimentoBO.getInstancia();

    @Override
    public VentaDTO registrarVenta(VentaDTO venta) throws EmpleadoNoEncontradoException, Exception{
        return ventaBO.registrarVenta(venta);
    }

    @Override
    public VentaDTO obtenerVentaPorID(String id) throws VentaNoEncontradaException, FuncionNoEncontradaException, EmpleadoNoEncontradoException, SucursalNoExistenteException{
        return ventaBO.obtenerVentaPorID(id);
    }
    
    @Override
    public DetallePrecioDTO calcularPrecios(List<AsientoDTO> asientos, PromocionDTO promo){
        return ventaBO.calcularPrecios(asientos, promo);
    }

    @Override
    public VentaAlimentoDTO registrarVentaCombo(VentaAlimentoDTO venta) throws ComboException{
        try{
            return ventaAlimentoBO.registrarVentaCombo(venta);
        } catch (ComboException | EmpleadoNoEncontradoException | SucursalNoExistenteException | VentaNoEncontradaException ex){
            throw new ComboException(ex.getMessage());
        }
    }

    @Override
    public DetallePrecioDTO calcularPreciosCombo(ComboDTO combo) {
        return ventaAlimentoBO.calcularPreciosCombo(combo);
    }
}

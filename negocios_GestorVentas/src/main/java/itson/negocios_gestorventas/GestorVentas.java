package itson.negocios_gestorventas;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import bos.VentaBO;
import dto.AsientoDTO;
import dto.DetallePrecioDTO;
import dto.PromocionDTO;
import dto.VentaDTO;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import interfaces.IVentaBO;
import java.util.List;

public class GestorVentas implements IGestorVentas {

    private static IVentaBO ventaBO = VentaBO.getInstancia();

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
}

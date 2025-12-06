package itson.negocios_venderboleto;

import dto.AsientoDTO;
import dto.BoletoDTO;
import dto.VentaDTO;
import itson.negocios_generadorqr.exceptions.QRGeneradorException;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.PromocionNoExistenteException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import itson.negocios_generadorqr.exceptions.QRGeneradorException;
import java.util.List;

public interface IVentaBoleto {

    public BoletoDTO venderBoleto(VentaDTO venta) throws QRGeneradorException, Exception;

    void mandarBoletoCorreo(String destino, String asunto, String mensajeHtml, byte[] jasper) throws Exception;

    VentaDTO reagendarBoleto(VentaDTO ventaAntigua, VentaDTO ventaNueva, List<AsientoDTO> asientosLiberar, List<AsientoDTO> asientosNuevos) throws FuncionNoEncontradaException, PromocionNoExistenteException, EmpleadoNoEncontradoException, IllegalArgumentException, VentaNoEncontradaException, SucursalNoExistenteException;

}

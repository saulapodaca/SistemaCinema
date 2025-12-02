package interfaces;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.BoletoDTO;
import dto.VentaDTO;
import exceptions.BoletoNoExistenteException;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;

public interface IBoletoBO {

    BoletoDTO generarBoleto(VentaDTO venta);

    BoletoDTO buscarBoletoPorId(String id) throws BoletoNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, SucursalNoExistenteException, VentaNoEncontradaException;

    BoletoDTO actualizar(BoletoDTO boletoDTO) throws BoletoNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, IllegalArgumentException, SucursalNoExistenteException, VentaNoEncontradaException;

}

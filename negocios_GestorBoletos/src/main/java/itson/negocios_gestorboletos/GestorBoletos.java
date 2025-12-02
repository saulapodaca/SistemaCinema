package itson.negocios_gestorboletos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import bos.BoletoBO;
import dto.BoletoDTO;
import dto.VentaDTO;
import exceptions.BoletoNoExistenteException;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import interfaces.IBoletoBO;

public class GestorBoletos implements IGestorBoletos {

    private final IBoletoBO boletoBO = BoletoBO.getInstancia();

    @Override
    public BoletoDTO generarBoleto(VentaDTO venta) {
        return boletoBO.generarBoleto(venta);
    }

    @Override
    public BoletoDTO buscarBoletoPorId(String id) throws BoletoNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, SucursalNoExistenteException, VentaNoEncontradaException {
        return boletoBO.buscarBoletoPorId(id);
    }

    @Override
    public BoletoDTO actualizar(BoletoDTO boleto) throws BoletoNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, IllegalArgumentException, SucursalNoExistenteException, VentaNoEncontradaException{
        return boletoBO.actualizar(boleto);
    }

}

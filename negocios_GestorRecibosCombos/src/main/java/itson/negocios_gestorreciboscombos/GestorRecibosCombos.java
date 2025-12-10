package itson.negocios_gestorreciboscombos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import bos.ReciboAlimentoBO;
import dto.ReciboAlimentoDTO;
import dto.VentaAlimentoDTO;
import exceptions.ReciboAlimentoException;
import interfaces.IReciboAlimentoBO;


public class GestorRecibosCombos implements IGestorRecibosCombos{

    private final IReciboAlimentoBO reciboAlimentoBO;

    public GestorRecibosCombos() {
        this.reciboAlimentoBO = ReciboAlimentoBO.getInstancia();
    }
    
    @Override
    public ReciboAlimentoDTO generarRecibo(VentaAlimentoDTO venta) {
        return reciboAlimentoBO.generarRecibo(venta);
    }

    @Override
    public ReciboAlimentoDTO actualizar(ReciboAlimentoDTO recibo) throws ReciboAlimentoException{
        return reciboAlimentoBO.actualizar(recibo);
    }

}

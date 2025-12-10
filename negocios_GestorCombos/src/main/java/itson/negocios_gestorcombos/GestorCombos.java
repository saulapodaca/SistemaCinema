package itson.negocios_gestorcombos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import bos.ComboBO;
import bos.DulceBO;
import bos.SaborBebidaBO;
import bos.SaborPalomitasBO;
import bos.TamanoPalomitasBO;
import dto.ComboDTO;
import dto.DulceDTO;
import dto.FiltroDTO;
import dto.SaborBebidaDTO;
import dto.SaborPalomitasDTO;
import dto.TamanoPalomitasDTO;
import exceptions.ComboException;
import interfaces.IComboBO;
import interfaces.IDulceBO;
import interfaces.ISaborBebidaBO;
import interfaces.ISaborPalomitasBO;
import interfaces.ITamanoPalomitasBO;
import java.util.List;


public class GestorCombos implements IGestorCombos{

    private final IComboBO comboBO;
    private final IDulceBO dulceBO;
    private final ISaborBebidaBO saborBebidaBO;
    private final ITamanoPalomitasBO tamanoPalomitasBO;
    private final ISaborPalomitasBO saborPalomitasBO;

    public GestorCombos() {
        this.comboBO = ComboBO.getInstancia();
        this.dulceBO = DulceBO.getInstancia();
        this.saborBebidaBO = SaborBebidaBO.getInstancia();
        this.tamanoPalomitasBO = TamanoPalomitasBO.getInstancia();
        this.saborPalomitasBO = SaborPalomitasBO.getInstancia();
    }
    
    
    
    @Override
    public List<ComboDTO> obtenerCombos(FiltroDTO filtro) throws ComboException{
        return comboBO.obtenerCombos(filtro);
    }

    @Override
    public List<TamanoPalomitasDTO> obtenerTamanosPalomitas() {
        return tamanoPalomitasBO.obtenerTamanosPalomitas();
    }

    @Override
    public List<SaborPalomitasDTO> obtenerSaboresPalomitas() {
        return saborPalomitasBO.obtenerSaboresPalomitas();
    }

    @Override
    public List<SaborBebidaDTO> obtenerSaboresBebidas() {
        return saborBebidaBO.obtenerSaboresBebidas();
    }

    @Override
    public List<DulceDTO> obtenerDulces() {
        return dulceBO.obtenerDulces();
    }

}

package itson.negocios_gestorfunciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import bos.FuncionBO;
import dto.AsientoDTO;
import dto.FiltroDTO;
import dto.FuncionDTO;
import dto.PeliculaDTO;
import exceptions.FuncionNoEncontradaException;
import exceptions.PeliculaNoExistenteException;
import exceptions.SalaNoExistenteException;
import interfaces.IFuncionBO;
import java.util.List;

public class GestorFunciones implements IGestorFunciones {

    private final IFuncionBO funcionBO = FuncionBO.getInstancia();
    
    @Override
    public List<FuncionDTO> obtenerFuncionesPorPelícula(PeliculaDTO pelicula, FiltroDTO filtro) throws FuncionNoEncontradaException{
        return funcionBO.obtenerFuncionesPorPelicula(pelicula, filtro);
    }
    
    @Override
    public List<AsientoDTO> obtenerAsientos(FuncionDTO funcion) throws FuncionNoEncontradaException, PeliculaNoExistenteException, SalaNoExistenteException{
        return funcionBO.obtenerAsientos(funcion.getId());
    }
    
    @Override
    public void ocuparAsientos(FuncionDTO funcion, List<AsientoDTO> asientos) throws FuncionNoEncontradaException{
        funcionBO.ocuparAsientos(funcion.getId(), asientos);
    }
    
    @Override
    public void liberarAsientos(FuncionDTO funcion, List<AsientoDTO> asientos) throws FuncionNoEncontradaException{
        funcionBO.liberarAsientos(funcion.getId(), asientos);
    }

}

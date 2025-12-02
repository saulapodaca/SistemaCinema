package interfaces;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import dto.FiltroDTO;
import dto.PeliculaDTO;
import exceptions.PeliculaNoExistenteException;
import java.util.List;

public interface IPeliculaBO {

    List<PeliculaDTO> obtenerPeliculas(FiltroDTO filtro);
    
    PeliculaDTO obtenerPorId(String id) throws PeliculaNoExistenteException;
}

package interfaces;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import dto.FiltroDTO;
import dto.PeliculaDTO;
import exceptions.NegocioException;
import exceptions.PeliculaNoExistenteException;
import java.util.List;

public interface IPeliculaBO {
    
    PeliculaDTO insertarPelicula(PeliculaDTO peliculaDTO)  throws NegocioException;

    List<PeliculaDTO> obtenerPeliculas(FiltroDTO filtro);
    
    PeliculaDTO obtenerPorId(String id) throws PeliculaNoExistenteException;
    
    PeliculaDTO obtenerPorTitulo(String nombre) throws NegocioException;
}

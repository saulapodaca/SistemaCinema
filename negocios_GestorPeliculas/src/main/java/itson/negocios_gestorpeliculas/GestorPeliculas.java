package itson.negocios_gestorpeliculas;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import bos.PeliculaBO;
import dto.FiltroDTO;
import dto.PeliculaDTO;
import interfaces.IPeliculaBO;
import java.util.List;


public class GestorPeliculas implements IGestorPeliculas{
    
    private final IPeliculaBO peliculaBo= PeliculaBO.getInstancia();
    
    @Override
    public List<PeliculaDTO> obtenerPeliculas(FiltroDTO filtro) {
        return peliculaBo.obtenerPeliculas(filtro);
    }

}

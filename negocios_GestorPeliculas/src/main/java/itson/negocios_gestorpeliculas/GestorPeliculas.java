package itson.negocios_gestorpeliculas;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.FiltroDTO;
import dto.PeliculaDTO;
import java.util.Arrays;
import java.util.List;


public class GestorPeliculas implements IGestorPeliculas{

    @Override
    public List<PeliculaDTO> listarCartelera(FiltroDTO filtro) {
                return Arrays.asList(
                new PeliculaDTO("BOL001","Spiderman", "/blackphone.png", "200min", "Doblada"),
                new PeliculaDTO("BOL002","Batman", "/spiderman.png", "180min", "Español"),
                new PeliculaDTO("BOL003","Ironman", "/spiderman.png", "250min", "Subtitulada"),
                new PeliculaDTO("BOL004","Ironman", "/spiderman.png", "250min", "Subtitulada")
        );
    }

}

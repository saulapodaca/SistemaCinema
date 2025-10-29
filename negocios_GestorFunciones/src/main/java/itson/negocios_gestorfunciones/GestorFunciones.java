package itson.negocios_gestorfunciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.FuncionDTO;
import dto.PeliculaDTO;
import dto.SalaDTO;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class GestorFunciones implements IGestorFunciones {

    @Override
    public List<FuncionDTO> obtenerFuncionesPorPelícula(PeliculaDTO pelicula, Date fecha) {
        return Arrays.asList(
                new FuncionDTO(
                        new SalaDTO("Sala 1", 7, 10),
                        pelicula,
                        "12:30",
                        "Sala Tradicional",
                        new Date() // fecha de hoy
                ),
                new FuncionDTO(
                        new SalaDTO("Sala 2", 5, 5),
                        pelicula,
                        "10:00",
                        "Sala 3D",
                        new Date()
                ),
                new FuncionDTO(
                        new SalaDTO("Sala 3", 7, 7),
                        pelicula,
                        "15:00",
                        "Sala Tradicional",
                        new Date()
                ),
                new FuncionDTO(
                        new SalaDTO("Sala 1", 5, 5),
                        pelicula,
                        "18:15",
                        "Sala 3D",
                        new Date()
                ));
    }

}

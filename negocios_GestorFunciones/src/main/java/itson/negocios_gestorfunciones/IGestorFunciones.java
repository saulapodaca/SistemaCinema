/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestorfunciones;

import dto.FuncionDTO;
import dto.PeliculaDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IGestorFunciones {
    List<FuncionDTO> obtenerFuncionesPorPelícula(PeliculaDTO pelicula, Date fecha);
}

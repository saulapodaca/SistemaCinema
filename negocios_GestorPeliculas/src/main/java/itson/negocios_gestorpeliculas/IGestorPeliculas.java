/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestorpeliculas;

import dto.FiltroDTO;
import dto.PeliculaDTO;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IGestorPeliculas {
    List<PeliculaDTO> obtenerPeliculas(FiltroDTO filtro);
    
}

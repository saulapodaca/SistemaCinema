/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestorfunciones;

import dto.AsientoDTO;
import dto.FiltroDTO;
import dto.FuncionDTO;
import dto.PeliculaDTO;
import exceptions.FuncionNoEncontradaException;
import exceptions.PeliculaNoExistenteException;
import exceptions.SalaNoExistenteException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IGestorFunciones {

    List<FuncionDTO> obtenerFuncionesPorPelícula(PeliculaDTO pelicula, FiltroDTO filtro) throws FuncionNoEncontradaException;

    List<AsientoDTO> obtenerAsientos(FuncionDTO funcion) throws FuncionNoEncontradaException, PeliculaNoExistenteException, SalaNoExistenteException;

    void ocuparAsientos(FuncionDTO funcion, List<AsientoDTO> asientos) throws FuncionNoEncontradaException;

    void liberarAsientos(FuncionDTO funcion, List<AsientoDTO> asientos) throws FuncionNoEncontradaException;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dto.AsientoDTO;
import dto.FiltroDTO;
import dto.FuncionDTO;
import dto.PeliculaDTO;
import exceptions.FuncionNoEncontradaException;
import exceptions.NegocioException;
import exceptions.PeliculaNoExistenteException;
import exceptions.SalaNoExistenteException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IFuncionBO {
    
    FuncionDTO insertarFuncion(FuncionDTO funcionDTO)  throws NegocioException, SalaNoExistenteException, PeliculaNoExistenteException ;

    List<FuncionDTO> obtenerFuncionesPorPelicula(PeliculaDTO peliculaDTO, FiltroDTO filtro) throws FuncionNoEncontradaException;

    FuncionDTO obtenerPorId(String id) throws FuncionNoEncontradaException;
    
    FuncionDTO actualizar(FuncionDTO dto) throws FuncionNoEncontradaException;

    List<AsientoDTO> obtenerAsientos(String funcionId) throws FuncionNoEncontradaException, PeliculaNoExistenteException, SalaNoExistenteException;

    FuncionDTO ocuparAsientos(String funcionId, List<AsientoDTO> seleccionados) throws FuncionNoEncontradaException;

    FuncionDTO liberarAsientos(String funcionId, List<AsientoDTO> seleccionados) throws FuncionNoEncontradaException;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_gestorasientos;

import dto.AsientoDTO;
import dto.FuncionDTO;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IGestorAsientos {
    List<AsientoDTO> obtenerAsientos(FuncionDTO funcion);
    void ocuparAsientos(FuncionDTO funcion, List<AsientoDTO> asientos);
    void liberarAsientos(FuncionDTO funcion, List<AsientoDTO> asientos);
}

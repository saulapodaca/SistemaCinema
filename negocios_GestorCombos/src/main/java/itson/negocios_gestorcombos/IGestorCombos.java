package itson.negocios_gestorcombos;

import dto.ComboDTO;
import dto.DulceDTO;
import dto.FiltroDTO;
import dto.SaborBebidaDTO;
import dto.SaborPalomitasDTO;
import dto.TamanoPalomitasDTO;
import exceptions.ComboException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IGestorCombos {

    List<ComboDTO> obtenerCombos(FiltroDTO filtro) throws ComboException;

    List<TamanoPalomitasDTO> obtenerTamanosPalomitas();

    List<SaborPalomitasDTO> obtenerSaboresPalomitas();

    List<SaborBebidaDTO> obtenerSaboresBebidas();

    List<DulceDTO> obtenerDulces();
}

package itson.negocios_gestorasientos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.AsientoDTO;
import dto.FuncionDTO;
import java.util.List;


public class GestorAsientos implements IGestorAsientos{

    @Override
    public List<AsientoDTO> obtenerAsientos(FuncionDTO funcion) {
        return funcion.getAsientos();
    }

    @Override
    public void ocuparAsientos(FuncionDTO funcion, List<AsientoDTO> asientos) {
         for (AsientoDTO asiento : funcion.getAsientos()) {
            for (AsientoDTO seleccionado : asientos) {
                if (asiento.getFila() == seleccionado.getFila() &&
                    asiento.getColumna() == seleccionado.getColumna()) {
                    asiento.setEstado(AsientoDTO.Estado.OCUPADO);
                }
            }
        }
    }

    @Override
    public void liberarAsientos(FuncionDTO funcion, List<AsientoDTO> asientos) {
                for (AsientoDTO asiento : funcion.getAsientos()) {
            for (AsientoDTO seleccionado : asientos) {
                if (asiento.getFila() == seleccionado.getFila() &&
                    asiento.getColumna() == seleccionado.getColumna()) {
                    asiento.setEstado(AsientoDTO.Estado.DISPONIBLE);
                }
            }
        }
    }

}

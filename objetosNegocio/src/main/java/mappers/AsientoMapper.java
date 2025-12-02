package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.Asiento;
import dto.AsientoDTO;

public class AsientoMapper {

    public AsientoDTO toDTO(Asiento entidad) {
        AsientoDTO dto = new AsientoDTO();
        
        dto.setFila(entidad.getFila());
        dto.setColumna(entidad.getColumna());
        dto.setEstado(entidad.getEstadoAsiento());
        dto.setNombre(entidad.getNombre());

        return dto;
    }

    public Asiento toEntity(AsientoDTO dto) {
        Asiento entidad = new Asiento();

        entidad.setFila(dto.getFila());
        entidad.setColumna(dto.getColumna());
        entidad.setEstadoAsiento(dto.getEstado());
        entidad.setNombre(dto.getNombre());

        return entidad;
    }

}

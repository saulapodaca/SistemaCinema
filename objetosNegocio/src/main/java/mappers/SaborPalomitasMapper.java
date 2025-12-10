package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.SaborPalomitas;
import dto.SaborPalomitasDTO;
import org.bson.types.ObjectId;

public class SaborPalomitasMapper {

    public SaborPalomitasMapper() {
    }

    public SaborPalomitas toEntity(SaborPalomitasDTO dto) {
        SaborPalomitas entidad = new SaborPalomitas();

        if (dto.getId() != null && !dto.getId().isEmpty()) {
            entidad.setId(new ObjectId(dto.getId()));
        }

        entidad.setNombre(dto.getNombre());
        entidad.setPrecioExtra(dto.getPrecioExtra());
        entidad.setRutaImagen(dto.getRutaImagen());

        return entidad;
    }

    public SaborPalomitasDTO toDTO(SaborPalomitas entidad) {
        SaborPalomitasDTO dto = new SaborPalomitasDTO();

        dto.setId(entidad.getId().toHexString());
        dto.setNombre(entidad.getNombre());
        dto.setPrecioExtra(entidad.getPrecioExtra());
        dto.setRutaImagen(entidad.getRutaImagen());

        return dto;
    }
}

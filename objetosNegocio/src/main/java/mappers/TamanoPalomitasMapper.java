package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.TamanoPalomitas;
import dto.TamanoPalomitasDTO;
import org.bson.types.ObjectId;


public class TamanoPalomitasMapper {

    public TamanoPalomitasMapper() {
    }

    public TamanoPalomitas toEntity(TamanoPalomitasDTO dto) {
        TamanoPalomitas entidad = new TamanoPalomitas();

        if (dto.getId() != null && !dto.getId().isEmpty()) {
            entidad.setId(new ObjectId(dto.getId()));
        }

        entidad.setNombre(dto.getNombre());
        entidad.setPrecioExtra(dto.getPrecioExtra());
        entidad.setRutaImagen(dto.getRutaImagen());

        return entidad;
    }

    public static TamanoPalomitasDTO toDTO(TamanoPalomitas entidad) {
        TamanoPalomitasDTO dto = new TamanoPalomitasDTO();

        dto.setId(entidad.getId().toHexString());
        dto.setNombre(entidad.getNombre());
        dto.setPrecioExtra(entidad.getPrecioExtra());
        dto.setRutaImagen(entidad.getRutaImagen());

        return dto;
    }
}

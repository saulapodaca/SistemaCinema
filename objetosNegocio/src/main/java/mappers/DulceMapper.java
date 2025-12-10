package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.Dulce;
import dto.DulceDTO;
import org.bson.types.ObjectId;


public class DulceMapper {

    public DulceMapper() {
    }

    public Dulce toEntity(DulceDTO dto) {
        Dulce entidad = new Dulce();

        if (dto.getId() != null && !dto.getId().isEmpty()) {
            entidad.setId(new ObjectId(dto.getId()));
        }

        entidad.setNombre(dto.getNombre());
        entidad.setPrecioExtra(dto.getPrecioExtra());
        entidad.setRutaImagen(dto.getRutaImagen());

        return entidad;
    }

    public DulceDTO toDTO(Dulce entidad) {
        DulceDTO dto = new DulceDTO();

        dto.setId(entidad.getId().toHexString());
        dto.setNombre(entidad.getNombre());
        dto.setPrecioExtra(entidad.getPrecioExtra());
        dto.setRutaImagen(entidad.getRutaImagen());

        return dto;
    }
}

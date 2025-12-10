package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import dominio.SaborBebida;
import dto.SaborBebidaDTO;
import org.bson.types.ObjectId;

public class SaborBebidaMapper {

    public SaborBebidaMapper() {
    }

    public SaborBebida toEntity(SaborBebidaDTO dto) {
        SaborBebida entidad = new SaborBebida();

        if (dto.getId() != null && !dto.getId().isEmpty()) {
            entidad.setId(new ObjectId(dto.getId()));
        }

        entidad.setNombre(dto.getNombre());
        entidad.setPrecioExtra(dto.getPrecioExtra());
        entidad.setRutaImagen(dto.getRutaImagen());

        return entidad;
    }

    public SaborBebidaDTO toDTO(SaborBebida entidad) {
        SaborBebidaDTO dto = new SaborBebidaDTO();

        dto.setId(entidad.getId().toHexString());
        dto.setNombre(entidad.getNombre());
        dto.setPrecioExtra(entidad.getPrecioExtra());
        dto.setRutaImagen(entidad.getRutaImagen());

        return dto;
    }
}

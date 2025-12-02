package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import dominio.Sala;
import dto.SalaDTO;
import org.bson.types.ObjectId;

public class SalaMapper {

    public SalaDTO toDTO(Sala entidad) {
        if (entidad == null) {
            return null;
        }

        SalaDTO dto = new SalaDTO();

        dto.setId(entidad.getId() != null ? entidad.getId().toHexString() : null);

        dto.setNombre(entidad.getNombre());
        dto.setFilas(entidad.getFilas());
        dto.setColumnas(entidad.getColumnas());

        return dto;
    }

    public Sala toEntity(SalaDTO dto) {

        if (dto == null) {
            return null;
        }

        Sala entidad = new Sala();

        // ID seguro
        if (dto.getId() != null && !dto.getId().isBlank()) {
            try {
                entidad.setId(new ObjectId(dto.getId()));
            } catch (Exception ignored) {
                // Si el ID está corrupto, simplemente no lo seteamos.
                // Mongo lo regenerará en el insert.
            }
        }

        entidad.setNombre(dto.getNombre());
        entidad.setFilas(dto.getFilas());
        entidad.setColumnas(dto.getColumnas());

        return entidad;
    }
}

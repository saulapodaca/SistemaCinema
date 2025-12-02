package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.Promocion;
import dto.PromocionDTO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.bson.types.ObjectId;

public class PromocionMapper {

    public PromocionDTO toDTO(Promocion entidad) {

        PromocionDTO dto = new PromocionDTO();
    
        LocalDate fechaInicio = null;
        LocalDate fechaFin = null;

        if (entidad.getFechaInicio() != null) {
            fechaInicio = entidad.getFechaInicio().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }

        if (entidad.getFechaFin() != null) {
            fechaFin = entidad.getFechaFin().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        }

        dto.setId(entidad.getId() != null ? entidad.getId().toHexString() : null);
        dto.setDescripcion(entidad.getDescripcion());
        dto.setNombre(entidad.getNombre());
        dto.setDescuento(entidad.getDescuento());
        dto.setFechaInicio(fechaInicio);
        dto.setFechaFin(fechaFin);

        return dto;
    }

    public Promocion toEntity(PromocionDTO dto) {

        Promocion entidad = new Promocion();

        if (dto.getId() != null && !dto.getId().isBlank()) {
            entidad.setId(new ObjectId(dto.getId()));
        }

        if (dto.getFechaInicio() != null) {
            entidad.setFechaInicio(Date.from(dto.getFechaInicio().atStartOfDay()
                    .atZone(ZoneId.systemDefault()).toInstant()));
        }

        if (dto.getFechaFin() != null) {
            entidad.setFechaFin(Date.from(dto.getFechaFin().atStartOfDay()
                    .atZone(ZoneId.systemDefault()).toInstant()));
        }

        entidad.setDescripcion(dto.getDescripcion());
        entidad.setNombre(dto.getNombre());
        entidad.setDescuento(dto.getDescuento());

        return entidad;
    }
}
package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

/**
 * @author Héctor Javier Alonso Zaragoza - 00000252039
 * @author Saul Isaac Apodaca Baldenegro - 00000252020
 */

import dominio.Membresia;
import dto.MembresiaDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;


public class MembresiaMapper {

    public MembresiaMapper(){
        
    }
  
    public MembresiaDTO toDTO(Membresia entidad) {
        MembresiaDTO dto = new MembresiaDTO();

        LocalDate fecha = entidad.getFechaRegistro()
                .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        dto.setId(entidad.getId().toHexString());
        dto.setCodigoMembresia(entidad.getCodigoMembresia());
        dto.setFechaRegistro(fecha);
        dto.setNombreCliente(entidad.getNombreCliente());
        dto.setTipoMembresia(entidad.getTipoMembresia());
        dto.setActiva(entidad.isActiva());

        if (entidad.getPromocionesIds() != null) {
            dto.setPromociones(
                    entidad.getPromocionesIds().stream()
                            .map(ObjectId::toHexString)
                            .toList()
            );
        } else {
            dto.setPromociones(List.of());
        }

        return dto;
    }

    public Membresia toEntity(MembresiaDTO dto) {
        Membresia entidad = new Membresia();

        LocalDateTime fechaHora = dto.getFechaRegistro().atStartOfDay();
        Date fecha = Date.from(fechaHora.atZone(ZoneId.systemDefault()).toInstant());

        entidad.setId(new ObjectId(dto.getId()));
        entidad.setCodigoMembresia(dto.getCodigoMembresia());
        entidad.setFechaRegistro(fecha);
        entidad.setNombreCliente(dto.getNombreCliente());
        entidad.setTipoMembresia(dto.getTipoMembresia());
        entidad.setActiva(dto.isActiva());

        if (dto.getPromocionesIds() != null) {
            entidad.setPromocionesIds(
                    dto.getPromocionesIds().stream()
                            .map(ObjectId::new)
                            .toList()
            );
        } else {
            entidad.setPromocionesIds(List.of());
        }

        return entidad;

    }

}

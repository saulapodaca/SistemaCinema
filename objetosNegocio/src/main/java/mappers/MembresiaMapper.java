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
import java.util.stream.Collectors;
import org.bson.types.ObjectId;


public class MembresiaMapper {

    public MembresiaMapper(){
        
    }
  
   public MembresiaDTO toDTO(Membresia entidad) {
        if (entidad == null) {
            return null;
        }
        
        MembresiaDTO dto = new MembresiaDTO();
        
        // Convertir fecha
        LocalDate fecha = entidad.getFechaRegistro()
                .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        dto.setId(entidad.getId().toHexString());
        dto.setCodigoMembresia(entidad.getCodigoMembresia());
        dto.setFechaRegistro(fecha);
        dto.setNombreCliente(entidad.getNombreCliente());
        dto.setTipoMembresia(entidad.getTipoMembresia());
        dto.setActiva(entidad.isActiva());
        dto.setSaldo(entidad.getSaldo()); // ← AGREGAR ESTA LÍNEA
        
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
        if (dto == null) {
            return null;
        }
        
        Membresia entidad = new Membresia();
        
        // Convertir fecha
        LocalDateTime fechaHora = dto.getFechaRegistro().atStartOfDay();
        Date fecha = Date.from(fechaHora.atZone(ZoneId.systemDefault()).toInstant());
        
        // Validar que el ID no sea null antes de convertir
        if (dto.getId() != null && !dto.getId().isBlank()) {
            entidad.setId(new ObjectId(dto.getId()));
        }
        
        entidad.setCodigoMembresia(dto.getCodigoMembresia());
        entidad.setFechaRegistro(fecha);
        entidad.setNombreCliente(dto.getNombreCliente());
        entidad.setTipoMembresia(dto.getTipoMembresia());
        entidad.setActiva(dto.isActiva());
        entidad.setSaldo(dto.getSaldo()); // ← AGREGAR ESTA LÍNEA
        
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

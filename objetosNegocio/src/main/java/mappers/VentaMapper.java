package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import dominio.Venta;
import dto.EmpleadoDTO;
import dto.FuncionDTO;
import dto.VentaDTO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.bson.types.ObjectId;

public class VentaMapper {

    private final AsientoMapper asientoMapper;

    public VentaMapper(AsientoMapper asientoMapper) {
        this.asientoMapper = asientoMapper;
    }

    public VentaDTO toDTO(Venta entidad, FuncionDTO funcionDTO, EmpleadoDTO empleadoDTO) {
        if (entidad == null) {
            return null;
        }

        VentaDTO dto = new VentaDTO();

        LocalDate fecha = entidad.getFecha()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        dto.setId(entidad.getId() != null ? entidad.getId().toHexString() : null);
        dto.setSubtotal(entidad.getSubtotal());
        dto.setDescuento(entidad.getDescuento());
        dto.setTotal(entidad.getTotal());
        dto.setFormaPago(entidad.getFormaPago());
        dto.setFecha(fecha);
        dto.setFuncion(funcionDTO);
        dto.setEmpleado(empleadoDTO);

        if (entidad.getAsientos() != null) {
            dto.setAsientos(
                    entidad.getAsientos().stream()
                            .map(asientoMapper::toDTO)
                            .toList()
            );
        }

        if (entidad.getPromocionId() != null) {
            dto.setPromocionId(entidad.getPromocionId().toHexString());
        }

        return dto;
    }

    public Venta toEntity(VentaDTO dto) {
        if (dto == null) {
            return null;
        }

        Venta entidad = new Venta();

        if (dto.getId() != null && !dto.getId().isBlank()) {
            try {
                entidad.setId(new ObjectId(dto.getId()));
            } catch (IllegalArgumentException e) {
            }
        }

        // Fecha
        Date fecha = Date.from(
                dto.getFecha()
                        .atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );
        entidad.setFecha(fecha);

        entidad.setSubtotal(dto.getSubtotal());
        entidad.setDescuento(dto.getDescuento());
        entidad.setTotal(dto.getTotal());
        entidad.setFormaPago(dto.getFormaPago());

        // Funcion
        if (dto.getFuncion() != null && dto.getFuncion().getId() != null) {
            entidad.setFuncionId(new ObjectId(dto.getFuncion().getId()));
        }

        // Empleado
        if (dto.getEmpleado() != null && dto.getEmpleado().getId() != null) {
            entidad.setEmpleadoId(new ObjectId(dto.getEmpleado().getId()));
        }

        // Asientos
        if (dto.getAsientos() != null) {
            entidad.setAsientos(
                    dto.getAsientos().stream()
                            .map(asientoMapper::toEntity)
                            .toList()
            );
        }
        
        if (dto.getPromocionId() != null && !dto.getPromocionId().isBlank()) {
            try {
                entidad.setPromocionId(new ObjectId(dto.getPromocionId()));
            } catch (IllegalArgumentException e) {
            }
        }

        return entidad;
    }
}


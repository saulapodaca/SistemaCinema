package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.VentaAlimento;
import dto.ComboDTO;
import dto.EmpleadoDTO;
import dto.VentaAlimentoDTO;
import java.time.ZoneId;
import java.util.Date;
import org.bson.types.ObjectId;

public class VentaAlimentoMapper {

    public VentaAlimentoMapper() {
    }

    public VentaAlimentoDTO toDTO(
            VentaAlimento venta,
            ComboDTO comboDTO,
            EmpleadoDTO empleadoDTO
    ) {
        VentaAlimentoDTO dto = new VentaAlimentoDTO();

        dto.setId(venta.getId().toHexString());
        dto.setCombo(comboDTO);
        dto.setEmpleado(empleadoDTO);
        dto.setFecha(
                venta.getFecha().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()
        );

        dto.setSubtotal(venta.getSubtotal());
        dto.setTotal(venta.getTotal());

        return dto;
    }

    public VentaAlimento toEntity(VentaAlimentoDTO dto) {
        VentaAlimento venta = new VentaAlimento();

        if (dto.getId() != null && !dto.getId().isEmpty()) {
            venta.setId(new ObjectId(dto.getId()));
        }

        venta.setComboId(new ObjectId(dto.getCombo().getId()));
        venta.setEmpleadoId(new ObjectId(dto.getEmpleado().getId()));
        venta.setFecha(
                Date.from(
                        dto.getFecha()
                                .atStartOfDay(ZoneId.systemDefault())
                                .toInstant()
                )
        );
        venta.setSubtotal(dto.getSubtotal());
        venta.setTotal(dto.getTotal());

        return venta;
    }
}

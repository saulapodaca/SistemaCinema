package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.ReciboAlimento;
import dto.ReciboAlimentoDTO;
import dto.VentaAlimentoDTO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.bson.types.ObjectId;


public class ReciboAlimentoMapper {

    public ReciboAlimentoMapper() {
    }

    public ReciboAlimentoDTO toDTO(ReciboAlimento recibo, VentaAlimentoDTO ventaDTO) {
        if (recibo == null) {
            return null;
        }

        ReciboAlimentoDTO dto = new ReciboAlimentoDTO();

        LocalDate fecha = recibo.getFechaCompra()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        dto.setId(recibo.getId().toHexString());
        dto.setFechaCompra(fecha);
        dto.setRutaQr(recibo.getRutaQr());
        dto.setRutaPdf(recibo.getRutaPdf());
        dto.setVenta(ventaDTO);

        return dto;
    }

    public ReciboAlimento toEntity(ReciboAlimentoDTO dto) {
        if (dto == null) {
            return null;
        }

        ReciboAlimento entidad = new ReciboAlimento();

        if (dto.getId() != null && !dto.getId().isBlank()) {
            try {
                entidad.setId(new ObjectId(dto.getId()));
            } catch (IllegalArgumentException e) {
                
            }
        }

        // Convertir LocalDate -> Date
        Date fechaCompra = Date.from(
                dto.getFechaCompra()
                        .atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );

        entidad.setFechaCompra(fechaCompra);
        entidad.setRutaQr(dto.getRutaQr());
        entidad.setRutaPdf(dto.getRutaPdf());

        // Venta -> VentaId (validación segura)
        if (dto.getVenta() != null && dto.getVenta().getId() != null) {
            entidad.setVentaId(new ObjectId(dto.getVenta().getId()));
        }

        return entidad;
    }
    
}

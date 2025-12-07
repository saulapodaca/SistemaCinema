package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import dominio.Boleto;
import dto.BoletoDTO;
import dto.VentaDTO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.bson.types.ObjectId;

public class BoletoMapper {
    
    public BoletoMapper() {
    }
    
    public BoletoDTO toDTO(Boleto boleto, VentaDTO ventaDTO) {
        if (boleto == null) {
            return null;
        }
        
        BoletoDTO dto = new BoletoDTO();
        
        LocalDate fecha = boleto.getFechaCompra()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        
        dto.setId(boleto.getId().toHexString());
        dto.setFechaCompra(fecha);
        dto.setRutaQr(boleto.getRutaQr());
        dto.setRutaPdf(boleto.getRutaPdf());
        dto.setVenta(ventaDTO);
        dto.setEstado(boleto.getEstado());
        return dto;
    }
    
    public Boleto toEntity(BoletoDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Boleto entidad = new Boleto();
        
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
        entidad.setEstado(dto.getEstado());

        // Venta -> VentaId (validación segura)
        if (dto.getVenta() != null && dto.getVenta().getId() != null) {
            entidad.setVentaId(new ObjectId(dto.getVenta().getId()));
        }
        
        return entidad;
    }
}

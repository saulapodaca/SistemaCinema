package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.Combo;
import dto.ComboDTO;
import dto.DulceDTO;
import dto.SaborBebidaDTO;
import dto.SaborPalomitasDTO;
import dto.TamanoPalomitasDTO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;


public class ComboMapper {

    public ComboMapper() {
    }

    public Combo toEntity(ComboDTO dto) {
        Combo combo = new Combo();

        if (dto.getId() != null && !dto.getId().isEmpty()) {
            combo.setId(new ObjectId(dto.getId()));
        }

        combo.setNombre(dto.getNombre());
        combo.setRutaImagen(dto.getRutaImagen());
        combo.setDescripcion(dto.getDescripcion());
        combo.setTamanoPalomitasId(new ObjectId(dto.getTamanoPalomitasDTO().getId()));
        combo.setSaborPalomitasId(new ObjectId(dto.getSaborPalomitasDTO().getId()));

        List<ObjectId> bebidasIds = (dto.getBebidas() != null)
                ? dto.getBebidas().stream()
                        .map(b -> new ObjectId(b.getId()))
                        .toList()
                : new ArrayList<>();

        combo.setBebidasIds(bebidasIds);

        if (dto.getDulceDTO() != null) {
            combo.setDulceId(new ObjectId(dto.getDulceDTO().getId()));
        }
        combo.setPrecio(dto.getPrecio());

        return combo;
    }

    public static ComboDTO toDTO(
            Combo combo,
            TamanoPalomitasDTO tamanoPalomitasDTO,
            SaborPalomitasDTO saborPalomitasDTO,
            List<SaborBebidaDTO> bebidasDTO,
            DulceDTO dulceDTO
    ) {
        ComboDTO dto = new ComboDTO();

        dto.setId(combo.getId().toHexString());
        dto.setNombre(combo.getNombre());
        dto.setRutaImagen(combo.getRutaImagen());
        dto.setDescripcion(combo.getDescripcion());
        dto.setTamanoPalomitasDTO(tamanoPalomitasDTO);
        dto.setSaborPalomitasDTO(saborPalomitasDTO);
        dto.setBebidas(bebidasDTO);
        dto.setDulceDTO(dulceDTO);
        dto.setPrecio(combo.getPrecio());

        return dto;
    }
}


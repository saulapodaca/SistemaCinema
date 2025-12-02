package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.Funcion;
import dto.FuncionDTO;
import dto.PeliculaDTO;
import dto.SalaDTO;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import org.bson.types.ObjectId;

public class FuncionMapper {

    private final AsientoMapper asientoMapper;

    public FuncionMapper(AsientoMapper asientoMapper) {
        this.asientoMapper = asientoMapper;
    }

    public FuncionDTO toDTO(Funcion entidad, SalaDTO salaDTO, PeliculaDTO peliculaDTO) {
        if (entidad == null) {
            return null;
        }

        FuncionDTO dto = new FuncionDTO();

        // Fecha segura
        if (entidad.getFechaHora() != null) {
            LocalDateTime fecha = entidad.getFechaHora()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            dto.setFechaHora(fecha);
        }

        dto.setId(entidad.getId() != null ? entidad.getId().toHexString() : null);
        dto.setTipoSala(entidad.getTipoSala());
        dto.setSala(salaDTO);
        dto.setPelicula(peliculaDTO);

        // Asientos seguros
        if (entidad.getAsientos() != null) {
            dto.setAsientos(entidad.getAsientos().stream()
                    .map(asientoMapper::toDTO)
                    .toList());
        } else {
            dto.setAsientos(new ArrayList<>());
        }

        return dto;
    }

    public Funcion toEntity(FuncionDTO dto) {
        if (dto == null) {
            return null;
        }

        Funcion entidad = new Funcion();

        // ID seguro
        if (dto.getId() != null && !dto.getId().isBlank()) {
            try {
                entidad.setId(new ObjectId(dto.getId()));
            } catch (Exception ignored) {
            }
        }

        entidad.setTipoSala(dto.getTipoSala());

        // Fecha segura
        if (dto.getFechaHora() != null) {
            Date fecha = Date.from(dto.getFechaHora()
                    .atZone(ZoneId.systemDefault())
                    .toInstant());
            entidad.setFechaHora(fecha);
        }

        // Sala ID seguro
        if (dto.getSala() != null && dto.getSala().getId() != null && !dto.getSala().getId().isBlank()) {
            try {
                entidad.setSalaId(new ObjectId(dto.getSala().getId()));
            } catch (Exception ignored) {
            }
        }

        // Película ID seguro
        if (dto.getPelicula() != null && dto.getPelicula().getId() != null && !dto.getPelicula().getId().isBlank()) {
            try {
                entidad.setPeliculaId(new ObjectId(dto.getPelicula().getId()));
            } catch (Exception ignored) {
            }
        }

        // Asientos seguros
        if (dto.getAsientos() != null) {
            entidad.setAsientos(dto.getAsientos().stream()
                    .map(asientoMapper::toEntity)
                    .toList());
        } else {
            entidad.setAsientos(new ArrayList<>());
        }

        return entidad;
    }

}

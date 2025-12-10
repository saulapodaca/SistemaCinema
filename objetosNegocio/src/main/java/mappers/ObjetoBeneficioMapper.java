/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import dominio.ObjetoBeneficio;
import dto.ObjetoBeneficioDTO;
import java.util.HashSet;

/**
 *
 * @author Héctor Javier Alonso Zaragoza - 00000252039
 */
public class ObjetoBeneficioMapper {
    
    /**
     * Convierte una entidad ObjetoBeneficio en un DTO inmutable.
     *
     * @param entidad La entidad de dominio
     * @return El DTO correspondiente, o null si la entidad es null
     */
    public ObjetoBeneficioDTO toDTO(ObjetoBeneficio entidad) {
        if (entidad == null) {
            return null;
        }

        ObjetoBeneficioDTO.Builder builder = ObjetoBeneficioDTO.builder()
                .id(entidad.getId())
                .nombre(entidad.getNombre())
                .costo(entidad.getCosto());

        if (entidad.getStock() != null) {
            builder.stock(entidad.getStock());
        }

        if (entidad.getTiposMembresia() != null && !entidad.getTiposMembresia().isEmpty()) {
            builder.tiposMembresia(new HashSet<>(entidad.getTiposMembresia()));
        }

        return builder.build();
    }

    /**
     * Convierte un DTO en una entidad ObjetoBeneficio mutable.
     *
     * @param dto El DTO inmutable
     * @return La entidad correspondiente, o null si el DTO es null
     */
    public ObjetoBeneficio toEntity(ObjetoBeneficioDTO dto) {
        if (dto == null) {
            return null;
        }

        return new ObjetoBeneficio(
                dto.getId(),
                dto.getNombre(),
                dto.getCosto(),
                dto.getStock(),
                dto.getTiposMembresia() != null ? new HashSet<>(dto.getTiposMembresia()) : null
        );
    }
}



    package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.Pelicula;
import dto.PeliculaDTO;
import org.bson.types.ObjectId;

public class PeliculaMapper {

    public PeliculaDTO toDTO(Pelicula entidad) {

        if (entidad == null) return null;

        PeliculaDTO dto = new PeliculaDTO();

        dto.setId(entidad.getId() != null ? entidad.getId().toHexString() : null);

        dto.setTitulo(entidad.getTitulo());
        dto.setRutaImagen(entidad.getRutaImagen());
        dto.setDuracion(entidad.getDuracion());
        dto.setIdioma(entidad.getIdioma());

        return dto;
    }

    public Pelicula toEntity(PeliculaDTO dto) {

        if (dto == null) {
            return null;
        }

        Pelicula entidad = new Pelicula();

        if (dto.getId() != null && !dto.getId().isBlank()) {
            try {
                entidad.setId(new ObjectId(dto.getId()));
            } catch (Exception ignored) {
            }
        }

        entidad.setTitulo(dto.getTitulo());
        entidad.setRutaImagen(dto.getRutaImagen());
        entidad.setDuracion(dto.getDuracion());
        entidad.setIdioma(dto.getIdioma());

        return entidad;
    }

}

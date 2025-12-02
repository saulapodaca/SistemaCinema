package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.PeliculaDAO;
import dominio.Pelicula;
import dto.FiltroDTO;
import dto.PeliculaDTO;
import exceptions.PeliculaNoExistenteException;
import interfaces.IPeliculaBO;
import interfaces.IPeliculaDAO;
import java.util.List;
import mappers.PeliculaMapper;
import org.bson.types.ObjectId;

public class PeliculaBO implements IPeliculaBO {

    private static PeliculaBO instance;
    
    private final IPeliculaDAO peliculaDAO;
    private final PeliculaMapper peliculaMapper;

    private PeliculaBO() {
        this.peliculaDAO = new PeliculaDAO();
        this.peliculaMapper = new PeliculaMapper();
    }

    public static synchronized PeliculaBO getInstancia() {
        if (instance == null) {
            instance = new PeliculaBO();
        }
        return instance;
    }

    @Override
    public List<PeliculaDTO> obtenerPeliculas(FiltroDTO filtro) {
        try {

            if (filtro == null) {
                return List.of();
            }

            List<Pelicula> peliculas = peliculaDAO.obtenerTodas(filtro);

            return peliculas.stream()
                    .map(peliculaMapper::toDTO)
                    .toList();
            
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener películas: " + e.getMessage(), e);
        }
    }

    @Override
    public PeliculaDTO obtenerPorId(String id) throws PeliculaNoExistenteException {
        if (id == null || id.isBlank()) {
            throw new PeliculaNoExistenteException("El ID de la película es inválido.");
        }

        ObjectId oid;
        try {
            oid = new ObjectId(id);
        } catch (IllegalArgumentException ex) {
            throw new PeliculaNoExistenteException("El ID de la película no tiene un formato válido.");
        }

        Pelicula pelicula = peliculaDAO.obtenerPorId(oid);

        if (pelicula == null) {
            throw new PeliculaNoExistenteException("No se ha encontrado la película.");
        }

        return peliculaMapper.toDTO(pelicula);
    }
}
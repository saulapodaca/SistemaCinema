package interfaces;

import dominio.Pelicula;
import dto.FiltroDTO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public interface IPeliculaDAO {

    Pelicula insertar(Pelicula pelicula);

    Pelicula actualizar(Pelicula pelicula);

    Pelicula obtenerPorId(ObjectId id);

    List<Pelicula> obtenerTodas(FiltroDTO filtro);
    
    Pelicula obtenerPorTitulo(String titulo);
}

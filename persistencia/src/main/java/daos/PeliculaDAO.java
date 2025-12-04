package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.Pelicula;
import dto.FiltroDTO;
import interfaces.IPeliculaDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * 
 * @author saula
 */
public class PeliculaDAO implements IPeliculaDAO{

    /**
     * 
     */
    private final MongoCollection<Pelicula> coleccion;
 
    /**
     * 
     */
    public PeliculaDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("peliculas", Pelicula.class);
    }

    /**
     * 
     * @param pelicula 
     * @return  
     */
    @Override
    public Pelicula insertar(Pelicula pelicula) {
        pelicula.setId(new ObjectId());
        coleccion.insertOne(pelicula);
        return pelicula;

    }
    
    /**
     * 
     * @param pelicula 
     * @return  
     */
    @Override
    public Pelicula actualizar(Pelicula pelicula) {
        Bson filtro = eq("_id", pelicula.getId());
        coleccion.replaceOne(filtro, pelicula);
        return pelicula;
    }

    /**
     *
     * @param id
     * @return 
     */
    @Override
    public Pelicula obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    /**
     * 
     * @param filtro
     * @return
     */
    @Override
    public List<Pelicula> obtenerTodas(FiltroDTO filtro) {

        if (filtro == null) {
            return coleccion.find().into(new ArrayList<>());
        }

        String titulo = filtro.getTitulo();
        int pagina = filtro.getPagina() <= 0 ? 1 : filtro.getPagina();
        int tamañoPagina = filtro.getTamanoPagina() <= 0 ? 10 : filtro.getTamanoPagina();

        Bson query = new Document();

        // Filtro por título (regex case-insensitive)
        if (titulo != null && !titulo.isBlank()) {
            query = Filters.regex("titulo", ".*" + titulo + ".*", "i");
        }

        int skip = (pagina - 1) * tamañoPagina;

        return coleccion.find(query)
                .skip(skip)
                .limit(tamañoPagina)
                .into(new ArrayList<>());
    }
  
    @Override
    public Pelicula obtenerPorTitulo(String titulo) {
        return coleccion.find(Filters.eq("titulo", titulo)).first();
    }

}
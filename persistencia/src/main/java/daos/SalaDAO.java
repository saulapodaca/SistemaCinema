package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.Sala;
import interfaces.ISalaDAO;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * 
 * @author saula
 */
public class SalaDAO implements ISalaDAO{

    /**
     * 
     */
    private final MongoCollection<Sala> coleccion;

    /**
     * 
     */
    public SalaDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("salas", Sala.class);
    }

    /**
     * 
     * @param sala 
     * @return  
     */
    @Override
    public Sala insertar(Sala sala) {
        sala.setId(new ObjectId());
        coleccion.insertOne(sala);
        return sala; 
    }

    /**
     * 
     * @param sala 
     * @return  
     */
    @Override
    public Sala actualizar(Sala sala) {
        Bson filtro = eq("_id", sala.getId());
        coleccion.replaceOne(filtro, sala);
        return sala;
    }

    /**
     * 
     * @param id
     * @return
     */
    @Override
    public Sala obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    @Override
    public Sala obtenerPorNombre(String nombre) {
        return coleccion.find(eq("nombre", nombre)).first();
    }

}

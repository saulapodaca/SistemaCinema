package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.Sucursal;
import interfaces.ISucursalDAO;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * 
 * @author saula
 */
public class SucursalDAO implements ISucursalDAO{

    /**
     * 
     */
    private final MongoCollection<Sucursal> coleccion;

    /**
     * 
     */
    public SucursalDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("sucursales", Sucursal.class);
    }

    /**
     * 
     * @param sucursal 
     * @return  
     */
    @Override
    public Sucursal insertar(Sucursal sucursal) {
        sucursal.setId(new ObjectId());
        coleccion.insertOne(sucursal);
        return sucursal;
    }

    /**
     * 
     * @param sucursal 
     * @return  
     */
    @Override
    public Sucursal actualizar(Sucursal sucursal) {
        Bson filtro = eq("_id", sucursal.getId());
        coleccion.replaceOne(filtro, sucursal);
        return sucursal;
    }

    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public Sucursal obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

}

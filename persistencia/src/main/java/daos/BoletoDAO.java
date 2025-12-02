package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.Boleto;
import interfaces.IBoletoDAO;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * 
 * @author saula
 */
public class BoletoDAO implements IBoletoDAO{

    private final MongoCollection<Boleto> coleccion;

    /**
     * 
     */
    public BoletoDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("boletos", Boleto.class);
    }

    /**
     * 
     * @param boleto 
     * @return  
     */
    @Override
    public Boleto insertar(Boleto boleto) {
        boleto.setId(new ObjectId());
        coleccion.insertOne(boleto);
        
        return boleto;
    }

    /**
     * 
     * @param boleto
     * @return
     */
    @Override
    public Boleto actualizar(Boleto boleto) {
        Bson filtro = eq("_id", boleto.getId());

        coleccion.replaceOne(filtro, boleto);

        return boleto;
    }

    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public Boleto buscarPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

}

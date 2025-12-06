package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.Membresia;
import interfaces.IMembresiaDAO;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * 
 * @author saula
 */
public class MembresiaDAO implements IMembresiaDAO{

    private final MongoCollection<Membresia> coleccion;

    /**
     * 
     */
    public MembresiaDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("membresias", Membresia.class);
    }

    /**
     * 
     * @param membresia 
     * @return  
     */
    @Override
    public Membresia insertar(Membresia membresia) {
        membresia.setId(new ObjectId());
        coleccion.insertOne(membresia);
        return membresia;
    }

    /**
     *
     * @param membresia
     * @return 
     */
    @Override
    public Membresia actualizar(Membresia membresia) {
        Bson filtro = eq("_id", membresia.getId());
        coleccion.replaceOne(filtro, membresia);
        return membresia;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Membresia obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    /**
     * 
     * @param codigo
     * @return 
     */
    @Override
    public Membresia buscarPorCodigo(String codigo) {
        return coleccion.find(eq("codigoMembresia", codigo)).first();
    }
    
    @Override
    public boolean actualizarSaldo(String codigo,int saldoNuevo){
        
        Membresia m= buscarPorCodigo(codigo);
        
        if(m==null){
            return false;
        } 
        
        
        m.setSaldo(saldoNuevo);
        
        return true;
    }

}

package daos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.Dulce;
import interfaces.IDulceDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


public class DulcesDAO  implements IDulceDAO{

   private final MongoCollection<Dulce> coleccion;

    public DulcesDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("dulces", Dulce.class);
    }

    @Override
    public Dulce insertar(Dulce dulce) {
        dulce.setId(new ObjectId());
        coleccion.insertOne(dulce);
        return dulce;
    }

    @Override
    public Dulce actualizar(Dulce dulce) {
        Bson filtro = eq("_id", dulce.getId());
        coleccion.replaceOne(filtro, dulce);
        return dulce;
    }

    @Override
    public Dulce obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    @Override
    public List<Dulce> obtenerDulces() {
        return coleccion.find().into(new ArrayList<>());
    }
    
}

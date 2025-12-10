package daos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.SaborBebida;
import interfaces.ISaborBebidaDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


public class SaborBebidaDAO implements ISaborBebidaDAO{

    private final MongoCollection<SaborBebida> coleccion;

    public SaborBebidaDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("saboresBebida", SaborBebida.class);
    }

    @Override
    public SaborBebida insertar(SaborBebida saborBebida) {
        saborBebida.setId(new ObjectId());
        coleccion.insertOne(saborBebida);
        return saborBebida;
    }

    @Override
    public SaborBebida actualizar(SaborBebida saborBebida) {
        Bson filtro = eq("_id", saborBebida.getId());
        coleccion.replaceOne(filtro, saborBebida);
        return saborBebida;
    }

    @Override
    public SaborBebida obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    @Override
    public List<SaborBebida> obtenerSabores() {
        return coleccion.find().into(new ArrayList<>());
    }

}

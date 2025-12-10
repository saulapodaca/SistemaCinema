package daos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.TamanoPalomitas;
import interfaces.ITamanoPalomitas;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


public class TamanoPalomitasDAO implements ITamanoPalomitas{

    private final MongoCollection<TamanoPalomitas> coleccion;

    public TamanoPalomitasDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("tamanosPalomitas", TamanoPalomitas.class);
    }

    @Override
    public TamanoPalomitas insertar(TamanoPalomitas tamanoPalomitas) {
        tamanoPalomitas.setId(new ObjectId());
        coleccion.insertOne(tamanoPalomitas);
        return tamanoPalomitas;
    }

    @Override
    public TamanoPalomitas actualizar(TamanoPalomitas tamanoPalomitas) {
        Bson filtro = eq("_id", tamanoPalomitas.getId());
        coleccion.replaceOne(filtro, tamanoPalomitas);
        return tamanoPalomitas;
    }

    @Override
    public TamanoPalomitas obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    @Override
    public List<TamanoPalomitas> obtenerTamanos() {
        return coleccion.find().into(new ArrayList<>());
    }

}

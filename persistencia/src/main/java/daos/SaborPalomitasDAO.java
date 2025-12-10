package daos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.SaborPalomitas;
import interfaces.ISaborPalomitasDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class SaborPalomitasDAO implements ISaborPalomitasDAO {

    private final MongoCollection<SaborPalomitas> coleccion;

    public SaborPalomitasDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("saboresPalomitas", SaborPalomitas.class);
    }

    @Override
    public SaborPalomitas insertar(SaborPalomitas saborPalomitas) {
        saborPalomitas.setId(new ObjectId());
        coleccion.insertOne(saborPalomitas);
        return saborPalomitas;
    }

    @Override
    public SaborPalomitas actualizar(SaborPalomitas saborPalomitas) {
        Bson filtro = eq("_id", saborPalomitas.getId());
        coleccion.replaceOne(filtro, saborPalomitas);
        return saborPalomitas;
    }

    @Override
    public SaborPalomitas obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    @Override
    public List<SaborPalomitas> obtenerSabores() {
        return coleccion.find().into(new ArrayList<>());
    }

}

package daos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.Combo;
import dto.FiltroDTO;
import interfaces.IComboDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class ComboDAO implements IComboDAO{

    /**
     *
     */
    private final MongoCollection<Combo> coleccion;

    /**
     *
     */
    public ComboDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("combos", Combo.class);
    }

    /**
     *
     * @param combo
     * @return
     */
    @Override
    public Combo insertar(Combo combo) {
        combo.setId(new ObjectId());
        coleccion.insertOne(combo);
        return combo;

    }

    /**
     *
     * @param combo
     * @return
     */
    @Override
    public Combo actualizar(Combo combo) {
        Bson filtro = eq("_id", combo.getId());
        coleccion.replaceOne(filtro, combo);
        return combo;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Combo obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    /**
     *
     * @param filtro
     * @return
     */
    @Override
    public List<Combo> obtenerCombos(FiltroDTO filtro) {

        if (filtro == null) {
            return coleccion.find().into(new ArrayList<>());
        }

        String titulo = filtro.getTitulo();
        int pagina = filtro.getPagina() <= 0 ? 1 : filtro.getPagina();
        int tamañoPagina = filtro.getTamanoPagina() <= 0 ? 10 : filtro.getTamanoPagina();

        Bson query = new Document();

        // Filtro por título (regex case-insensitive)
        if (titulo != null && !titulo.isBlank()) {
            query = Filters.regex("nombre", ".*" + titulo + ".*", "i");
        }

        int skip = (pagina - 1) * tamañoPagina;

        return coleccion.find(query)
                .skip(skip)
                .limit(tamañoPagina)
                .into(new ArrayList<>());
    }
}

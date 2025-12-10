package daos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.ReciboAlimento;
import interfaces.IReciboAlimentoDAO;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

public class ReciboAlimentoDAO implements IReciboAlimentoDAO{

    private final MongoCollection<ReciboAlimento> coleccion;

    /**
     *
     */
    public ReciboAlimentoDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("recibosAlimentos", ReciboAlimento.class);
    }

    /**
     *
     * @param recibo
     * @return
     */
    @Override
    public ReciboAlimento insertar(ReciboAlimento recibo) {
        recibo.setId(new ObjectId());
        coleccion.insertOne(recibo);

        return recibo;
    }

    /**
     *
     * @param recibo
     * @return
     */
    @Override
    public ReciboAlimento actualizar(ReciboAlimento recibo) {
        Bson filtro = eq("_id", recibo.getId());

        coleccion.replaceOne(filtro, recibo);

        return recibo;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ReciboAlimento buscarPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }
}

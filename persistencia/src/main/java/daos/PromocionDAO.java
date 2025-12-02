package daos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import conexion.ManejadorConexion;
import dominio.Promocion;
import interfaces.IPromocionDAO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * 
 * @author saula
 */
public class PromocionDAO implements IPromocionDAO {

    /**
     *
     */
    private final MongoCollection<Promocion> coleccion;

    /**
     *
     */
    public PromocionDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("promociones", Promocion.class);
    }

    /**
     *
     * @param promo
     * @return
     */
    @Override
    public Promocion insertar(Promocion promo) {
        promo.setId(new ObjectId());
        coleccion.insertOne(promo);
        return promo;
    }

    /**
     *
     * @param promo
     * @return
     */
    @Override
    public Promocion actualizar(Promocion promo) {
        Bson filtro = eq("_id", promo.getId());
        coleccion.replaceOne(filtro, promo);
        return promo;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Promocion obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Promocion> obtenerTodas() {
        LocalDate hoy = LocalDate.now();

        Date hoyInicio = Date.from(
                hoy.atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );

        Date hoyFin = Date.from(
                hoy.atTime(23, 59, 59)
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
        );

        return coleccion.find(
                and(
                        lte("fechaInicio", hoyFin),
                        gte("fechaFin", hoyInicio)
                )
        ).into(new ArrayList<>());
    }

    /**
     *
     * @param nombre
     * @return
     */
    @Override
    public Promocion buscarPorNombre(String nombre) {
        return coleccion.find(eq("nombre", nombre)).first();
    }

}

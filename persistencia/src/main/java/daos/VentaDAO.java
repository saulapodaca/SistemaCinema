package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.Funcion;
import dominio.Venta;
import dto.FuncionDTO;
import dto.PeliculaDTO;
import dto.VentaDTO;
import interfaces.IVentaDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public class VentaDAO implements IVentaDAO {

    /**
     *
     */
    private final MongoCollection<Venta> coleccion;

    /**
     *
     */
    public VentaDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("ventas", Venta.class);
    }

    /**
     *
     * @param venta
     * @return
     */
    @Override
    public Venta insertar(Venta venta) {
        venta.setId(new ObjectId());
        coleccion.insertOne(venta);

        return venta;
    }

    /**
     *
     * @param venta
     * @return
     */
    @Override
    public Venta actualizar(Venta venta) {
        Bson filtro = eq("_id", venta.getId());
        coleccion.replaceOne(filtro, venta);

        return venta;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Venta obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Venta> obtenerVentasPorPelicula(ObjectId pelicula) {
        List<Venta> ventasTotales = new ArrayList<>();
        FuncionDAO funcion = new FuncionDAO();
        List<Funcion> funciones = funcion.obtenerPorPelicula(pelicula);
        for (Funcion f : funciones) {
            List<Venta> ventasFuncion = coleccion
                    .find(eq("funcionId", f.getId()))
                    .into(new ArrayList<>());
            ventasTotales.addAll(ventasFuncion);
        }
        return ventasTotales;
    }
}

package daos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.VentaAlimento;
import interfaces.IVentaAlimentoDAO;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


public class VentaAlimentoDAO implements IVentaAlimentoDAO{
/**
     * 
     */
    private final MongoCollection<VentaAlimento> coleccion;

    /**
     * 
     */
    public VentaAlimentoDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("ventasAlimentos", VentaAlimento.class);
    }

    /**
     * 
     * @param venta 
     * @return  
     */
    @Override
    public VentaAlimento insertar(VentaAlimento venta) {
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
    public VentaAlimento actualizar(VentaAlimento venta) {
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
    public VentaAlimento obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }
    
    
}

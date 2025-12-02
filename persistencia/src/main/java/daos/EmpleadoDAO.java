package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import conexion.ManejadorConexion;
import dominio.Empleado;
import dto.SesionDTO;
import interfaces.IEmpleadoDAO;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * 
 * @author saula
 */
public class EmpleadoDAO implements IEmpleadoDAO{

    private final MongoCollection<Empleado> coleccion;

    /**
     * 
     */
    public EmpleadoDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("empleados", Empleado.class);
    }

    /**
     * 
     * @param empleado 
     * @return  
     */
    @Override
    public Empleado insertar(Empleado empleado) {
        empleado.setId(new ObjectId());
        coleccion.insertOne(empleado);
        return empleado;
    }

    /**
     *
     * @param empleado
     * @return 
     */
    @Override
    public Empleado actualizar(Empleado empleado) {
        Bson filtro = eq("_id", empleado.getId());
        coleccion.replaceOne(filtro, empleado);
        return empleado;

    }

    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public Empleado obtenerPorId(ObjectId id) {
       return coleccion.find(eq("_id", id)).first();
    }

    /**
     *
     * @param sesion
     * @return
     */
    @Override
    public Empleado obtenerSesion(SesionDTO sesion) {
        return coleccion.find(
                and(
                        eq("usuario", sesion.getUsuario()),
                        eq("contrasena", sesion.getContrasena())
                )
        ).first();
    }

}

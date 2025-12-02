package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import conexion.ManejadorConexion;
import dominio.Funcion;
import dto.FiltroDTO;
import interfaces.IFuncionDAO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * 
 * @author saula
 */
public class FuncionDAO implements IFuncionDAO{
    
    private final MongoCollection<Funcion> coleccion;

    /**
     * 
     */
    public FuncionDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("funciones", Funcion.class);
    }

    /**
     * 
     * @param funcion 
     * @return  
     */
    @Override
    public Funcion insertar(Funcion funcion) {
        funcion.setId(new ObjectId());
        coleccion.insertOne(funcion);
        return funcion;
    }

    /**
     * 
     * @param funcion 
     * @return  
     */
    @Override
    public Funcion actualizar(Funcion funcion) {
        Bson filtro = eq("_id", funcion.getId());
        coleccion.replaceOne(filtro, funcion);
        return funcion;
    }

    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public Funcion obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    /**
     * 
     * @param peliculaId
     * @param filtro
     * @return
     */
    @Override
    public List<Funcion> obtenerTodas(ObjectId peliculaId, FiltroDTO filtro) {
        if (filtro.getFecha() == null) {
            return Collections.emptyList();
        }

        LocalDate fecha = filtro.getFecha();
        int pagina = filtro.getPagina() <= 0 ? 1 : filtro.getPagina();
        int tamaño = filtro.getTamanoPagina() <= 0 ? 10 : filtro.getTamanoPagina();

        LocalDateTime inicioDia = fecha.atStartOfDay();
        LocalDateTime finDia = fecha.atTime(23, 59, 59);

        Date inicio = Date.from(inicioDia.atZone(ZoneId.systemDefault()).toInstant());
        Date fin = Date.from(finDia.atZone(ZoneId.systemDefault()).toInstant());

        int skip = (pagina - 1) * tamaño;

        Bson filtroPelicula = eq("peliculaId", peliculaId);
        Bson filtroFecha = and(gte("fechaHora", inicio), lte("fechaHora", fin));

        return coleccion.find(and(filtroPelicula, filtroFecha))
                .skip(skip)
                .limit(tamaño)
                .into(new ArrayList<>());
    }

}

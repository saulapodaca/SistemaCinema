package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import conexion.ManejadorConexion;
import dominio.Membresia;
import interfaces.IMembresiaDAO;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * 
 * @author saula + elite
 */
public class MembresiaDAO implements IMembresiaDAO{

    private final MongoCollection<Membresia> coleccion;

    /**
     * 
     */
    public MembresiaDAO() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("membresias", Membresia.class);
    }

    /**
     * 
     * @param membresia 
     * @return  
     */
    @Override
    public Membresia insertar(Membresia membresia) {
        membresia.setId(new ObjectId());
        coleccion.insertOne(membresia);
        return membresia;
    }

    /**
     *
     * @param membresia
     * @return 
     */
    @Override
    public Membresia actualizar(Membresia membresia) {
        Bson filtro = eq("_id", membresia.getId());
        coleccion.replaceOne(filtro, membresia);
        return membresia;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Membresia obtenerPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    /**
     * 
     * @param codigo
     * @return 
     */
    @Override
    public Membresia buscarPorCodigo(String codigo) {
        System.out.println("6. MembresiaDAO - ¡LLEGÓ AL DAO!");
        System.out.println("6. MembresiaDAO - Buscando código: '" + codigo + "'");

     try {
         System.out.println("6. MembresiaDAO - Ejecutando consulta MongoDB...");
         Membresia resultado = coleccion.find(eq("codigoMembresia", codigo)).first();

         if (resultado == null) {
             System.out.println("6. MembresiaDAO - ❌ NO ENCONTRADO");
             long total = coleccion.countDocuments();
             System.out.println("6. MembresiaDAO - Total documentos: " + total);

             // Listar todos
             System.out.println("6. MembresiaDAO - Listando todos:");
             coleccion.find().forEach(m -> 
                 System.out.println("   - '" + m.getCodigoMembresia() + "'")
             );
         } else {
             System.out.println("6. MembresiaDAO - ✓ ENCONTRADO: " + resultado.getCodigoMembresia());
         }

         return resultado;

     } catch (Exception e) {
         System.out.println("6. MembresiaDAO - ERROR:");
         e.printStackTrace();
         throw e;
     }

    
    }
    @Override
    public boolean actualizarSaldo(Membresia m,int saldoNuevo){
    
      UpdateResult result = coleccion.updateOne(
              
        eq("codigoMembresia", m.getCodigoMembresia()),
        Updates.set("saldo", saldoNuevo)
        
      );
        return result.getModifiedCount() > 0;
    }

}

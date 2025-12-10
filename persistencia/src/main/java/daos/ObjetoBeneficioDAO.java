/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import conexion.ManejadorConexion;
import dominio.Membresia;
import dominio.ObjetoBeneficio;
import interfaces.IObjetoBeneficioDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Elite
 */
public class ObjetoBeneficioDAO implements IObjetoBeneficioDAO {
    
    
     private final MongoCollection<ObjetoBeneficio> coleccion;
    
    
    public ObjetoBeneficioDAO(){
        
         MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
         this.coleccion = db.getCollection("objetosbeneficio", ObjetoBeneficio.class);
         
    }
    
    
    /**
     * Inserta un nuevo objeto de beneficio en la colección.
     *
     * @param beneficio Entidad ObjetoBeneficio a insertar
     * @return La entidad insertada con su nuevo ObjectId
     */
    
    public ObjetoBeneficio insertar(ObjetoBeneficio beneficio) {
    // Generar un nuevo ObjectId y guardarlo como String
    ObjectId nuevoId = new ObjectId();
    beneficio.setId(nuevoId.toHexString()); // 🔹 convertir a String
    
    coleccion.insertOne(beneficio);
    return beneficio;
   }
    
   
    
    
    
    
    @Override
    public List<ObjetoBeneficio> obtenerObjetosDisponiblesPorMembresia(Membresia membresia){
        
        ArrayList<ObjetoBeneficio> beneficios = new ArrayList<>();
        
        coleccion.find(eq("tipo", membresia.getTipoMembresia())).into(beneficios);
        
        return beneficios;
        
        
    }
    
    @Override
    public boolean actualizarStock(String idOB, int unidades_vendidas){
        
       UpdateResult result = coleccion.updateOne(
            eq("_id", idOB),
            Updates.set("stock", unidades_vendidas)
                
                
        );
        
        return result.getModifiedCount() > 0;
        
        
    }
    
    
    
    
}

package conexion;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class ManejadorConexion {

    private static ManejadorConexion instancia;

    private MongoClient cliente;
    private MongoDatabase baseDatos;

    private static final String URI = "mongodb://localhost:27017";
    private static final String NOMBRE_BD = "SistemaCinema";

    private ManejadorConexion() {
        try {

            // REGISTRO DE POJOS (OBLIGATORIO)
            CodecRegistry pojoCodecRegistry = fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build())
            );

            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new com.mongodb.ConnectionString(URI))
                    .codecRegistry(pojoCodecRegistry)
                    .build();

            cliente = MongoClients.create(settings);

            baseDatos = cliente.getDatabase(NOMBRE_BD);

            System.out.println("Se conectó bien a la bd");

        } catch (Exception ex) {
            System.err.println("Error al conectar con bd: " + ex.getMessage());
            throw new RuntimeException("No se pudo conectar a la bd", ex);
        }
    }

    public static synchronized ManejadorConexion getInstancia() {
        if (instancia == null) {
            instancia = new ManejadorConexion();
        }
        return instancia;
    }

    public MongoDatabase getBaseDatos() {
        return baseDatos;
    }

    public void cerrar() {
        if (cliente != null) {
            cliente.close();
            System.out.println("Conexion a la bd cerrada");
        }
    }
}

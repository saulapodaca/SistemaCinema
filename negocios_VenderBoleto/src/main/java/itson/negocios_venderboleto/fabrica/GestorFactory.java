package itson.negocios_venderboleto.fabrica;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexion.ManejadorConexion;
import itson.negocios_correoelectronico.ConfiguracionCorreoElectronico;
import itson.negocios_correoelectronico.CorreoElectronico;
import itson.negocios_correoelectronico.ICorreoElectronico;
import itson.negocios_generadorqr.GeneradorQR;
import itson.negocios_generadorqr.IGeneradorQR;
import itson.negocios_gestorboletos.GestorBoletos;
import itson.negocios_gestorboletos.IGestorBoletos;
import itson.negocios_gestorempleados.GestorEmpleados;
import itson.negocios_gestorempleados.IGestorEmpleados;
import itson.negocios_gestorfunciones.GestorFunciones;
import itson.negocios_gestorfunciones.IGestorFunciones;
import itson.negocios_gestormembresias.GestorMembresias;
import itson.negocios_gestormembresias.IGestorMembresias;
import itson.negocios_gestorpeliculas.GestorPeliculas;
import itson.negocios_gestorpeliculas.IGestorPeliculas;
import itson.negocios_gestorpromociones.GestorPromociones;
import itson.negocios_gestorpromociones.IGestorPromociones;
import itson.negocios_gestorventas.GestorVentas;
import itson.negocios_gestorventas.IGestorVentas;
import itson.infraestructura_generadorpdf.GeneradorPDF;
import itson.infraestructura_generadorpdf.IGeneradorPDF;
import lectorQr.ILectorQR;
import lectorQr.LectorQR;
import org.bson.Document;

public class GestorFactory implements IGestorFactory {

    @Override
    public IGestorPeliculas crearGestorPeliculas() {
        return new GestorPeliculas();
    }

    @Override
    public IGestorFunciones crearGestorFunciones() {
        return new GestorFunciones();
    }

    @Override
    public IGestorEmpleados crearGestorEmpleados() {
        return new GestorEmpleados();
    }

    @Override
    public IGestorMembresias crearGestorMembresias() {
        return new GestorMembresias();
    }

    @Override
    public IGestorVentas crearGestorVentas() {
        return new GestorVentas();
    }

    @Override
    public IGestorBoletos crearGestorBoletos() {
        return new GestorBoletos();
    }

    @Override
    public IGeneradorQR crearGeneradorQR() {
        return new GeneradorQR();
    }

    @Override
    public ICorreoElectronico crearCorreoElectronico() {
        return new CorreoElectronico(new ConfiguracionCorreoElectronico());
    }

    @Override
    public IGestorPromociones crearGestorPromociones() {
        return new GestorPromociones();
    }

    @Override
    public ILectorQR crearLectorQR() {
        return new LectorQR();
    }

    public IGeneradorPDF crearGeneradorPDF() {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        MongoCollection<Document> coleccion = db.getCollection("boletos", Document.class);
        return new GeneradorPDF(coleccion);
    }
}

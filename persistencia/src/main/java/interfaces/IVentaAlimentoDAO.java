package interfaces;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import dominio.VentaAlimento;
import org.bson.types.ObjectId;

public interface IVentaAlimentoDAO {

    VentaAlimento insertar(VentaAlimento venta);

    VentaAlimento actualizar(VentaAlimento venta);

    VentaAlimento obtenerPorId(ObjectId id);
}

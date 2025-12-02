package interfaces;

import dominio.Boleto;
import org.bson.types.ObjectId;

/**
 *
 * @author saula
 */
public interface IBoletoDAO {

    Boleto insertar(Boleto boleto);

    Boleto actualizar(Boleto boleto);

    Boleto buscarPorId(ObjectId id);
}

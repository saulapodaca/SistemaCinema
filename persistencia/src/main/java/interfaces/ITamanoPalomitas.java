package interfaces;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.TamanoPalomitas;
import java.util.List;
import org.bson.types.ObjectId;

public interface ITamanoPalomitas {

    TamanoPalomitas insertar(TamanoPalomitas tamanoPalomitas);

    TamanoPalomitas actualizar(TamanoPalomitas tamanoPalomitas);

    TamanoPalomitas obtenerPorId(ObjectId id);

    List<TamanoPalomitas> obtenerTamanos();
}

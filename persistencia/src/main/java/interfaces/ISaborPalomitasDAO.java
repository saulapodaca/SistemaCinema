package interfaces;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.SaborPalomitas;
import java.util.List;
import org.bson.types.ObjectId;

public interface ISaborPalomitasDAO {

    SaborPalomitas insertar(SaborPalomitas saborPalomitas);

    SaborPalomitas actualizar(SaborPalomitas saborPalomitas);

    SaborPalomitas obtenerPorId(ObjectId id);

    List<SaborPalomitas> obtenerSabores();

}

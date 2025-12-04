package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import daos.SucursalDAO;
import dominio.Sucursal;
import dto.SucursalDTO;
import exceptions.NegocioException;
import exceptions.SucursalNoExistenteException;
import interfaces.ISucursalBO;
import interfaces.ISucursalDAO;
import mappers.SucursalMapper;
import org.bson.types.ObjectId;

public class SucursalBO implements ISucursalBO {

    private static SucursalBO instance;

    private final ISucursalDAO sucursalDAO;
    private final SucursalMapper sucursalMapper;

    private SucursalBO() {
        this.sucursalDAO = new SucursalDAO();
        this.sucursalMapper = new SucursalMapper();
    }

    public static synchronized SucursalBO getInstancia() {
        if (instance == null) {
            instance = new SucursalBO();
        }
        return instance;
    }

    @Override
    public SucursalDTO obtenerPorId(String id) throws SucursalNoExistenteException {
        Sucursal sucursal = sucursalDAO.obtenerPorId(new ObjectId(id));

        if (sucursal == null) {
            throw new SucursalNoExistenteException(
                    "No se ha podido encontrar la sucursal."
            );
        }

        return sucursalMapper.toDTO(sucursal);
    }

    @Override
    public SucursalDTO insertarSucursal(SucursalDTO sucursalDTO) throws NegocioException{

        if (sucursalDTO.getNombre() == null || sucursalDTO.getNombre().isBlank()) {
            throw new NegocioException("El nombre de la sucursal no puede estar vacío.");
        }
        if (sucursalDTO.getDireccion() == null || sucursalDTO.getDireccion().isBlank()) {
            throw new NegocioException("La dirección no puede estar vacía.");
        }

        Sucursal entidad = sucursalMapper.toEntity(sucursalDTO);

        Sucursal guardado = sucursalDAO.insertar(entidad);

        return sucursalMapper.toDTO(guardado);
    }

    @Override
    public SucursalDTO obtenerPorNombre(String nombre) throws NegocioException{

        if (nombre == null || nombre.isBlank()) {
            throw new NegocioException("El nombre de la sucursal no puede estar vacío.");
        }

        Sucursal entidad = sucursalDAO.obtenerPorNombre(nombre);

        if (entidad == null) {
            throw new NegocioException("No existe una sucursal con el nombre: " + nombre);
        }

        return sucursalMapper.toDTO(entidad);
    }

}

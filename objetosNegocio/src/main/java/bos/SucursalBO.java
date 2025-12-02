package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.SucursalDAO;
import dominio.Sucursal;
import dto.SucursalDTO;
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

}

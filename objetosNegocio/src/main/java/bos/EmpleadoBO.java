package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.EmpleadoDAO;
import dominio.Empleado;
import dto.EmpleadoDTO;
import dto.SesionDTO;
import dto.SucursalDTO;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.SesionEmpleadoNoExistenteException;
import exceptions.SucursalNoExistenteException;
import interfaces.IEmpleadoBO;
import interfaces.IEmpleadoDAO;
import interfaces.ISucursalBO;
import mappers.EmpleadoMapper;
import org.bson.types.ObjectId;


public class EmpleadoBO implements IEmpleadoBO {

    private static EmpleadoBO instance;

    private final IEmpleadoDAO empleadoDAO;
    private final ISucursalBO sucursalBO;
    private final EmpleadoMapper empleadoMapper;

    private EmpleadoBO() {
        this.empleadoDAO = new EmpleadoDAO();
        this.empleadoMapper = new EmpleadoMapper();
        this.sucursalBO = SucursalBO.getInstancia();
    }

    public static synchronized EmpleadoBO getInstancia() {
        if (instance == null) {
            instance = new EmpleadoBO();
        }
        return instance;
    }

    @Override
    public EmpleadoDTO obtenerSesionEmpleado(SesionDTO sesion) throws SesionEmpleadoNoExistenteException, SucursalNoExistenteException {

        Empleado empleado = empleadoDAO.obtenerSesion(sesion);

        if (empleado == null) {
            throw new SesionEmpleadoNoExistenteException(
                    "No fue posible encontrar la sesión del empleado."
            );
        }

        SucursalDTO sucursalDTO = sucursalBO.obtenerPorId(
                empleado.getSucursalId().toHexString()
        );

        return empleadoMapper.toDTO(empleado, sucursalDTO);
    }

    @Override
    public EmpleadoDTO obtenerPorId(String id) throws EmpleadoNoEncontradoException, SucursalNoExistenteException {
        
        Empleado empleado = empleadoDAO.obtenerPorId(new ObjectId(id));

        if (empleado == null) {
            throw new EmpleadoNoEncontradoException(
                    "No fue posible encontrar el empleado con ese ID."
            );
        }

        SucursalDTO sucursalDTO = sucursalBO.obtenerPorId(
                empleado.getSucursalId().toHexString()
        );

        return empleadoMapper.toDTO(empleado, sucursalDTO);
    }
}
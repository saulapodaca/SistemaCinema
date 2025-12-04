package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.EmpleadoDAO;
import dominio.Empleado;
import dto.EmpleadoDTO;
import dto.SesionDTO;
import dto.SucursalDTO;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.NegocioException;
import exceptions.SesionEmpleadoNoExistenteException;
import exceptions.SucursalNoExistenteException;
import interfaces.IEmpleadoBO;
import interfaces.IEmpleadoDAO;
import interfaces.ISucursalBO;
import mappers.EmpleadoMapper;
import org.bson.types.ObjectId;
import org.mindrot.jbcrypt.BCrypt;


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
    public EmpleadoDTO obtenerSesionEmpleado(SesionDTO sesion) throws SesionEmpleadoNoExistenteException {
        try {
            Empleado empleado = empleadoDAO.obtenerEmpleadoPorNombre(sesion.getUsuario());

            if (empleado == null) {
                throw new SesionEmpleadoNoExistenteException("No fue posible encontrar la sesión del empleado");
            }

            String contraseñaPlano = new String(sesion.getContrasena());
            boolean contrasenaValida = BCrypt.checkpw(contraseñaPlano, empleado.getContrasena());

            if (!contrasenaValida) {
                throw new SesionEmpleadoNoExistenteException("La contraseña no coincide.");
            }

            SucursalDTO sucursalDTO = sucursalBO.obtenerPorId(empleado.getSucursalId().toHexString());

            return empleadoMapper.toDTO(empleado, sucursalDTO);

        } catch (SesionEmpleadoNoExistenteException | SucursalNoExistenteException e) {
            throw new SesionEmpleadoNoExistenteException("Error al iniciar sesion:" + e.getMessage());
        }

    }

    @Override
    public EmpleadoDTO obtenerPorId(String id) throws EmpleadoNoEncontradoException, SucursalNoExistenteException {
        
        Empleado empleado = empleadoDAO.obtenerPorId(new ObjectId(id));

        if (empleado == null) {
            throw new EmpleadoNoEncontradoException(
                    "No fue posible encontrar el empleado con ese ID."
            );
        }

        SucursalDTO sucursalDTO = sucursalBO.obtenerPorId(empleado.getSucursalId().toHexString());

        return empleadoMapper.toDTO(empleado, sucursalDTO);
    }

    @Override
    public EmpleadoDTO insertarEmpleado(EmpleadoDTO empleado) throws SucursalNoExistenteException, NegocioException {

        if (empleado.getUsuario() == null || empleado.getUsuario().isBlank()) {
            throw new NegocioException("El usuario no puede estar vacío.");
        }

        if (empleado.getContrasena() == null || empleado.getContrasena().isBlank()) {
            throw new NegocioException("La contraseña no puede estar vacía.");
        }
        
        SucursalDTO sucursalDTO = sucursalBO.obtenerPorId(empleado.getSucursal().getId());
        
        Empleado entidad = empleadoMapper.toEntity(empleado);

        String hash = BCrypt.hashpw(empleado.getContrasena(), BCrypt.gensalt());
        entidad.setContrasena(hash);

        Empleado empleadoGuardado = empleadoDAO.insertar(entidad);
        
        return empleadoMapper.toDTO(empleadoGuardado, sucursalDTO);
    }
}
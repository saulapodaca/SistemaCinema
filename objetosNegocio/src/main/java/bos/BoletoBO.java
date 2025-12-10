package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import daos.BoletoDAO;
import dominio.Boleto;
import dto.BoletoDTO;
import dto.VentaDTO;
import dto.enums.EstadoBoleto;
import exceptions.BoletoNoExistenteException;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import interfaces.IBoletoBO;
import interfaces.IBoletoDAO;
import interfaces.IVentaBO;
import java.time.Instant;
import java.util.Date;
import mappers.BoletoMapper;
import org.bson.types.ObjectId;

public class BoletoBO implements IBoletoBO {
    
    private static BoletoBO instance;
    
    private final IBoletoDAO boletoDAO;
    private final IVentaBO ventaBO;
    
    private final BoletoMapper boletoMapper;

    /**
     *
     */
    private BoletoBO() {
        this.boletoDAO = new BoletoDAO();
        this.boletoMapper = new BoletoMapper();
        this.ventaBO = VentaBO.getInstancia();
    }

    /**
     *
     * @return
     */
    public static synchronized BoletoBO getInstancia() {
        if (instance == null) {
            instance = new BoletoBO();
        }
        return instance;
    }

    /**
     *
     * @param ventaDTO
     * @return
     */
    @Override
    public BoletoDTO generarBoleto(VentaDTO ventaDTO) {
        
        Boleto boleto = new Boleto();
        boleto.setVentaId(new ObjectId(ventaDTO.getId()));
        boleto.setFechaCompra(Date.from(Instant.now()));
        boleto.setEstado(EstadoBoleto.NUEVO);
        Boleto guardado = boletoDAO.insertar(boleto);
        
        return boletoMapper.toDTO(guardado, ventaDTO);
    }

    /**
     *
     * @param id
     * @return
     * @throws exceptions.BoletoNoExistenteException
     * @throws exceptions.EmpleadoNoEncontradoException
     * @throws exceptions.FuncionNoEncontradaException
     * @throws exceptions.SucursalNoExistenteException
     * @throws exceptions.VentaNoEncontradaException
     */
    @Override
    public BoletoDTO buscarBoletoPorId(String id) throws BoletoNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, SucursalNoExistenteException, VentaNoEncontradaException {
        
        if (id == null || id.isBlank()) {
            throw new BoletoNoExistenteException("El ID del boleto no es válido.");
        }
        
        ObjectId oid;
        try {
            oid = new ObjectId(id);
        } catch (IllegalArgumentException e) {
            throw new BoletoNoExistenteException("El ID del boleto no tiene un formato válido.");
        }
        
        Boleto boleto = boletoDAO.buscarPorId(oid);
        
        if (boleto == null) {
            throw new BoletoNoExistenteException("El boleto con ese ID no existe.");
        }
        
        VentaDTO ventaDTO = ventaBO.obtenerVentaPorID(boleto.getVentaId().toHexString());
        return boletoMapper.toDTO(boleto, ventaDTO);
    }
    
    @Override
    public BoletoDTO actualizar(BoletoDTO boletoDTO) throws BoletoNoExistenteException, EmpleadoNoEncontradoException, FuncionNoEncontradaException, IllegalArgumentException, SucursalNoExistenteException, VentaNoEncontradaException {
        if (boletoDTO == null || boletoDTO.getId() == null || boletoDTO.getId().isBlank()) {
            throw new IllegalArgumentException("El boletoDTO es inválido.");
        }
        
        Boleto boleto = boletoDAO.buscarPorId(new ObjectId(boletoDTO.getId()));
        
        if (boleto == null) {
            throw new BoletoNoExistenteException("No se encontró el boleto con ese ID.");
        }
        
        Boleto entidadActualizada = boletoMapper.toEntity(boletoDTO);
        
        entidadActualizada = boletoDAO.actualizar(entidadActualizada);
        return boletoMapper.toDTO(boleto, boletoDTO.getVenta());
    }
}

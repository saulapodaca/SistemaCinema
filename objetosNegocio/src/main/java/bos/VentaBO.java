package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import daos.VentaDAO;
import dominio.Venta;
import dto.AsientoDTO;
import dto.DetallePrecioDTO;
import dto.EmpleadoDTO;
import dto.FuncionDTO;
import dto.PromocionDTO;
import dto.VentaDTO;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.FuncionNoEncontradaException;
import exceptions.PromocionNoExistenteException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import interfaces.IEmpleadoBO;
import interfaces.IFuncionBO;
import interfaces.IPromocionBO;
import interfaces.IVentaBO;
import interfaces.IVentaDAO;
import java.util.List;
import mappers.AsientoMapper;
import mappers.VentaMapper;
import org.bson.types.ObjectId;

/**
 *
 *
 *
 * @author saula
 */
public class VentaBO implements IVentaBO {

    private final double PRECIO_BOLETO = 70.00;

    private static VentaBO instance;

    private final IVentaDAO ventaDAO;
    private final IPromocionBO promocionBO;
    private final IFuncionBO funcionBO;
    private final IEmpleadoBO empleadoBO;    
    private final VentaMapper ventaMapper;
    private final AsientoMapper asientoMapper;

    /**
     * <<<<<<< HEAD
     *
     * =======
     *
     * >>>>>>> cu-reagendar-boleto
     */
    private VentaBO() {
        this.ventaDAO = new VentaDAO();
        this.asientoMapper = new AsientoMapper();
        this.ventaMapper = new VentaMapper(asientoMapper);
        this.promocionBO = PromocionBO.getInstancia();
        this.funcionBO = FuncionBO.getInstancia();
        this.empleadoBO = EmpleadoBO.getInstancia();        
    }

    /**
     *
     * @return =======
     *
     * }
     *
     * /**
     *
     * @return >>>>>>> cu-reagendar-boleto
     */
    public static VentaBO getInstancia() {
        if (instance == null) {
            instance = new VentaBO();
        }
        return instance;
    }

    /**
     *
     * @param dto
     * @return
     * @throws exceptions.EmpleadoNoEncontradoException =======
     */
    @Override
    public VentaDTO registrarVenta(VentaDTO dto)
            throws EmpleadoNoEncontradoException, Exception {

        if (dto == null) {
            throw new VentaNoEncontradaException("La venta no puede ser null.");
        }

        calcularPreciosVenta(dto);

        Venta entidad = ventaMapper.toEntity(dto);
        Venta guardada = ventaDAO.insertar(entidad);

        if (guardada == null) {
            throw new VentaNoEncontradaException("No se logró registrar la venta.");
        }

        FuncionDTO funcionDTO = funcionBO.obtenerPorId(guardada.getFuncionId().toHexString());
        EmpleadoDTO empleadoDTO = empleadoBO.obtenerPorId(guardada.getEmpleadoId().toHexString());

        return ventaMapper.toDTO(guardada, funcionDTO, empleadoDTO);
    }

    /**
     *
     * @param id
     * @return
     * @throws exceptions.VentaNoEncontradaException
     * @throws exceptions.FuncionNoEncontradaException
     * @throws exceptions.EmpleadoNoEncontradoException
     * @throws exceptions.SucursalNoExistenteException
     */
    @Override
    public VentaDTO obtenerVentaPorID(String id)
            throws VentaNoEncontradaException, FuncionNoEncontradaException, EmpleadoNoEncontradoException, SucursalNoExistenteException {

        if (id == null || id.isBlank()) {
            throw new VentaNoEncontradaException("ID de la venta inválido.");
        }

        ObjectId oid;
        try {
            oid = new ObjectId(id);
        } catch (IllegalArgumentException ex) {
            throw new VentaNoEncontradaException("El ID proporcionado no tiene un formato válido.");
        }

        Venta venta = ventaDAO.obtenerPorId(oid);

        if (venta == null) {
            throw new VentaNoEncontradaException("La venta no ha sido encontrada.");
        }

        FuncionDTO funcionDTO = funcionBO.obtenerPorId(venta.getFuncionId().toHexString());
        EmpleadoDTO empleadoDTO = empleadoBO.obtenerPorId(venta.getEmpleadoId().toHexString());

        return ventaMapper.toDTO(venta, funcionDTO, empleadoDTO);
    }

    /**
     *
     * @param asientos
     * @param promo 
     * @return 
     */
    @Override
    public DetallePrecioDTO calcularPrecios(List<AsientoDTO> asientos, PromocionDTO promo) {

        double subtotal = asientos.size() * PRECIO_BOLETO;
        double descuento = 0;

        if (promo != null) {
            descuento = subtotal * promo.getDescuento();
        }

        double total = subtotal - descuento;
        return new DetallePrecioDTO(subtotal, descuento, total);
    }

    /**
     *
     * @param dto
     */
    private void calcularPreciosVenta(VentaDTO dto) throws PromocionNoExistenteException {

        double subtotal = dto.getAsientos().size() * PRECIO_BOLETO;

        double descuento = 0;
        if (dto.getPromocionId() != null && !dto.getPromocionId().isBlank()) {
            PromocionDTO promocion = promocionBO.obtenerPorId(dto.getPromocionId());

            if (promocion != null) {
                double porcentajeDescuento = promocion.getDescuento();
                descuento = subtotal * porcentajeDescuento;
            }
        }
        double total = subtotal - descuento;

        dto.setSubtotal(subtotal);
        dto.setDescuento(descuento);
        dto.setTotal(total);
    }

    public VentaDTO actualizarVenta(VentaDTO ventaDTO) throws VentaNoEncontradaException, FuncionNoEncontradaException, EmpleadoNoEncontradoException, SucursalNoExistenteException {
        if (ventaDTO == null || ventaDTO.getId() == null || ventaDTO.getId().isBlank()) {
            throw new IllegalArgumentException("El ventaDTO es inválido.");
        }

        Venta venta = ventaDAO.obtenerPorId(new ObjectId(ventaDTO.getId()));

        if (venta == null) {
            throw new VentaNoEncontradaException("No se encontró el boleto con ese ID.");
        }

        Venta entidadActualizada = ventaMapper.toEntity(ventaDTO);
        FuncionDTO funcionDTO = funcionBO.obtenerPorId(entidadActualizada.getFuncionId().toHexString());
        EmpleadoDTO empleadoDTO = empleadoBO.obtenerPorId(entidadActualizada.getEmpleadoId().toHexString());
        entidadActualizada = ventaDAO.actualizar(entidadActualizada);
        return ventaMapper.toDTO(entidadActualizada, funcionDTO, empleadoDTO);
    }
}

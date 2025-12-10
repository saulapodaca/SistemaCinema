package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.VentaAlimentoDAO;
import dominio.VentaAlimento;
import dto.ComboDTO;
import dto.DetallePrecioDTO;
import dto.EmpleadoDTO;
import dto.SaborBebidaDTO;
import dto.VentaAlimentoDTO;
import exceptions.ComboException;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.SucursalNoExistenteException;
import exceptions.VentaNoEncontradaException;
import interfaces.IComboBO;
import interfaces.IEmpleadoBO;
import interfaces.IVentaAlimentoBO;
import interfaces.IVentaAlimentoDAO;
import java.util.List;
import mappers.VentaAlimentoMapper;


public class VentaAlimentoBO implements IVentaAlimentoBO{

    private static VentaAlimentoBO instance;

    private final IVentaAlimentoDAO ventaDAO;
    private final IComboBO comboBO;
    private final IEmpleadoBO empleadoBO;

    private final VentaAlimentoMapper ventaMapper;

    private VentaAlimentoBO() {
        this.ventaDAO = new VentaAlimentoDAO();
        this.ventaMapper = new VentaAlimentoMapper();
        this.comboBO = ComboBO.getInstancia();
        this.empleadoBO = EmpleadoBO.getInstancia();

    }

    /**
     *
     * @return
     */
    public static VentaAlimentoBO getInstancia() {
        if (instance == null) {
            instance = new VentaAlimentoBO();
        }
        return instance;
    }

    @Override
    public VentaAlimentoDTO registrarVentaCombo(VentaAlimentoDTO dto) throws VentaNoEncontradaException, EmpleadoNoEncontradoException, SucursalNoExistenteException, ComboException{
        if (dto == null) {
            throw new VentaNoEncontradaException("La venta no puede ser null.");
        }

        calcularPreciosVenta(dto);

        VentaAlimento entidad = ventaMapper.toEntity(dto);
        VentaAlimento guardada = ventaDAO.insertar(entidad);

        if (guardada == null) {
            throw new VentaNoEncontradaException("No se logró registrar la venta.");
        }

        ComboDTO comboDTO = comboBO.obtenerComboPorId(guardada.getComboId().toHexString());
        EmpleadoDTO empleadoDTO = empleadoBO.obtenerPorId(guardada.getEmpleadoId().toHexString());

        return ventaMapper.toDTO(guardada, comboDTO, empleadoDTO);
    }

    @Override
    public DetallePrecioDTO calcularPreciosCombo(ComboDTO combo) {
        DetallePrecioDTO detalle = new DetallePrecioDTO();

        // SUBTOTAL = precio base del combo
        double subtotal = combo.getPrecio();

        // TOTAL comienza en el subtotal
        double total = subtotal;

        double extraTamano = combo.getTamanoPalomitasDTO().getPrecioExtra();
        double extraSabor = combo.getSaborPalomitasDTO().getPrecioExtra();

        total += extraTamano;
        total += extraSabor;

        double extraBebidas = 0;
        List<SaborBebidaDTO> bebidas = combo.getBebidas();
        if (bebidas != null && !bebidas.isEmpty()) {
            for (SaborBebidaDTO bebida : bebidas) {
                extraBebidas += bebida.getPrecioExtra();
            }
            total += extraBebidas;
        }

        double extraDulce = 0;
        if (combo.getDulceDTO() != null) {
            extraDulce = combo.getDulceDTO().getPrecioExtra();
            total += extraDulce;
        }

        // Setear en el DTO
        detalle.setSubtotal(subtotal);
        detalle.setTotal(total);
        return detalle;
    }

    /**
     *
     * @param dto
     */
    private void calcularPreciosVenta(VentaAlimentoDTO dto) {

        ComboDTO combo = dto.getCombo();
        double subtotal = combo.getPrecio();
        double total = subtotal;

        total += combo.getTamanoPalomitasDTO().getPrecioExtra();
        total += combo.getSaborPalomitasDTO().getPrecioExtra();

        List<SaborBebidaDTO> bebidas = combo.getBebidas();
        if (bebidas != null && !bebidas.isEmpty()) {
            for (SaborBebidaDTO bebida : bebidas) {
                total += bebida.getPrecioExtra();
            }
        }

        if (combo.getDulceDTO() != null) {
            total += combo.getDulceDTO().getPrecioExtra();
        }

        dto.setSubtotal(subtotal);
        dto.setTotal(total);
    }
}

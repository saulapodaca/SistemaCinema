package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.ReciboAlimentoDAO;
import dominio.ReciboAlimento;
import dto.ReciboAlimentoDTO;
import dto.VentaAlimentoDTO;
import exceptions.ReciboAlimentoException;
import interfaces.IReciboAlimentoBO;
import interfaces.IReciboAlimentoDAO;
import java.time.Instant;
import java.util.Date;
import mappers.ReciboAlimentoMapper;
import org.bson.types.ObjectId;


public class ReciboAlimentoBO implements IReciboAlimentoBO{

    private static ReciboAlimentoBO instance;
    
    private final IReciboAlimentoDAO reciboAlimentoDAO;
    
    private final ReciboAlimentoMapper reciboAlimentoMapper;
    
    /**
     * 
     */
    private ReciboAlimentoBO() {
        this.reciboAlimentoDAO = new ReciboAlimentoDAO();
        this.reciboAlimentoMapper = new ReciboAlimentoMapper();
    }

    /**
     * 
     * @return 
     */
    public static synchronized ReciboAlimentoBO getInstancia() {
        if (instance == null) {
            instance = new ReciboAlimentoBO();
        }
        return instance;
    }
    
    @Override
    public ReciboAlimentoDTO generarRecibo(VentaAlimentoDTO venta) {
        ReciboAlimento recibo = new ReciboAlimento();
        recibo.setVentaId(new ObjectId(venta.getId()));
        recibo.setFechaCompra(Date.from(Instant.now()));
        
        ReciboAlimento guardado = reciboAlimentoDAO.insertar(recibo);
        
        return reciboAlimentoMapper.toDTO(guardado, venta);
    }

    @Override
    public ReciboAlimentoDTO actualizar(ReciboAlimentoDTO reciboDTO) throws ReciboAlimentoException{
        if (reciboDTO == null || reciboDTO.getId() == null || reciboDTO.getId().isBlank()) {
            throw new ReciboAlimentoException("El recibo es inválido.");
        }

        ReciboAlimento recibo = reciboAlimentoDAO.buscarPorId(new ObjectId(reciboDTO.getId()));

        if (recibo == null) {
            throw new ReciboAlimentoException("No se encontró el recibo con ese ID.");
        }

        ReciboAlimento entidadActualizada = reciboAlimentoMapper.toEntity(reciboDTO);

        entidadActualizada = reciboAlimentoDAO.actualizar(entidadActualizada);
        return reciboAlimentoMapper.toDTO(recibo, reciboDTO.getVenta());
    }

}

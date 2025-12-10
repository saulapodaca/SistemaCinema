package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.ComboDAO;
import dominio.Combo;
import dto.ComboDTO;
import dto.DulceDTO;
import dto.FiltroDTO;
import dto.SaborBebidaDTO;
import dto.SaborPalomitasDTO;
import dto.TamanoPalomitasDTO;
import exceptions.ComboException;
import interfaces.IComboBO;
import interfaces.IComboDAO;
import interfaces.IDulceBO;
import interfaces.ISaborBebidaBO;
import interfaces.ISaborPalomitasBO;
import interfaces.ITamanoPalomitasBO;
import java.util.ArrayList;
import java.util.List;
import mappers.ComboMapper;
import org.bson.types.ObjectId;


public class ComboBO implements IComboBO{

    private static ComboBO instance;
    
    private final IComboDAO comboDAO;
    private final ComboMapper comboMapper;
    
    private final ISaborPalomitasBO saborPalomitasBO;
    private final ITamanoPalomitasBO tamanoPalomitasBO;
    private final ISaborBebidaBO saborBebidaBO;
    private final IDulceBO dulceBO;

    private ComboBO() {
        this.comboDAO = new ComboDAO();
        this.comboMapper = new ComboMapper();
        this.saborPalomitasBO = SaborPalomitasBO.getInstancia();
        this.tamanoPalomitasBO = TamanoPalomitasBO.getInstancia();
        this.saborBebidaBO = SaborBebidaBO.getInstancia();
        this.dulceBO = DulceBO.getInstancia();
    }

    public static synchronized ComboBO getInstancia() {
        if (instance == null) {
            instance = new ComboBO();
        }
        return instance;
    }
 
    @Override
    public List<ComboDTO> obtenerCombos(FiltroDTO filtro) throws ComboException {
        try {
            if (filtro == null) {
                return List.of();
            }

            List<Combo> combos = comboDAO.obtenerCombos(filtro);

            List<ComboDTO> lista = new ArrayList<>();

            for (Combo combo : combos) {

                // 1. Resolver DTOs externos a partir de los IDs del dominio
                TamanoPalomitasDTO tamDTO = tamanoPalomitasBO.obtenerPorId(
                        combo.getTamanoPalomitasId().toHexString()
                );

                SaborPalomitasDTO saborDTO = saborPalomitasBO.obtenerPorId(
                        combo.getSaborPalomitasId().toHexString()
                );

                List<SaborBebidaDTO> bebidasDTO = saborBebidaBO.obtenerPorIds(
                        combo.getBebidasIds()
                                .stream()
                                .map(ObjectId::toHexString)
                                .toList()
                );

                DulceDTO dulceDTO = null;
                if (combo.getDulceId() != null) {
                    dulceDTO = dulceBO.obtenerPorId(combo.getDulceId().toHexString());
                }

                // 2. Usar el mapper YA con toda la info resuelta
                ComboDTO dto = comboMapper.toDTO(
                        combo,
                        tamDTO,
                        saborDTO,
                        bebidasDTO,
                        dulceDTO
                );

                lista.add(dto);
            }

            return lista;

        } catch (Exception e) {
            throw new ComboException("Error al obtener combos: " + e.getMessage(), e);
        }
    }

    @Override
    public ComboDTO obtenerComboPorId(String id) throws ComboException {
        try {

            if (id == null || id.isEmpty()) {
                throw new ComboException("ID de combo inválido.");
            }

            Combo combo = comboDAO.obtenerPorId(new ObjectId(id)); // ← tu DAO
            if (combo == null) {
                throw new ComboException("No se encontró el combo con ID: " + id);
            }

            // ============================================
            // 1. Resolver DTOs externos a partir de IDs
            // ============================================
            // Tamaño palomitas
            TamanoPalomitasDTO tamDTO
                    = tamanoPalomitasBO.obtenerPorId(combo.getTamanoPalomitasId().toHexString());

            // Sabor palomitas
            SaborPalomitasDTO saborDTO
                    = saborPalomitasBO.obtenerPorId(combo.getSaborPalomitasId().toHexString());

            // Bebidas
            List<String> idsBebidas = combo.getBebidasIds()
                    .stream()
                    .map(ObjectId::toHexString)
                    .toList();

            List<SaborBebidaDTO> bebidasDTO
                    = saborBebidaBO.obtenerPorIds(idsBebidas);

            // Dulce (opcional)
            DulceDTO dulceDTO = null;
            if (combo.getDulceId() != null) {
                dulceDTO = dulceBO.obtenerPorId(combo.getDulceId().toHexString());
            }

            // ============================================
            // 2. Mapear a DTO final
            // ============================================
            ComboDTO dto = ComboMapper.toDTO(
                    combo,
                    tamDTO,
                    saborDTO,
                    bebidasDTO,
                    dulceDTO
            );

            return dto;

        } catch (Exception e) {
            throw new ComboException("Error al obtener combo por ID: " + e.getMessage(), e);
        }
    }

}

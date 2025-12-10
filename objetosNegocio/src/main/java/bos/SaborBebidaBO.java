package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.SaborBebidaDAO;
import dominio.SaborBebida;
import dto.SaborBebidaDTO;
import interfaces.ISaborBebidaBO;
import interfaces.ISaborBebidaDAO;
import java.util.ArrayList;
import java.util.List;
import mappers.SaborBebidaMapper;
import org.bson.types.ObjectId;


public class SaborBebidaBO implements ISaborBebidaBO{

    private static SaborBebidaBO instance;

    private final ISaborBebidaDAO saborBebidaDAO;
    private final SaborBebidaMapper saborBebidaMapper;

    private SaborBebidaBO() {
        this.saborBebidaDAO = new SaborBebidaDAO();
        this.saborBebidaMapper = new SaborBebidaMapper();
    }

    public static synchronized SaborBebidaBO getInstancia() {
        if (instance == null) {
            instance = new SaborBebidaBO();
        }
        return instance;
    }

    @Override
    public List<SaborBebidaDTO> obtenerSaboresBebidas() {
        List<SaborBebida> entidades = saborBebidaDAO.obtenerSabores(); 
        List<SaborBebidaDTO> dtos = new ArrayList<>();

        for (SaborBebida entidad : entidades) {
            dtos.add(saborBebidaMapper.toDTO(entidad));
        }

        return dtos;
    }
    
    @Override
    public SaborBebidaDTO obtenerPorId(String id) {
        if (id == null || id.isBlank())
            return null;

        SaborBebida entidad = saborBebidaDAO.obtenerPorId(new ObjectId(id));
        if (entidad == null)
            return null;

        return saborBebidaMapper.toDTO(entidad);
    }

    @Override
    public List<SaborBebidaDTO> obtenerPorIds(List<String> ids) {
        List<SaborBebidaDTO> dtos = new ArrayList<>();

        if (ids == null || ids.isEmpty()) {
            return dtos;
        }

        for (String id : ids) {
            if (id == null || id.isBlank()) {
                continue;
            }

            SaborBebida entidad = saborBebidaDAO.obtenerPorId(new ObjectId(id));
            if (entidad != null) {
                dtos.add(saborBebidaMapper.toDTO(entidad));
            }
        }

        return dtos;
    }

}

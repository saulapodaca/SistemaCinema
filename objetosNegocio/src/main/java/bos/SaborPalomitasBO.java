package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.SaborPalomitasDAO;
import dominio.SaborPalomitas;
import dto.SaborPalomitasDTO;
import interfaces.ISaborPalomitasBO;
import interfaces.ISaborPalomitasDAO;
import java.util.ArrayList;
import java.util.List;
import mappers.SaborPalomitasMapper;
import org.bson.types.ObjectId;


public class SaborPalomitasBO implements ISaborPalomitasBO {

    private static SaborPalomitasBO instance;

    private final ISaborPalomitasDAO saborPalomitasDAO;
    private final SaborPalomitasMapper saborPalomitasMapper;

    private SaborPalomitasBO() {
        this.saborPalomitasDAO = new SaborPalomitasDAO();
        this.saborPalomitasMapper = new SaborPalomitasMapper();
    }

    public static synchronized SaborPalomitasBO getInstancia() {
        if (instance == null) {
            instance = new SaborPalomitasBO();
        }
        return instance;
    }

    @Override
    public List<SaborPalomitasDTO> obtenerSaboresPalomitas() {
        List<SaborPalomitas> entidades = saborPalomitasDAO.obtenerSabores();
        List<SaborPalomitasDTO> dtos = new ArrayList<>();

        for (SaborPalomitas entidad : entidades) {
            dtos.add(saborPalomitasMapper.toDTO(entidad));
        }

        return dtos;
    }

    @Override
    public SaborPalomitasDTO obtenerPorId(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        SaborPalomitas entidad = saborPalomitasDAO.obtenerPorId(new ObjectId(id));
        if (entidad == null) {
            return null;
        }

        return saborPalomitasMapper.toDTO(entidad);
    }
}

package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.TamanoPalomitasDAO;
import dominio.TamanoPalomitas;
import dto.TamanoPalomitasDTO;
import interfaces.ITamanoPalomitas;
import interfaces.ITamanoPalomitasBO;
import java.util.ArrayList;
import java.util.List;
import mappers.TamanoPalomitasMapper;
import org.bson.types.ObjectId;


public class TamanoPalomitasBO implements ITamanoPalomitasBO {

    private static TamanoPalomitasBO instance;

    private final ITamanoPalomitas tamanoPalomitasDAO;
    private final TamanoPalomitasMapper tamanoPalomitasMapper;

    private TamanoPalomitasBO() {
        this.tamanoPalomitasDAO = new TamanoPalomitasDAO();
        this.tamanoPalomitasMapper = new TamanoPalomitasMapper();
    }

    public static synchronized TamanoPalomitasBO getInstancia() {
        if (instance == null) {
            instance = new TamanoPalomitasBO();
        }
        return instance;
    }

    @Override
    public List<TamanoPalomitasDTO> obtenerTamanosPalomitas() {
        List<TamanoPalomitas> entidades = tamanoPalomitasDAO.obtenerTamanos();
        List<TamanoPalomitasDTO> dtos = new ArrayList<>();

        for (TamanoPalomitas entidad : entidades) {
            dtos.add(tamanoPalomitasMapper.toDTO(entidad));
        }

        return dtos;
    }

    @Override
    public TamanoPalomitasDTO obtenerPorId(String id) {
        if (id == null || id.isBlank())
            return null;

        TamanoPalomitas entidad = tamanoPalomitasDAO.obtenerPorId(new ObjectId(id));
        if (entidad == null)
            return null;

        return tamanoPalomitasMapper.toDTO(entidad);
    }
}

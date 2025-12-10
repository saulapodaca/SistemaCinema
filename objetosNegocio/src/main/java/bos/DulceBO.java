package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.DulcesDAO;
import dominio.Dulce;
import dto.DulceDTO;
import interfaces.IDulceBO;
import interfaces.IDulceDAO;
import java.util.ArrayList;
import java.util.List;
import mappers.DulceMapper;
import org.bson.types.ObjectId;


public class DulceBO implements IDulceBO {

    private static DulceBO instance;

    private final IDulceDAO dulceDAO;
    private final DulceMapper dulceMapper;

    private DulceBO() {
        this.dulceDAO = new DulcesDAO();
        this.dulceMapper = new DulceMapper();
    }

    public static synchronized DulceBO getInstancia() {
        if (instance == null) {
            instance = new DulceBO();
        }
        return instance;
    }

    @Override
    public List<DulceDTO> obtenerDulces() {
        List<Dulce> entidades = dulceDAO.obtenerDulces();
        List<DulceDTO> dtos = new ArrayList<>();

        for (Dulce entidad : entidades) {
            dtos.add(dulceMapper.toDTO(entidad));
        }

        return dtos;
    }

    @Override
    public DulceDTO obtenerPorId(String id) {
        if (id == null || id.isBlank())
            return null;

        Dulce entidad = dulceDAO.obtenerPorId(new ObjectId(id));
        if (entidad == null)
            return null;

        return dulceMapper.toDTO(entidad);
    }
}

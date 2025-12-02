package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.SalaDAO;
import dominio.Sala;
import dto.SalaDTO;
import exceptions.SalaNoExistenteException;
import interfaces.ISalaBO;
import interfaces.ISalaDAO;
import mappers.SalaMapper;
import org.bson.types.ObjectId;

public class SalaBO implements ISalaBO {

    private static SalaBO instance;

    private final ISalaDAO salaDAO;
    private final SalaMapper salaMapper;

    private SalaBO() {
        this.salaDAO = new SalaDAO();
        this.salaMapper = new SalaMapper();
    }

    public static synchronized SalaBO getInstancia() {
        if (instance == null) {
            instance = new SalaBO();
        }
        return instance;
    }

    @Override
    public SalaDTO obtenerPorId(String id) throws SalaNoExistenteException {

        if (id == null || id.isBlank()) {
            throw new SalaNoExistenteException("El ID de sala es inválido.");
        }

        ObjectId oid;
        try {
            oid = new ObjectId(id);
        } catch (IllegalArgumentException e) {
            throw new SalaNoExistenteException("El ID de sala no tiene un formato válido.");
        }

        Sala sala = salaDAO.obtenerPorId(oid);

        if (sala == null) {
            throw new SalaNoExistenteException("No se ha encontrado la sala.");
        }

        return salaMapper.toDTO(sala);
    }
}

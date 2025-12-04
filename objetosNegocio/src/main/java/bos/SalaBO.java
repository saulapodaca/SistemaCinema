package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.SalaDAO;
import dominio.Sala;
import dto.SalaDTO;
import exceptions.NegocioException;
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

    @Override
    public SalaDTO insertarSala(SalaDTO salaDTO) throws NegocioException {

        if (salaDTO.getNombre() == null || salaDTO.getNombre().isBlank()) {
            throw new NegocioException("El nombre de la sala no puede estar vacío.");
        }

        if (salaDTO.getFilas() <= 0 || salaDTO.getColumnas() <= 0) {
            throw new NegocioException("Las filas y columnas deben ser mayores a cero.");
        }

        Sala entidad = salaMapper.toEntity(salaDTO);

        Sala guardado = salaDAO.insertar(entidad);

        return salaMapper.toDTO(guardado);
    }

    @Override
    public SalaDTO obtenerPorNombre(String nombre) throws NegocioException{
        if (nombre == null || nombre.isBlank()) {
            throw new NegocioException("El nombre de la sala no puede estar vacío.");
        }

        Sala entidad = salaDAO.obtenerPorNombre(nombre);

        if (entidad == null) {
            throw new NegocioException("No existe una sala con el nombre: " + nombre);
        }

        return salaMapper.toDTO(entidad);
    }

}

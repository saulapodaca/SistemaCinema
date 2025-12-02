package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import daos.FuncionDAO;
import dominio.Funcion;
import dto.AsientoDTO;
import dto.FiltroDTO;
import dto.FuncionDTO;
import dto.PeliculaDTO;
import dto.SalaDTO;
import dto.enums.EstadoAsiento;
import exceptions.FuncionNoEncontradaException;
import exceptions.PeliculaNoExistenteException;
import exceptions.SalaNoExistenteException;
import interfaces.IFuncionBO;
import interfaces.IPeliculaBO;
import interfaces.ISalaBO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import mappers.AsientoMapper;
import mappers.FuncionMapper;
import org.bson.types.ObjectId;

public class FuncionBO implements IFuncionBO {

    private static FuncionBO instance;

    private final FuncionDAO funcionDAO;
    private final ISalaBO salaBO;
    private final IPeliculaBO peliculaBO;
    private final FuncionMapper funcionMapper;

    private FuncionBO() {
        this.funcionDAO = new FuncionDAO();
        this.funcionMapper = new FuncionMapper(new AsientoMapper());
        this.salaBO = SalaBO.getInstancia();
        this.peliculaBO = PeliculaBO.getInstancia();
    }

    public static synchronized FuncionBO getInstancia() {
        if (instance == null) {
            instance = new FuncionBO();
        }
        return instance;
    }

    @Override
    public List<FuncionDTO> obtenerFuncionesPorPelicula(PeliculaDTO peliculaDTO, FiltroDTO filtro) throws FuncionNoEncontradaException {
        if (peliculaDTO == null || peliculaDTO.getId() == null || peliculaDTO.getId().isBlank()) {
            return Collections.emptyList();
        }

        ObjectId peliculaObjectId;
        try {
            peliculaObjectId = new ObjectId(peliculaDTO.getId());
        } catch (IllegalArgumentException e) {
            throw new FuncionNoEncontradaException("ID de película inválido.");
        }

        try {
            List<Funcion> funciones = funcionDAO.obtenerTodas(peliculaObjectId, filtro);
            List<FuncionDTO> result = new ArrayList<>();

            for (Funcion funcion : funciones) {
                SalaDTO salaDTO = salaBO.obtenerPorId(funcion.getSalaId().toHexString());
                FuncionDTO dto = funcionMapper.toDTO(funcion, salaDTO, peliculaDTO);
                result.add(dto);
            }

            return result;

        } catch (SalaNoExistenteException e) {
            throw new FuncionNoEncontradaException(e.getMessage());
        }

    }

    @Override
    public FuncionDTO obtenerPorId(String id) throws FuncionNoEncontradaException {
        if (id == null || id.isBlank()) {
            throw new FuncionNoEncontradaException("ID de función inválido.");
        }

        ObjectId oid;
        try {
            oid = new ObjectId(id);
        } catch (IllegalArgumentException e) {
            throw new FuncionNoEncontradaException("El ID de la función no tiene formato válido.");
        }

        try {
            Funcion funcion = funcionDAO.obtenerPorId(oid);

            if (funcion == null) {
                throw new FuncionNoEncontradaException("La función no existe.");
            }

            SalaDTO salaDTO = salaBO.obtenerPorId(funcion.getSalaId().toHexString());
            PeliculaDTO peliculaDTO = peliculaBO.obtenerPorId(funcion.getPeliculaId().toHexString());

            return funcionMapper.toDTO(funcion, salaDTO, peliculaDTO);

        } catch (SalaNoExistenteException | PeliculaNoExistenteException e) {
            throw new FuncionNoEncontradaException(e.getMessage());
        }

    }

    @Override
    public FuncionDTO actualizar(FuncionDTO dto) throws FuncionNoEncontradaException {
        if (dto == null || dto.getId() == null || dto.getId().isBlank()) {
            throw new FuncionNoEncontradaException("El ID de la función es inválido.");
        }

        ObjectId oid;
        try {
            oid = new ObjectId(dto.getId());
        } catch (IllegalArgumentException e) {
            throw new FuncionNoEncontradaException("El ID de la función no tiene formato válido.");
        }

        try {
            // Verificar existencia
            Funcion funcionExistente = funcionDAO.obtenerPorId(oid);

            if (funcionExistente == null) {
                throw new FuncionNoEncontradaException("No se encontró la función.");
            }

            // Convertir DTO → Entity
            Funcion nuevaEntidad = funcionMapper.toEntity(dto);

            // Guardar
            Funcion funcionActualizada = funcionDAO.actualizar(nuevaEntidad);

            // OJO: usar IDs ACTUALIZADOS
            SalaDTO salaDTO = salaBO.obtenerPorId(funcionActualizada.getSalaId().toHexString());
            PeliculaDTO peliculaDTO = peliculaBO.obtenerPorId(funcionActualizada.getPeliculaId().toHexString());

            return funcionMapper.toDTO(funcionActualizada, salaDTO, peliculaDTO);

        } catch (SalaNoExistenteException | PeliculaNoExistenteException e) {
            throw new FuncionNoEncontradaException(e.getMessage());
        }
    }

    /**
     *
     * @param funcionId
     * @return
     * @throws exceptions.FuncionNoEncontradaException
     * @throws exceptions.PeliculaNoExistenteException
     * @throws exceptions.SalaNoExistenteException
     */
    @Override
    public List<AsientoDTO> obtenerAsientos(String funcionId) throws FuncionNoEncontradaException, PeliculaNoExistenteException, SalaNoExistenteException {

        Funcion funcion = funcionDAO.obtenerPorId(new ObjectId(funcionId));

        if (funcion == null) {
            throw new FuncionNoEncontradaException("La función no fue encontrada.");
        }

        // Convertimos entidad → DTO correctamente
        SalaDTO salaDTO = salaBO.obtenerPorId(funcion.getSalaId().toHexString());
        PeliculaDTO peliculaDTO = peliculaBO.obtenerPorId(funcion.getPeliculaId().toHexString());

        FuncionDTO dto = funcionMapper.toDTO(funcion, salaDTO, peliculaDTO);

        return dto.getAsientos();
    }

    /**
     *
     * @param funcionId
     * @param seleccionados
     * @return
     * @throws exceptions.FuncionNoEncontradaException
     */
    @Override
    public FuncionDTO ocuparAsientos(String funcionId, List<AsientoDTO> seleccionados)
            throws FuncionNoEncontradaException {

        // Obtener la función una sola vez
        FuncionDTO funcion = this.obtenerPorId(funcionId);

        if (funcion == null) {
            throw new FuncionNoEncontradaException("La función no fue encontrada.");
        }

        // Convertimos los asientos seleccionados a un Set para comparación rápida
        Set<String> claveSeleccion = seleccionados.stream()
                .map(a -> a.getFila() + "-" + a.getColumna())
                .collect(Collectors.toSet());

        for (AsientoDTO asiento : funcion.getAsientos()) {

            String clave = asiento.getFila() + "-" + asiento.getColumna();

            if (claveSeleccion.contains(clave)) {

                if (asiento.getEstado() == EstadoAsiento.OCUPADO) {
                    throw new IllegalStateException("Asiento ya ocupado: " + asiento.getNombre());
                }

                asiento.setEstado(EstadoAsiento.OCUPADO);
            }
        }

        // Actualizar y regresar función
        return this.actualizar(funcion);
    }

    /**
     *
     * @param funcionId
     * @param seleccionados
     * @return
     * @throws exceptions.FuncionNoEncontradaException
     */
    @Override
    public FuncionDTO liberarAsientos(String funcionId, List<AsientoDTO> seleccionados)
            throws FuncionNoEncontradaException {

        FuncionDTO funcion = this.obtenerPorId(funcionId);

        if (funcion == null) {
            throw new FuncionNoEncontradaException("La función no fue encontrada.");
        }

        Set<String> claveSeleccion = seleccionados.stream()
                .map(a -> a.getFila() + "-" + a.getColumna())
                .collect(Collectors.toSet());

        for (AsientoDTO asiento : funcion.getAsientos()) {

            String clave = asiento.getFila() + "-" + asiento.getColumna();

            if (claveSeleccion.contains(clave)) {
                asiento.setEstado(EstadoAsiento.DISPONIBLE);
            }
        }

        return this.actualizar(funcion);
    }

}

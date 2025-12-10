package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
/**
 * @author Héctor Javier Alonso Zaragoza - 00000252039
 * @author Saul Isaac Apodaca Baldenegro - 00000252020
 */

import daos.MembresiaDAO;
import dominio.Membresia;
import dto.MembresiaDTO;
import dto.enums.TipoMembresia;
import exceptions.NegocioException;
import interfaces.IMembresiaBO;
import interfaces.IMembresiaDAO;
import java.time.LocalDate;
import java.util.List;
import mappers.MembresiaMapper;

public class MembresiaBO implements IMembresiaBO {

    public static MembresiaBO instance;
    
    private final IMembresiaDAO membresiaDAO;
    private final MembresiaMapper membresiaMapper;

    private MembresiaBO() {
        System.out.println("Inicializando MembresiaBO...");
        membresiaDAO = new MembresiaDAO();
        membresiaMapper = new MembresiaMapper();
        System.out.println("MembresiaBO inicializado");
        
    }

    public static synchronized MembresiaBO getInstancia() {
        if (instance == null) {
            instance = new MembresiaBO();
        }
        return instance;
    }
    
    
    
    public MembresiaDTO insertarMembresia(MembresiaDTO membresiaDTO) throws NegocioException {

        // Validaciones
        if (membresiaDTO.getCodigoMembresia() == null || 
            !membresiaDTO.getCodigoMembresia().matches("^[A-Z]{3}-\\d{3}$")) {
            throw new NegocioException("El código de membresía debe tener formato AAA-000.");
        }
        if (membresiaDTO.getTipoMembresia() == null) {
            throw new NegocioException("Debe especificarse el tipo de membresía (ESTUDIANTE o ADULTO_MAYOR).");
        }
        if (membresiaDTO.getNombreCliente() == null || membresiaDTO.getNombreCliente().isBlank()) {
            throw new NegocioException("Debe especificarse el nombre del cliente.");
        }

        // Datos mockeados
        membresiaDTO.setFechaRegistro(LocalDate.now());
        membresiaDTO.setActiva(true);
        membresiaDTO.setSaldo(100); // saldo inicial ficticio
        membresiaDTO.setPromocionesIds(List.of()); // sin promociones al inicio

        // Conversión DTO → entidad
        Membresia entidad = membresiaMapper.toEntity(membresiaDTO);

        // Inserción en DAO (mockeado)
        Membresia guardada = membresiaDAO.insertar(entidad);

        // Retorno DTO
        return membresiaMapper.toDTO(guardada);
    
    }
    
    
    public void insertarMock() throws NegocioException {
        MembresiaDTO estudiante = new MembresiaDTO();
        estudiante.setCodigoMembresia("EST-001");
        estudiante.setTipoMembresia(TipoMembresia.ESTUDIANTE);
        estudiante.setNombreCliente("Juan Pérez");

        MembresiaDTO adultoMayor = new MembresiaDTO();
        adultoMayor.setCodigoMembresia("ADM-002");
        adultoMayor.setTipoMembresia(TipoMembresia.ADULTO_MAYOR);
        adultoMayor.setNombreCliente("María López");

        insertarMembresia(estudiante);
        insertarMembresia(adultoMayor);
    }
    
    

    @Override
    public MembresiaDTO buscarMembresia(String codigoMembresia) {
        System.out.println("5. MembresiaBO - Buscando: '" + codigoMembresia + "'");

     if (codigoMembresia == null || codigoMembresia.isBlank()) {
         System.out.println("5. MembresiaBO - Código nulo o vacío");
         return null;
     }

     try {
         System.out.println("5. MembresiaBO - Llamando al DAO...");
         Membresia entidad = membresiaDAO.buscarPorCodigo(codigoMembresia);
         System.out.println("5. MembresiaBO - Entidad recibida: " + (entidad != null ? "Encontrada" : "NULL"));

         if (entidad == null) {
             System.out.println("5. MembresiaBO - Retornando null");
             return null;
         }

         System.out.println("5. MembresiaBO - Convirtiendo entidad a DTO...");
         MembresiaDTO dto = membresiaMapper.toDTO(entidad);
         System.out.println("5. MembresiaBO - DTO creado exitosamente");
         return dto;

     } catch (Exception e) {
         System.out.println("5. MembresiaBO - ERROR:");
         e.printStackTrace();
         throw e;
     }
    }
    
    
    @Override 
    public boolean actualizarSaldo(String codigomembresia, int saldonuevo){
        if(codigomembresia==null || codigomembresia.isBlank()|| saldonuevo <0){
            return false;
        }
        
        Membresia entidad = membresiaDAO.buscarPorCodigo(codigomembresia);

        
        if(entidad!=null && entidad.isActiva()==true){
            return membresiaDAO.actualizarSaldo(entidad, saldonuevo);
        }else{
            return false;
        }
        
        
    }

}

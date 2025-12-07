package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.MembresiaDAO;
import dominio.Membresia;
import dto.MembresiaDTO;
import interfaces.IMembresiaBO;
import interfaces.IMembresiaDAO;
import mappers.MembresiaMapper;

public class MembresiaBO implements IMembresiaBO {

    public static MembresiaBO instance;
    
    private final IMembresiaDAO membresiaDAO;
    private final MembresiaMapper membresiaMapper;

    private MembresiaBO() {
        membresiaDAO = new MembresiaDAO();
        membresiaMapper = new MembresiaMapper();
    }

    public static synchronized MembresiaBO getInstancia() {
        if (instance == null) {
            instance = new MembresiaBO();
        }
        return instance;
    }

    @Override
    public MembresiaDTO buscarMembresia(String codigoMembresia) {
        if (codigoMembresia == null || codigoMembresia.isBlank()) {
            return null;
        }

        Membresia entidad = membresiaDAO.buscarPorCodigo(codigoMembresia);

        if (entidad == null) {
            return null;
        }

        return membresiaMapper.toDTO(entidad);
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

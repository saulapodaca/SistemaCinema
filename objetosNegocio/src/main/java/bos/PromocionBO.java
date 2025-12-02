package bos;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.PromocionDAO;
import dominio.Promocion;
import dto.MembresiaDTO;
import dto.PromocionDTO;
import exceptions.PromocionNoExistenteException;
import interfaces.IMembresiaBO;
import interfaces.IPromocionBO;
import interfaces.IPromocionDAO;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import mappers.PromocionMapper;
import org.bson.types.ObjectId;


public class PromocionBO implements IPromocionBO {

    public static PromocionBO instance;

    private final IPromocionDAO promocionDAO;
    private final IMembresiaBO membresiaBO;

    private final PromocionMapper promocionMapper;

    private PromocionBO() {
        promocionDAO = new PromocionDAO();
        membresiaBO = MembresiaBO.getInstancia();
        promocionMapper = new PromocionMapper();
    }

    public static synchronized PromocionBO getInstancia() {
        if (instance == null) {
            instance = new PromocionBO();
        }
        return instance;
    }

    @Override
    public List<PromocionDTO> obtenerPromocionesGenerales() {
        
        return promocionDAO.obtenerTodas()
                .stream()
                .map(promocionMapper::toDTO)
                .toList();
    }

    @Override
    public List<PromocionDTO> obtenerPromocionesMembresia(String codigoMembresia) {
        MembresiaDTO mem = membresiaBO.buscarMembresia(codigoMembresia);

        if (mem == null || mem.getPromocionesIds() == null || mem.getPromocionesIds().isEmpty()) {
            return List.of();
        }

        LocalDate hoy = LocalDate.now();
        List<PromocionDTO> promocionesVigentesDTO = new ArrayList<>();

        for (String idPromocion : mem.getPromocionesIds()) {

            Promocion promocion = promocionDAO.obtenerPorId(new ObjectId(idPromocion));

            if (promocion == null) {
                continue;
            }

            if (esVigente(promocion, hoy)) {
                promocionesVigentesDTO.add(promocionMapper.toDTO(promocion));
            }
        }

        return promocionesVigentesDTO;
    }

    @Override
    public PromocionDTO validarCupon(String codigoPromocion) {
        
        Promocion promo = promocionDAO.obtenerPorId(new ObjectId(codigoPromocion));

        if (promo == null) {
            return null;
        }

        LocalDate hoy = LocalDate.now();

        return esVigente(promo, hoy) ? promocionMapper.toDTO(promo) : null;
    }

    @Override
    public PromocionDTO obtenerPromocionPorNombre(String nombrePromo) {

        Promocion promo = promocionDAO.buscarPorNombre(nombrePromo);
        return (promo != null) ? promocionMapper.toDTO(promo) : null;
    }

    /**
     * Verifica si una promoción está vigente a partir de la fecha actual.
     *
     * @param promocion La entidad Promocion a verificar.
     * @param hoy La fecha de referencia para la vigencia.
     * @return true si está vigente, false en caso contrario.
     */
    private boolean esVigente(Promocion promocion, LocalDate hoy) {
         LocalDate inicio = promocion.getFechaInicio().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate fin = promocion.getFechaFin().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();

        return (hoy.isEqual(inicio) || hoy.isAfter(inicio))
                && (hoy.isEqual(fin) || hoy.isBefore(fin));
    }

    @Override
    public PromocionDTO obtenerPorId(String id) throws PromocionNoExistenteException {
        Promocion promo = promocionDAO.obtenerPorId(new ObjectId(id));

        if (promo == null) {
            throw new PromocionNoExistenteException("No se encontró la promoción.");
        }

        return promocionMapper.toDTO(promo);
    }

}

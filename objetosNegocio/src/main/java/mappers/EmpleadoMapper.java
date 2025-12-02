package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.Empleado;
import dto.EmpleadoDTO;
import dto.SucursalDTO;
import org.bson.types.ObjectId;


public class EmpleadoMapper {

    public EmpleadoMapper() {
    }

    public EmpleadoDTO toDTO(Empleado entidad, SucursalDTO sucursal) {
        EmpleadoDTO dto = new EmpleadoDTO();

        dto.setId(entidad.getId().toHexString());
        dto.setUsuario(entidad.getUsuario());
        dto.setNombres(entidad.getNombres());
        dto.setApellidoPaterno(entidad.getApellidoPaterno());
        dto.setApellidoMaterno(entidad.getApellidoMaterno());
        dto.setPuesto(entidad.getPuesto());
        dto.setRutaImagen(entidad.getRutaImagen());
        dto.setTipoEmpleado(entidad.getTipoEmpleado());
        dto.setSucursal(sucursal);

        return dto;
    }

    public Empleado toEntity(EmpleadoDTO dto) {
        Empleado entidad = new Empleado();

        if (dto.getId() != null && !dto.getId().isBlank()) {
            entidad.setId(new ObjectId(dto.getId()));
        }

        entidad.setUsuario(dto.getUsuario());
        entidad.setNombres(dto.getNombres());
        entidad.setApellidoPaterno(dto.getApellidoPaterno());
        entidad.setApellidoMaterno(dto.getApellidoMaterno());
        entidad.setPuesto(dto.getPuesto());
        entidad.setRutaImagen(dto.getRutaImagen());
        entidad.setTipoEmpleado(dto.getTipoEmpleado());

        if (dto.getSucursal() != null && dto.getSucursal().getId() != null) {
            entidad.setSucursalId(new ObjectId(dto.getSucursal().getId()));
        }

        return entidad;
    }

}

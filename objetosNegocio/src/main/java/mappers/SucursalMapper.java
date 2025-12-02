package mappers;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominio.Sucursal;
import dto.SucursalDTO;
import org.bson.types.ObjectId;


public class SucursalMapper {
    
    public SucursalDTO toDTO(Sucursal entidad) {

        SucursalDTO dto = new SucursalDTO();

        dto.setId(entidad.getId().toHexString());
        dto.setNombre(entidad.getNombre());
        dto.setDireccion(entidad.getDireccion());

        return dto;
    }

    public Sucursal toEntity(SucursalDTO dto) {

        Sucursal entidad = new Sucursal();

        entidad.setId(new ObjectId(dto.getId()));
        entidad.setNombre(dto.getNombre());
        entidad.setDireccion(dto.getDireccion());

        return entidad;
    }

}

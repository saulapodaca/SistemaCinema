/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import daos.ObjetoBeneficioDAO;
import dominio.Membresia;
import dominio.ObjetoBeneficio;
import dto.ObjetoBeneficioDTO;
import interfaces.IObjetoBeneficioBO;
import interfaces.IObjetoBeneficioDAO;
import java.util.ArrayList;
import java.util.List;
import mappers.ObjetoBeneficioMapper;



/**
 *
 * @author Elite
 */
public class ObjetoBeneficioBO implements IObjetoBeneficioBO {
    
    public static ObjetoBeneficioBO instancia;
    
    private final IObjetoBeneficioDAO OBJBENDAO;
    private final ObjetoBeneficioMapper OBJBENMapper;
    
    
    private ObjetoBeneficioBO(){
        this.OBJBENDAO = new ObjetoBeneficioDAO();
        this.OBJBENMapper = new ObjetoBeneficioMapper();
    }
    
    
    public static synchronized ObjetoBeneficioBO getInstancia() {
        if (instancia == null) {
            instancia = new ObjetoBeneficioBO();
        }
        return instancia;
    }
    
    @Override
     public boolean actualizarStock(String idOB, int unidades_vendidas){
         
          if(idOB==null || idOB.isBlank()|| unidades_vendidas <0){
            return false;
        }
         
         return OBJBENDAO.actualizarStock(idOB, unidades_vendidas);
         
     }
    
    @Override
     public List<ObjetoBeneficioDTO> obtenerObjetosDisponiblesPorMembresia(Membresia membresia){
        
        if (membresia != null && membresia.isActiva()) {
            List<ObjetoBeneficio> entidades = OBJBENDAO.obtenerObjetosDisponiblesPorMembresia(membresia);
            List<ObjetoBeneficioDTO> dtos = new ArrayList<>();

            // Convertir cada entidad a DTO usando un bucle clásico
            for (ObjetoBeneficio entidad : entidades) {
                ObjetoBeneficioDTO dto = OBJBENMapper.toDTO(entidad);
                dtos.add(dto);
            }

            return dtos;
        } else {
            return new ArrayList<>(); // mejor que devolver null
        } 
         
    }
    
    
    
    
    
    
    
    
    
}

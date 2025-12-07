/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import dto.enums.TipoMembresia;
import java.util.Set;

/**
 *
 * @author Elite
 */
public class ObjetoBeneficio {
    
     private String id;
     private String nombre;
     private int costo;
     private Integer stock;
     private Set<TipoMembresia> tiposMembresia;
        
        
    public ObjetoBeneficio(){
        
    }

    public ObjetoBeneficio(String id, String nombre, int costo, Integer stock, Set<TipoMembresia> tiposMembresia) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.stock = stock;
        this.tiposMembresia = tiposMembresia;
    }

    public ObjetoBeneficio(String id, String nombre, int costo, Set<TipoMembresia> tiposMembresia) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.tiposMembresia = tiposMembresia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Set<TipoMembresia> getTiposMembresia() {
        return tiposMembresia;
    }

    public void setTiposMembresia(Set<TipoMembresia> tiposMembresia) {
        this.tiposMembresia = tiposMembresia;
    }
    
    
    
    
    
    
}

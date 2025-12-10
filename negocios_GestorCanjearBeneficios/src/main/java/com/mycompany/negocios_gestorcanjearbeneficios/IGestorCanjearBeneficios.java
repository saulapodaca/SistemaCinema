/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.negocios_gestorcanjearbeneficios;

import dominio.Membresia;
import dto.MembresiaDTO;
import dto.ObjetoBeneficioDTO;
import java.util.List;

/**
 *
 * @author Elite
 */
public interface IGestorCanjearBeneficios {
    
    MembresiaDTO buscarMembresia (String codigoMembresia);
    
    boolean actualizarPuntos(String codigomembresia, int saldonuevo);
    
    boolean actualizarStock(String idOB, int unidades_vendidas);
    
    List<ObjetoBeneficioDTO> obtenerObjetosDisponiblesPorMembresia(Membresia membresia);
    
    
}

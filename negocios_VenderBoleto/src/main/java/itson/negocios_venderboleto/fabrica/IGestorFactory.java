/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_venderboleto.fabrica;

import itson.negocios_correoelectronico.ICorreoElectronico;
import itson.negocios_generadorqr.IGeneradorQR;
import itson.negocios_gestorboletos.IGestorBoletos;
import itson.negocios_gestorempleados.IGestorEmpleados;
import itson.negocios_gestorfunciones.IGestorFunciones;
import itson.negocios_gestormembresias.IGestorMembresias;
import itson.negocios_gestorpeliculas.IGestorPeliculas;
import itson.negocios_gestorpromociones.IGestorPromociones;
import itson.negocios_gestorventas.IGestorVentas;
import lectorQr.ILectorQR;

/**
 *
 * @author saula
 */
public interface IGestorFactory {

    IGestorPeliculas crearGestorPeliculas();

    IGestorFunciones crearGestorFunciones();

    IGestorEmpleados crearGestorEmpleados();

    IGestorMembresias crearGestorMembresias();

    IGestorVentas crearGestorVentas();

    IGestorBoletos crearGestorBoletos();

    IGeneradorQR crearGeneradorQR();

    ICorreoElectronico crearCorreoElectronico();

    IGestorPromociones crearGestorPromociones();

    ILectorQR crearLectorQR();

}

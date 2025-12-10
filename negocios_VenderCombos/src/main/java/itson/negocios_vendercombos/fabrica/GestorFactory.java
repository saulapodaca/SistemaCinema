package itson.negocios_vendercombos.fabrica;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import itson.negocios_correoelectronico.CorreoElectronico;
import itson.negocios_correoelectronico.ICorreoElectronico;
import itson.negocios_generadorqr.GeneradorQR;
import itson.negocios_generadorqr.IGeneradorQR;
import itson.negocios_gestorcombos.GestorCombos;
import itson.negocios_gestorcombos.IGestorCombos;
import itson.negocios_gestorempleados.GestorEmpleados;
import itson.negocios_gestorempleados.IGestorEmpleados;
import itson.negocios_gestorreciboscombos.GestorRecibosCombos;
import itson.negocios_gestorreciboscombos.IGestorRecibosCombos;
import itson.negocios_gestorventas.GestorVentas;
import itson.negocios_gestorventas.IGestorVentas;


public class GestorFactory implements IGestorFactory{

    @Override
    public IGestorEmpleados crearGestorEmpleados() {
        return new GestorEmpleados();
    }

    @Override
    public IGeneradorQR crearGeneradorQR() {
        return new GeneradorQR();
    }

    @Override
    public ICorreoElectronico crearCorreoElectronico() {
        return new CorreoElectronico();
    }

    @Override
    public IGestorVentas crearGestorVentas() {
        return new GestorVentas();
    }

    @Override
    public IGestorRecibosCombos crearGestorRecibosAlimentos() {
        return new GestorRecibosCombos();
    }

    @Override
    public IGestorCombos crearGestorCombos() {
        return new GestorCombos();
    }

}

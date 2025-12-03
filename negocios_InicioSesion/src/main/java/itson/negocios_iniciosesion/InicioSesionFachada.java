package itson.negocios_iniciosesion;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.EmpleadoDTO;
import dto.SesionDTO;
import exceptions.SesionEmpleadoNoExistenteException;
import exceptions.SucursalNoExistenteException;
import itson.negocios_gestorempleados.GestorEmpleados;
import itson.negocios_gestorempleados.IGestorEmpleados;

public class InicioSesionFachada implements IInicioSesionFachada{

    private final IGestorEmpleados gestorEmpleados;
    
    public InicioSesionFachada(){
        this.gestorEmpleados = new GestorEmpleados();
    }
    
    @Override
    public EmpleadoDTO iniciarSesion(SesionDTO sesion) throws SesionEmpleadoNoExistenteException{
        return gestorEmpleados.obtenerSesionEmpleado(sesion);
    }

    

}

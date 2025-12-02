package itson.negocios_gestorempleados;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import bos.EmpleadoBO;
import dto.EmpleadoDTO;
import dto.SesionDTO;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.SesionEmpleadoNoExistenteException;
import exceptions.SucursalNoExistenteException;
import interfaces.IEmpleadoBO;

public class GestorEmpleados implements IGestorEmpleados {

    private final IEmpleadoBO empleadoBO = EmpleadoBO.getInstancia();
    
    @Override
    public EmpleadoDTO obtenerPorId(String idEmpleado) throws EmpleadoNoEncontradoException, SucursalNoExistenteException {
        return empleadoBO.obtenerPorId(idEmpleado);
    }

    @Override
    public EmpleadoDTO obtenerSesionEmpleado(SesionDTO sesion) throws SesionEmpleadoNoExistenteException, SucursalNoExistenteException  {
        return empleadoBO.obtenerSesionEmpleado(sesion);
    }

}

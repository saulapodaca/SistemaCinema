package presentacion.inicio;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.EmpleadoDTO;
import exceptions.EmpleadoNoEncontradoException;
import exceptions.SucursalNoExistenteException;
import presentacion.controles.ControlPantallas;
import presentacion.controles.ControlVentaBoleto;
import presentacion.utilerias.GestorSesion;


public class Inicio {

    public static void main(String[] args) {
        try {
            EmpleadoDTO empleado = ControlVentaBoleto.getInstance().getEmpleadoActual("692ba0b7dbfba219ac44152e");
            
             if (empleado == null) {
                System.err.println("⚠️  No se encontró el empleado. Revisa el ID.");
                return; // evita que abra el menú principal sin usuario
            }
             
             GestorSesion.setUsuario(empleado);
            
        } catch (EmpleadoNoEncontradoException | SucursalNoExistenteException ex) {
            return;
        }
        ControlPantallas control = ControlPantallas.getInstance();
        control.abrirMenuPrincipal();
    }

}

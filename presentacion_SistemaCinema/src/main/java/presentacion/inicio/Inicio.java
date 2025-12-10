package presentacion.inicio;


import presentacion.controles.ControlInsertMasivo;
import presentacion.controles.ControlPantallas;

/**
 * 
 * @author Saul Isaac Apodaca Baldenegro - 00000252020
 * @author Alejandro Rodríguez Lugo - 00000251622
 */
public class Inicio {

    public static void main(String[] args) {
        ControlInsertMasivo.getInstance().insertMasivo();
        ControlPantallas control = ControlPantallas.getInstance();
        control.abrirInicioSesion();
    }

}

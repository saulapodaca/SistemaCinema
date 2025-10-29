package presentacion.inicio;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import presentacion.controles.ControlPantallas;


public class Inicio {

    public static void main(String[] args) {
        ControlPantallas control = ControlPantallas.getInstance();
        control.abrirMenuPrincipal();
    }

}

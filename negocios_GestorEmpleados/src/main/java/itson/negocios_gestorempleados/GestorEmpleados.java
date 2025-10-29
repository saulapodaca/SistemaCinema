package itson.negocios_gestorempleados;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.EmpleadoDTO;


public class GestorEmpleados implements IGestorEmpleados{

    @Override
    public EmpleadoDTO obtenerSesion() {
        return new EmpleadoDTO("Saul", "Apodaca", "Nainari", "Gerente", "/fotoDefault.png");
    }

}

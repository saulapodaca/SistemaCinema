package itson.negocios_gestorempleados;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.EmpleadoDTO;

public class GestorEmpleados implements IGestorEmpleados {

    @Override
    public EmpleadoDTO obtenerSesion(String idEmpleado) {
        return new EmpleadoDTO(idEmpleado, "Saul", "Apodaca", "Nainari", "Gerente", "/fotoDefault.png");
    }

}

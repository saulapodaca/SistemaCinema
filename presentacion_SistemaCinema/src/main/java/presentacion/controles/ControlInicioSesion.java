package presentacion.controles;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.EmpleadoDTO;
import dto.SesionDTO;
import exceptions.SesionEmpleadoNoExistenteException;
import itson.negocios_iniciosesion.IInicioSesionFachada;
import itson.negocios_iniciosesion.InicioSesionFachada;


public class ControlInicioSesion {

    /**
     * Instancia única del control
     */
    private static ControlInicioSesion instance;

    private final IInicioSesionFachada inicioSesionFachada;

    /**
     * Constructor privado que inicializa el frame principal
     */
    private ControlInicioSesion() {
        this.inicioSesionFachada = new InicioSesionFachada();
    }

    /**
     * Método que obtiene la instancia única del controlador de pantallas, si no
     * existe, crea una nueva
     *
     * @return
     */
    public static synchronized ControlInicioSesion getInstance() {
        if (instance == null) {
            instance = new ControlInicioSesion();
        }
        return instance;
    }
    
    public EmpleadoDTO obtenerSesionEmpleado(SesionDTO sesion) throws SesionEmpleadoNoExistenteException{
        return inicioSesionFachada.iniciarSesion(sesion);
    }
}

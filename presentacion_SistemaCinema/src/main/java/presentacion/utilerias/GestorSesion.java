package presentacion.utilerias;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.EmpleadoDTO;

public class GestorSesion {

    /**
     * El empleado en sesion
     */
    private static EmpleadoDTO usuario;

    /**
     * Método para obtener el usuario
     *
     * @return usuario
     */
    public static EmpleadoDTO getUsuario() {
        return usuario;
    }

    /**
     * Método que define el usuario.
     *
     * @param usuario
     */
    public static void setUsuario(EmpleadoDTO usuario) {
        GestorSesion.usuario = usuario;
    }
    /**
     * Método que se utiliza para poder borrar los datos la sesión anterior
     * cuando se cierra sesión.
     */
    public static void borrarDatosSesion() {
        usuario = null;
    }
}

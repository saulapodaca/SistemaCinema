package presentacion;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import dto.PeliculaDTO;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * Clase encargada de controlar la navegación entre las diferentes pantallas del
 * sistemas Se implementa patrón singleton para garantizar una única instancia
 * del control
 *
 * @author saula
 */
public class ControlPantallas {

    /**
     * Instancia única del control
     */
    private static ControlPantallas instance;
    /**
     * Frame principal de la aplicación que se va a estar actualizando
     */
    private final FormPrincipal formPrincipal;

    /**
     * Constructor privado que inicializa el frame principal
     */
    private ControlPantallas() {
        formPrincipal = new FormPrincipal();
    }

    /**
     * Método que obtiene la instancia única del controlador de pantallas, si no
     * existe, crea una nueva
     *
     * @return
     */
    public static ControlPantallas getInstance() {
        if (instance == null) {
            instance = new ControlPantallas();
        }
        return instance;
    }

    /**
     * Método que abre el menú principal en el frame, se agrega el panel de
     * información del empleado y las opciones del gerente
     */
    public void abrirMenuPrincipal() {
        this.formPrincipal.getContentPane().removeAll();

        JPanel panelEmpleado = new PanelInformacionEmpleado();
        JPanel panelOpcionesGerente = new PanelOpcionesMenuGerente();

        this.formPrincipal.getContentPane().add(panelEmpleado, BorderLayout.WEST);
        agregarPanelNuevo(panelOpcionesGerente);
        this.formPrincipal.setVisible(true);
    }

    /**
     * Abre la pantalla de selección de películas, reemplazando el panel del
     * menú
     *
     * @param panelAnterior El panel que debe ser removido antes de agregar el
     * nuevo
     */
    public void abrirSeleccionPeliculas(JPanel panelAnterior) {
        eliminarPanelAnterior(panelAnterior);

        JPanel panelNuevo = new PanelSeleccionPeliculas();
        agregarPanelNuevo(panelNuevo);
    }

    public void abrirSeleccionFunciones(JPanel panelAnterior, PeliculaDTO pelicula) {
        eliminarPanelAnterior(panelAnterior);

        //TODO: OBTENER LAS FUNCIONES Y MANDARLAS
        JPanel panelNuevo = new PanelSeleccionFuncion(pelicula);
        agregarPanelNuevo(panelNuevo);
    }

    private void agregarPanelNuevo(JPanel panelNuevo) {
        this.formPrincipal.getContentPane().add(panelNuevo, BorderLayout.CENTER);
        this.formPrincipal.revalidate();
        this.formPrincipal.repaint();
    }

    private void eliminarPanelAnterior(JPanel panelAnterior) {
        this.formPrincipal.getContentPane().remove(panelAnterior);
    }
}

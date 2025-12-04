package presentacion.controles;

import dto.AsientoDTO;
import dto.BoletoDTO;
import dto.EmpleadoDTO;
import dto.FuncionDTO;
import dto.PeliculaDTO;
import java.awt.BorderLayout;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import presentacion.FormPrincipal;
import presentacion.InicioSesionPanel;
import presentacion.PanelInformacionBoleto;
import presentacion.PanelInformacionEmpleado;
import presentacion.PanelInformacionPago;
import presentacion.PanelOpcionesMenuGerente;
import presentacion.PanelSeleccionAsientos;
import presentacion.PanelSeleccionFuncion;
import presentacion.PanelSeleccionPeliculas;

/**
 * Clase encargada de controlar la navegación entre las diferentes pantallas del
 * sistemas Se implementa patrón singleton para garantizar una única instancia
 * del control
 *
 * @author Saul Isaac Apodaca Baldenegro - 00000252020
 * @author Alejandor Rodríguez Lugo - 00000251622
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
    public static synchronized ControlPantallas getInstance() {
        if (instance == null) {
            instance = new ControlPantallas();
        }
        return instance;
    }

    public void abrirInicioSesion() {
        agregarPanelNuevo(new InicioSesionPanel());
        formPrincipal.setVisible(true);
    }

    /**
     * Método que abre el menú principal en el frame, se agrega el panel de
     * información del empleado y las opciones del gerente
     */
    public void abrirMenuPrincipal() {
        cargarPanelEmpleado();
        agregarPanelNuevo(new PanelOpcionesMenuGerente());
    }

    /**
     * Abre la pantalla de selección de películas, reemplazando el panel del
     * menú
     *
     * @param panelAnterior El panel que debe ser removido antes de agregar el
     * nuevo
     */
    public void abrirSeleccionPeliculas(JPanel panelAnterior) {
        agregarPanelNuevo(new PanelSeleccionPeliculas());
    }

    public void abrirSeleccionFunciones(JPanel panelAnterior, PeliculaDTO pelicula) {
        agregarPanelNuevo(new PanelSeleccionFuncion(pelicula));
    }

    public void abrirSeleccionAsientos(JPanel panelAnterior, FuncionDTO funcion) {
        agregarPanelNuevo(new PanelSeleccionAsientos(funcion));

    }

    public void abrirInformacionPago(JPanel panelAnterior, List<AsientoDTO> asientos, FuncionDTO funcion) {
        agregarPanelNuevo(new PanelInformacionPago(asientos, funcion));

    }

    public void abrirInformacionBoleto(JPanel panelAnterior, BoletoDTO boleto) {
        agregarPanelNuevo(new PanelInformacionBoleto(boleto));

    }

    private void agregarPanelNuevo(JPanel nuevo) {
        JPanel centro = formPrincipal.getOpcMenu();
        centro.removeAll();
        centro.add(nuevo, BorderLayout.CENTER);
        centro.revalidate();
        centro.repaint();
    }

    private void cargarPanelEmpleado() {
        JPanel lateral = formPrincipal.getPanelEmpleado();
        lateral.removeAll();
        lateral.add(new PanelInformacionEmpleado());
        lateral.revalidate();
        lateral.repaint();
    }
}

package presentacion.controles;

import dto.AsientoDTO;
import dto.BoletoDTO;
import dto.EmpleadoDTO;
import dto.FuncionDTO;
import dto.PeliculaDTO;
import dto.VentaDTO;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import presentacion.FormPrincipal;
import presentacion.InicioSesionPanel;
import presentacion.PanelEscanearQR;
import presentacion.PanelFechasReporte;
import presentacion.PanelInformacionBoleto;
import presentacion.PanelInformacionBoletoReagenda;
import presentacion.PanelInformacionEmpleado;
import presentacion.PanelInformacionPago;
import presentacion.PanelInformacionReagenda;
import presentacion.PanelOpcionesMenuEmpleado;
import presentacion.PanelOpcionesMenuGerente;
import presentacion.PanelReportePelicula;
import presentacion.PanelSeleccionAsientos;
import presentacion.PanelSeleccionAsientosReagenda;
import presentacion.PanelSeleccionFuncion;
import presentacion.PanelSeleccionFuncionReagenda;
import presentacion.PanelSeleccionPeliculas;
import presentacion.PanelSeleccionPeliculasReporte;

/**
 * Clase encargada de controlar la navegación entre las diferentes pantallas del
 * sistemas Se implementa patrón singleton para garantizar una única instancia
 * del control
 *
 * @author Saul Isaac Apodaca Baldenegro - 00000252020
 * @author Alejandro Rodríguez Lugo - 00000251622
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
        limpiarPanelEmpleado();
        agregarPanelNuevo(new InicioSesionPanel());
        formPrincipal.setVisible(true);
    }

    /**
     * Método que abre el menú principal en el frame, se agrega el panel de
     * información del empleado y las opciones del gerente
     */
    public void abrirMenuPrincipal(EmpleadoDTO empleado) {
        cargarPanelEmpleado(empleado);
        agregarPanelNuevo(new PanelOpcionesMenuGerente(empleado));
    }

    public void abrirMenuPrincipalEmpleado(EmpleadoDTO empleado) {
        cargarPanelEmpleado(empleado);
        agregarPanelNuevo(new PanelOpcionesMenuEmpleado(empleado));
    }

    /**
     * Abre la pantalla de selección de películas, reemplazando el panel del
     * menú
     *
     * @param panelNuevo El panel nuevo que será establecido en el form
     * principal.
     */
    public void abrirSeleccionPeliculas(JPanel panelNuevo) {
        agregarPanelNuevo(new PanelSeleccionPeliculas());
    }

    public void abrirSeleccionFunciones(JPanel panelNuevo, PeliculaDTO pelicula) {
        agregarPanelNuevo(new PanelSeleccionFuncion(pelicula));
    }

    public void abrirSeleccionAsientos(JPanel panelNuevo, FuncionDTO funcion) {
        agregarPanelNuevo(new PanelSeleccionAsientos(funcion));

    }

    public void abrirInformacionPago(JPanel panelNuevo, List<AsientoDTO> asientos, FuncionDTO funcion) {
        agregarPanelNuevo(new PanelInformacionPago(asientos, funcion));

    }

    public void abrirInformacionBoleto(JPanel panelNuevo, BoletoDTO boleto) {
        agregarPanelNuevo(new PanelInformacionBoleto(boleto));
    }

    public void abrirEscanearQR(JPanel panelNuevo) {
        agregarPanelNuevo(new PanelEscanearQR());
    }

    public void abrirInformacionBoletoReagenda(JPanel panelNuevo, BoletoDTO boleto) {
        agregarPanelNuevo(new PanelInformacionBoletoReagenda(boleto));
    }

    public void abrirSeleccionFuncionReagenda(JPanel panelNuevo, PeliculaDTO pelicula, BoletoDTO boleto) {
        agregarPanelNuevo(new PanelSeleccionFuncionReagenda(pelicula, boleto));
    }

    public void abrirSeleccionAsientosReagenda(JPanel panelNuevo, FuncionDTO funcion, BoletoDTO boleto) {
        agregarPanelNuevo(new PanelSeleccionAsientosReagenda(funcion, boleto));
    }

    public void abrirInformacionReagenda(JPanel panelNuevo, BoletoDTO boleto, FuncionDTO funcion, List<AsientoDTO> asientos) {
        agregarPanelNuevo(new PanelInformacionReagenda(boleto, funcion, asientos));
    }

    public void abrirSeleccionPeliculasReporte(JPanel panelNuevo) {
        agregarPanelNuevo(new PanelSeleccionPeliculasReporte());
    }

    public void abrirFechasReporte(JPanel panelNuevo, PeliculaDTO peli) {
        agregarPanelNuevo(new PanelFechasReporte(peli));
    }

    public void abrirReportePelicula(JPanel panelNuevo, PeliculaDTO peli, LocalDate fechaDesde, LocalDate fechaHasta) {
        agregarPanelNuevo(new PanelReportePelicula(peli, fechaDesde, fechaHasta));
    }

    /**
     * Agregar el panel nuevo en el contenedor central correspondiente.
     *
     * @param nuevo Panel nuevo a establecer.
     */
    private void agregarPanelNuevo(JPanel nuevo) {
        JPanel centro = formPrincipal.getOpcMenu();
        centro.removeAll();
        centro.add(nuevo, BorderLayout.CENTER);
        centro.revalidate();
        centro.repaint();
    }

    /**
     * Carga el panel de la información contextual del empleado en el contenedor
     * lateral.
     */
    private void cargarPanelEmpleado(EmpleadoDTO empleado) {
        JPanel lateral = formPrincipal.getPanelEmpleado();
        lateral.removeAll();
        lateral.add(new PanelInformacionEmpleado(empleado));
        lateral.revalidate();
        lateral.repaint();
    }

    /**
     *
     */
    private void limpiarPanelEmpleado() {
        JPanel lateral = formPrincipal.getPanelEmpleado();
        lateral.removeAll();
        lateral.revalidate();
        lateral.repaint();
    }
}

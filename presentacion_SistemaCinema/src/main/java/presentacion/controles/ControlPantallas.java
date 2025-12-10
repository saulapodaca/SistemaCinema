package presentacion.controles;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import dto.AsientoDTO;
import dto.BoletoDTO;
import dto.ComboDTO;
import dto.FuncionDTO;
import dto.PeliculaDTO;
import dto.ReciboAlimentoDTO;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.ComboBoxEditor;
import javax.swing.JPanel;
import presentacion.FormPrincipal;
import presentacion.InicioSesionPanel;
import presentacion.PanelDetalleCombo;
import presentacion.PanelInformacionBoleto;
import presentacion.PanelInformacionEmpleado;
import presentacion.PanelInformacionPago;
import presentacion.PanelInformacionPagoCombo;
import presentacion.PanelInformacionRecibo;
import presentacion.PanelOpcionesMenuGerente;
import presentacion.PanelPersonalizacionBebida;
import presentacion.PanelPersonalizacionDulce;
import presentacion.PanelPersonalizacionPalomitas;
import presentacion.PanelSeleccionAsientos;
import presentacion.PanelSeleccionCombos;
import presentacion.PanelSeleccionFuncion;
import presentacion.PanelSeleccionPeliculas;

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
        formPrincipal.getContentPane().setLayout(new BorderLayout());
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

    
    public void abrirInicioSesion(){
        this.formPrincipal.getContentPane().removeAll();
        JPanel panelInicioSesion = new InicioSesionPanel();
        agregarPanelNuevo(panelInicioSesion);
        this.formPrincipal.setVisible(true);
        this.formPrincipal.setTitle("Inicio Sesion");
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
        this.formPrincipal.setTitle("Menú Principal");
    }

    /**
     * Abre la pantalla de selección de películas, reemplazando el panel del
     * menú
     *
     * @param panelAnterior El panel que debe ser removido antes de agregar el
     * nuevo
     */
    public void abrirSeleccionPeliculas() {
        JPanel panelNuevo = new PanelSeleccionPeliculas();
        agregarPanelNuevo(panelNuevo);
        this.formPrincipal.setTitle("Seleccion Peliculas");
    }

    public void abrirSeleccionFunciones(PeliculaDTO pelicula) {
        JPanel panelNuevo = new PanelSeleccionFuncion(pelicula);
        agregarPanelNuevo(panelNuevo);
        this.formPrincipal.setTitle("Seleccion Funciones");
    }
    
    public void abrirSeleccionAsientos(FuncionDTO funcion){
        JPanel panelNuevo = new PanelSeleccionAsientos(funcion);
        agregarPanelNuevo(panelNuevo);    
        this.formPrincipal.setTitle("Seleccion Asientos");

    }
    
    public void abrirInformacionPago(List<AsientoDTO> asientos, FuncionDTO funcion){
        JPanel panelNuevo = new PanelInformacionPago(asientos, funcion);
        agregarPanelNuevo(panelNuevo);   
        this.formPrincipal.setTitle("Informacion Pago");
    }
    
    public void abrirInformacionBoleto(BoletoDTO boleto){
        JPanel panelNuevo = new PanelInformacionBoleto(boleto);
        agregarPanelNuevo(panelNuevo);  
        this.formPrincipal.setTitle("Informacion Boleto");

    }
    
    public void abrirSeleccionCombos(){
        JPanel panelNuevo = new PanelSeleccionCombos();
        agregarPanelNuevo(panelNuevo);
        this.formPrincipal.setTitle("Seleccion de combos");
    }
    
    public void abrirDetalleCombo(ComboDTO combo){
        JPanel panelNuevo = new PanelDetalleCombo(combo);
        agregarPanelNuevo(panelNuevo);
        this.formPrincipal.setTitle("Detalle combo");
    }
    
    public void abrirPersonalizacionPalomitas(ComboDTO combo){
        JPanel panelNuevo = new PanelPersonalizacionPalomitas(combo);
        agregarPanelNuevo(panelNuevo);
        this.formPrincipal.setTitle("Personalizar Palomitas");
    }
  
    public void abrirPersonalizacionBebidas(ComboDTO combo){
        JPanel panelNuevo = new PanelPersonalizacionBebida(combo);
        agregarPanelNuevo(panelNuevo);
        this.formPrincipal.setTitle("Personalizacion Bebida");
    }
    
    public void abrirPersonalizacionDulce(ComboDTO combo){
        JPanel panelNuevo = new PanelPersonalizacionDulce(combo);
        agregarPanelNuevo(panelNuevo);
        this.formPrincipal.setTitle("Personalizacion Dulce");
    }
    
    public void abrirInformacionPagoCombo(ComboDTO combo){
        JPanel panelNuevo = new PanelInformacionPagoCombo(combo);
        agregarPanelNuevo(panelNuevo);
        this.formPrincipal.setTitle("Informacion Pago Combo");
    }
    
    public void abrirInformacionRecibo(ReciboAlimentoDTO recibo){
        JPanel panelNuevo = new PanelInformacionRecibo(recibo);
        agregarPanelNuevo(panelNuevo);
        this.formPrincipal.setTitle("Informacion Recibo");
    }
    
    private void agregarPanelNuevo(JPanel panelNuevo) {
        if (this.formPrincipal.getContentPane().getComponentCount() > 1) {

            this.formPrincipal.getContentPane().remove(1);
        }
        this.formPrincipal.getContentPane().add(panelNuevo, BorderLayout.CENTER);
        this.formPrincipal.revalidate();
        this.formPrincipal.repaint();
    }

}

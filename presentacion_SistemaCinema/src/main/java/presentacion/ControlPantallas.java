package presentacion;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import javax.swing.JPanel;


public class ControlPantallas {

    private static ControlPantallas instance;
    private final FormPrincipal formPrincipal;
    
    private ControlPantallas(){
        formPrincipal = new FormPrincipal();
    }
    
    public static ControlPantallas getInstance(){
        if (instance == null){
            instance = new ControlPantallas();
        }
        return instance;
    }
    
    public void abrirMenuPrincipal(){
        this.formPrincipal.getContentPane().removeAll();
        JPanel panelEmpleado = new PanelInformacionEmpleado();
        JPanel panelOpcionesGerente = new PanelOpcionesMenuGerente();
        this.formPrincipal.getContentPane().add(panelEmpleado);
        this.formPrincipal.getContentPane().add(panelOpcionesGerente);
        this.formPrincipal.revalidate();
        this.formPrincipal.repaint();
        this.formPrincipal.setVisible(true);
    }
    
    public void abrirSeleccionPeliculas(JPanel panelQuitar){
        this.formPrincipal.remove(panelQuitar);
        JPanel panelNuevo = new PanelSeleccionPeliculas();
        this.formPrincipal.getContentPane().add(panelNuevo);
        this.formPrincipal.revalidate();
        this.formPrincipal.repaint();
    }
}

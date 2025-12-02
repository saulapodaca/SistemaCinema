package presentacion.utilerias;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import dto.AsientoDTO;
import dto.enums.EstadoAsiento;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class PintorAsientos {

    private static final String URL_ASIENTO_DISPONIBLE = "/asientoDisponible.png";
    private static final String URL_ASIENTO_OCUPADO = "/asientoOcupado.png";
    private static final String URL_ASIENTO_SELECCIONADO = "/asientoSeleccionado.png";
    
    public static void aplicarEstilo(JToggleButton boton, EstadoAsiento estado) {
        configurarBoton(boton);
        switch (estado) {
            case DISPONIBLE -> {
                configurarImagenBoton(boton, URL_ASIENTO_DISPONIBLE);
                boton.setEnabled(true);
            }
            case APARTADO, OCUPADO -> {
                configurarImagenBoton(boton, URL_ASIENTO_OCUPADO);
                boton.setEnabled(false); // bloqueado para otros
            }
        }
    }

    private static void configurarImagenBoton(JToggleButton boton, String rutaImagen) {
        URL url = PintorAsientos.class.getResource(rutaImagen);
        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        boton.setIcon(new ImageIcon(img));
    }

    public static void aplicarSeleccion(JToggleButton boton, boolean seleccionado) {
        configurarBoton(boton);
        
        if (seleccionado) {
            configurarImagenBoton(boton, URL_ASIENTO_SELECCIONADO);
        } else {
            aplicarEstilo(boton, EstadoAsiento.DISPONIBLE);
        }
            boton.setEnabled(true);
    }
  
    private static void configurarBoton(JToggleButton boton) {
        boton.setContentAreaFilled(false);
        boton.setOpaque(true);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setHorizontalAlignment(SwingConstants.CENTER);

        boton.setBackground(new Color(18, 26, 60));
    }
}

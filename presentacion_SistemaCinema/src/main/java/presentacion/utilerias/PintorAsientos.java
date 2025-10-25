package presentacion.utilerias;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import dto.AsientoDTO;
import java.awt.Color;
import javax.swing.JToggleButton;

public class PintorAsientos {

    public static void aplicarEstilo(JToggleButton boton, AsientoDTO.Estado estado) {
        switch (estado) {
            case DISPONIBLE -> {
                boton.setBackground(new Color(20,60,156));
                boton.setEnabled(true);
            }
            case APARTADO -> {
                boton.setBackground(Color.YELLOW);
                boton.setEnabled(false); // bloqueado para otros
            }
            case OCUPADO -> {
                boton.setBackground(new Color(161,35,59));
                boton.setEnabled(false);
            }
        }
        boton.setContentAreaFilled(false);
        boton.setOpaque(true);
        boton.setBorderPainted(false);
    }

}

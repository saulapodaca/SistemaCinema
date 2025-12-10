package presentacion.utilerias;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardOpcion extends JPanel {

    private boolean seleccionado = false;
    private Runnable onClick;

    public CardOpcion(String nombre, double extra, String rutaImagen) {
        setPreferredSize(new Dimension(150, 150));
        setLayout(new BorderLayout());
        setBackground(new Color(10, 20, 40));
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        // Imagen
        JLabel lblImagen = new JLabel();
        lblImagen.setHorizontalAlignment(JLabel.CENTER);
        lblImagen.setIcon(new ImageIcon(new ImageIcon(rutaImagen)
                .getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        add(lblImagen, BorderLayout.CENTER);

        // Texto
        JPanel info = new JPanel(new GridLayout(2, 1));
        info.setOpaque(false);

        JLabel lblNombre = new JLabel(nombre, JLabel.CENTER);
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JLabel lblExtra = new JLabel(
                extra > 0 ? "+$" + extra : "$0.00",
                JLabel.CENTER
        );
        lblExtra.setForeground(new Color(130, 180, 255));
        lblExtra.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        info.add(lblNombre);
        info.add(lblExtra);

        add(info, BorderLayout.SOUTH);

        // Evento click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                seleccionar();
                if (onClick != null) {
                    onClick.run();
                }
            }
        });
    }

    public void setOnClick(Runnable r) {
        this.onClick = r;
    }

    public void seleccionar() {
        this.seleccionado = true;
        setBorder(BorderFactory.createLineBorder(new Color(30, 144, 255), 3));
    }

    public void deseleccionar() {
        this.seleccionado = false;
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
    }
}

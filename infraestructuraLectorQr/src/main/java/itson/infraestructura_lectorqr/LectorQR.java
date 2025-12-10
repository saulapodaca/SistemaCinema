/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.infraestructura_lectorqr;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import java.awt.image.BufferedImage;

/**
 *
 * @author Saul Isaac Apodaca Baldenegro - 00000252020
 * @author Alejandro Rodríguez Lugo - 00000251622
 * @author Héctor Javier Alonso Zaragoza - 00000252039
 */
public class LectorQR implements ILectorQR {

    @Override
    public String escanearQR(Webcam webcam) {
        try {
            while (true) {
                BufferedImage image = webcam.getImage();
                if (image != null) {
                    LuminanceSource source = new BufferedImageLuminanceSource(image);
                    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                    try {
                        Result result = new MultiFormatReader().decode(bitmap);
                        return result.getText();
                    } catch (Exception e) {
                    }
                }
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public WebcamPanel getPanelCamara() {
        Webcam webcam = Webcam.getDefault();
        if (webcam != null) {
            try {
                webcam.close();
            } catch (Exception e) {
            }
            webcam = null;
            System.gc();
        }
        webcam = Webcam.getDefault();
        if (webcam == null) {
            return null;
        }
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setMirrored(true);
        return panel;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.infraestructura_lectorqr;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

/**
 *
 * @author Alejandro Rodríguez Lugo - 00000251622
 */
public interface ILectorQR {

    public String escanearQR(Webcam webcam);

    public WebcamPanel getPanelCamara();

}

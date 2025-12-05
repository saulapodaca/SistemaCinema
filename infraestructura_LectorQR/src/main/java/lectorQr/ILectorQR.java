/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lectorQr;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

/**
 *
 * @author PC
 */
public interface ILectorQR {

    public String escanearQR(Webcam webcam);

    public WebcamPanel getPanelCamara();

}

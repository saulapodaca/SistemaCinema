package itson.negocios_generadorqr;

import itson.negocios_generadorqr.exceptions.QRGeneradorException;

/**
 * Interfaz que define el servicio para generar códigos QR dentro del sistema.
 * 
 * Las implementaciones deben encargarse de recibir un contenido de texto,
 * procesarlo y devolver la ruta donde se almacenó el código QR generado.
 */
public interface IGeneradorQR {
    /**
     * Genera un código QR a partir del contenido proporcionado y devuelve
     * la ruta donde quedó guardado el archivo PNG.
     *
     * @param contenido Texto que será codificado en el QR.
     * @return Ruta completa del archivo PNG generado.
     * @throws QRGeneradorException Si ocurre un error durante la generación.
     */
    String generarQR(String contenido) throws QRGeneradorException;
}

package itson.negocios_generadorqr.exceptions;

/**
 * Excepción personalizada utilizada para representar errores ocurridos
 * durante la generación o descarga de códigos QR.
 * 
 * Esta excepción permite identificar de forma clara problemas como
 * fallas de red, respuestas inválidas o errores al guardar la imagen.
 */
public class QRGeneradorException extends Exception{

    
    public QRGeneradorException() {
    }

    public QRGeneradorException(String message) {
        super(message);
    }

    public QRGeneradorException(String message, Throwable cause) {
        super(message, cause);
    }

    public QRGeneradorException(Throwable cause) {
        super(cause);
    }

    public QRGeneradorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

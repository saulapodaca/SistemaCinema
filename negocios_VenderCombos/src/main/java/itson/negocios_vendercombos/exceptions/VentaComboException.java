package itson.negocios_vendercombos.exceptions;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class VentaComboException extends Exception{

    public VentaComboException() {
    }

    public VentaComboException(String message) {
        super(message);
    }

    public VentaComboException(String message, Throwable cause) {
        super(message, cause);
    }

    public VentaComboException(Throwable cause) {
        super(cause);
    }

    public VentaComboException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

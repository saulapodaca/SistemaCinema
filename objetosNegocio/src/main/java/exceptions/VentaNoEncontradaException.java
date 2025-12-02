package exceptions;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class VentaNoEncontradaException extends Exception{

    public VentaNoEncontradaException() {
    }

    public VentaNoEncontradaException(String message) {
        super(message);
    }

    public VentaNoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public VentaNoEncontradaException(Throwable cause) {
        super(cause);
    }

    public VentaNoEncontradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

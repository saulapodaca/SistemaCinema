package exceptions;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class SucursalNoExistenteException extends Exception{

    public SucursalNoExistenteException() {
    }

    public SucursalNoExistenteException(String message) {
        super(message);
    }

    public SucursalNoExistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public SucursalNoExistenteException(Throwable cause) {
        super(cause);
    }

    public SucursalNoExistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

package exceptions;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class ComboException extends Exception{

    public ComboException() {
    }

    public ComboException(String message) {
        super(message);
    }

    public ComboException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComboException(Throwable cause) {
        super(cause);
    }

    public ComboException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

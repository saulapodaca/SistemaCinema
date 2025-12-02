package exceptions;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class SalaNoExistenteException extends Exception{

    public SalaNoExistenteException() {
    }

    public SalaNoExistenteException(String message) {
        super(message);
    }

    public SalaNoExistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public SalaNoExistenteException(Throwable cause) {
        super(cause);
    }

    public SalaNoExistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

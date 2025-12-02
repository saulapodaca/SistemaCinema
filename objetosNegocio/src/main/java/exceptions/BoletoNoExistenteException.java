package exceptions;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class BoletoNoExistenteException extends Exception{

    public BoletoNoExistenteException() {
    }

    public BoletoNoExistenteException(String message) {
        super(message);
    }

    public BoletoNoExistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoletoNoExistenteException(Throwable cause) {
        super(cause);
    }

    public BoletoNoExistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

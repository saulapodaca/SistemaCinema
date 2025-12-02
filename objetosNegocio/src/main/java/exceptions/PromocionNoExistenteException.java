package exceptions;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class PromocionNoExistenteException extends Exception{

    public PromocionNoExistenteException() {
    }

    public PromocionNoExistenteException(String message) {
        super(message);
    }

    public PromocionNoExistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public PromocionNoExistenteException(Throwable cause) {
        super(cause);
    }

    public PromocionNoExistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

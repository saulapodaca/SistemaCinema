package exceptions;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class PeliculaNoExistenteException extends Exception{

    public PeliculaNoExistenteException() {
    }

    public PeliculaNoExistenteException(String message) {
        super(message);
    }

    public PeliculaNoExistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public PeliculaNoExistenteException(Throwable cause) {
        super(cause);
    }

    public PeliculaNoExistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

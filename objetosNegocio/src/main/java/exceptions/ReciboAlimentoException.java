package exceptions;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class ReciboAlimentoException extends Exception{

    public ReciboAlimentoException() {
    }

    public ReciboAlimentoException(String message) {
        super(message);
    }

    public ReciboAlimentoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReciboAlimentoException(Throwable cause) {
        super(cause);
    }

    public ReciboAlimentoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

package exceptions;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class FuncionNoEncontradaException extends Exception{

    public FuncionNoEncontradaException() {
    }

    public FuncionNoEncontradaException(String message) {
        super(message);
    }

    public FuncionNoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public FuncionNoEncontradaException(Throwable cause) {
        super(cause);
    }

    public FuncionNoEncontradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

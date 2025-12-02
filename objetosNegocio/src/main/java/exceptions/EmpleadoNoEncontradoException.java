package exceptions;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class EmpleadoNoEncontradoException extends Exception{

    public EmpleadoNoEncontradoException() {
    }

    public EmpleadoNoEncontradoException(String message) {
        super(message);
    }

    public EmpleadoNoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmpleadoNoEncontradoException(Throwable cause) {
        super(cause);
    }

    public EmpleadoNoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}

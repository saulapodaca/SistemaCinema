package exceptions;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class SesionEmpleadoNoExistenteException extends Exception{

    public SesionEmpleadoNoExistenteException() {
    }

    public SesionEmpleadoNoExistenteException(String message) {
        super(message);
    }

    public SesionEmpleadoNoExistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public SesionEmpleadoNoExistenteException(Throwable cause) {
        super(cause);
    }

    public SesionEmpleadoNoExistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

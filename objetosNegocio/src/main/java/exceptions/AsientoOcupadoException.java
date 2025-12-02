package exceptions;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class AsientoOcupadoException extends Exception{

    public AsientoOcupadoException() {
    }

    public AsientoOcupadoException(String message) {
        super(message);
    }

    public AsientoOcupadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public AsientoOcupadoException(Throwable cause) {
        super(cause);
    }

    public AsientoOcupadoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

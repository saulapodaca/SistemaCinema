package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class ResultadoEnvioDTO {
    private boolean exitoso;
    private String mensajeError;

    public ResultadoEnvioDTO() {
    }

    public ResultadoEnvioDTO(boolean exitoso, String mensajeError) {
        this.exitoso = exitoso;
        this.mensajeError = mensajeError;
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public void setExitoso(boolean exitoso) {
        this.exitoso = exitoso;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
    
}

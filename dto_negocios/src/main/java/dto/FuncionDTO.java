package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
public class FuncionDTO {

    private String nombreSala;
    private String horaFuncion;
    private String tipoSala;

    public FuncionDTO(String nombreSala, String horaFuncion, String tipoSala) {
        this.nombreSala = nombreSala;
        this.horaFuncion = horaFuncion;
        this.tipoSala = tipoSala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public String getHoraFuncion() {
        return horaFuncion;
    }

    public String getTipoSala() {
        return tipoSala;
    }

}

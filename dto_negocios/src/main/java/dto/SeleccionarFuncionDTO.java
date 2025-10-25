package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class SeleccionarFuncionDTO {
    private PeliculaDTO pelicula;
    private SalaDTO sala;
    private String horaFuncion;
    private String tipoSala;

    public SeleccionarFuncionDTO(PeliculaDTO pelicula, SalaDTO sala, String horaFuncion, String tipoSala) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.horaFuncion = horaFuncion;
        this.tipoSala = tipoSala;
    }

    public PeliculaDTO getPelicula() {
        return pelicula;
    }

    public SalaDTO getSala() {
        return sala;
    }

    public String getHoraFuncion() {
        return horaFuncion;
    }

    public String getTipoSala() {
        return tipoSala;
    }
    
    
}

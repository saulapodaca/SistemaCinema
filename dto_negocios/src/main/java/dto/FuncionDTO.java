package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.util.ArrayList;
import java.util.List;

public class FuncionDTO {

    //cambiar cuando tengamos dominio
    private SalaDTO sala;
    //cambiar cuando tengamos dominio
    private PeliculaDTO pelicula;
    private String horaFuncion;
    private String tipoSala;
    private List<AsientoDTO> asientos;

    public FuncionDTO(SalaDTO sala, PeliculaDTO pelicula, String horaFuncion, String tipoSala) {
        this.sala = sala;
        this.pelicula = pelicula;
        this.horaFuncion = horaFuncion;
        this.tipoSala = tipoSala;
        this.asientos = new ArrayList<>();
        
        for (int f = 0; f < sala.getFilas(); f++){
            for (int c = 0; c < sala.getColumnas(); c++){
                asientos.add(new AsientoDTO(f, c, AsientoDTO.Estado.DISPONIBLE));
            }
        }
    }

    public SalaDTO getSala() {
        return sala;
    }

    public PeliculaDTO getPelicula() {
        return pelicula;
    }

    public String getHoraFuncion() {
        return horaFuncion;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public List<AsientoDTO> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<AsientoDTO> asientos) {
        this.asientos = asientos;
    }

}

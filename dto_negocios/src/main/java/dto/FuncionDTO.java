package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FuncionDTO {

    private String id;
    private SalaDTO sala;
    private PeliculaDTO pelicula;
    private String tipoSala;
    private List<AsientoDTO> asientos = new ArrayList<>();
    private LocalDateTime fechaHora;

    public FuncionDTO() {
    }

    public FuncionDTO(String id, SalaDTO sala, PeliculaDTO pelicula, String tipoSala, List<AsientoDTO> asientos, LocalDateTime fechaHora) {
        this.id = id;
        this.sala = sala;
        this.pelicula = pelicula;
        this.tipoSala = tipoSala;
        this.asientos = asientos;
        this.fechaHora = fechaHora;
    }

    public FuncionDTO(SalaDTO sala, PeliculaDTO pelicula, String tipoSala, List<AsientoDTO> asientos, LocalDateTime fechaHora) {
        this.sala = sala;
        this.pelicula = pelicula;
        this.tipoSala = tipoSala;
        this.asientos = asientos;
        this.fechaHora = fechaHora;
    }

    public FuncionDTO(String id, SalaDTO sala, PeliculaDTO pelicula, String tipoSala, LocalDateTime fechaHora) {
        this.id = id;
        this.sala = sala;
        this.pelicula = pelicula;
        this.tipoSala = tipoSala;
        this.fechaHora = fechaHora;
    }
    
    

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SalaDTO getSala() {
        return sala;
    }

    public void setSala(SalaDTO sala) {
        this.sala = sala;
    }

    public PeliculaDTO getPelicula() {
        return pelicula;
    }

    public void setPelicula(PeliculaDTO pelicula) {
        this.pelicula = pelicula;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public List<AsientoDTO> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<AsientoDTO> asientos) {
        this.asientos = asientos;
    }
    
}

package dominio;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

public class Funcion {

    private ObjectId id;
    private ObjectId peliculaId;
    private ObjectId salaId;
    private String tipoSala;
    private List<Asiento> asientos = new ArrayList<>();
    private Date fechaHora;

    public Funcion() {
    }

    public Funcion(ObjectId id, ObjectId peliculaId, ObjectId salaId, String tipoSala, List<Asiento> asientos, Date fechaHora) {
        this.id = id;
        this.peliculaId = peliculaId;
        this.salaId = salaId;
        this.tipoSala = tipoSala;
        this.asientos = asientos;
        this.fechaHora = fechaHora;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(ObjectId peliculaId) {
        this.peliculaId = peliculaId;
    }

    public ObjectId getSalaId() {
        return salaId;
    }

    public void setSalaId(ObjectId salaId) {
        this.salaId = salaId;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    
}

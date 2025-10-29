package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.util.Date;
import java.util.List;

public class VentaDTO {

    private String id;
    private FuncionDTO funcion;
    private List<AsientoDTO> asientos;
    private EmpleadoDTO empleado;
    private double total;
    private Date fecha;

    public VentaDTO(String id, FuncionDTO funcion, List<AsientoDTO> asientos, EmpleadoDTO empleado, double total) {
        this.id = id;
        this.funcion = funcion;
        this.asientos = asientos;
        this.empleado = empleado;
        this.total = total;
        this.fecha = new Date();
    }

    public String getId() {
        return id;
    }

    public FuncionDTO getFuncion() {
        return funcion;
    }

    public List<AsientoDTO> getAsientos() {
        return asientos;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public double getTotal() {
        return total;
    }

    public Date getFecha() {
        return fecha;
    }
    
}

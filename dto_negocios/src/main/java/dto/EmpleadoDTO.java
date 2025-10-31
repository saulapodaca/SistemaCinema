package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class EmpleadoDTO {

    private String id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String sucursal;
    private String ocupacion;
    private String urlFoto;

    public EmpleadoDTO(String id, String nombres, String apellidoPaterno, String apellidoMaterno, String sucursal, String ocupacion, String urlFoto) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sucursal = sucursal;
        this.ocupacion = ocupacion;
        this.urlFoto = urlFoto;
    }

    public EmpleadoDTO(String id, String nombres, String apellidoPaterno, String sucursal, String ocupacion, String urlFoto) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.sucursal = sucursal;
        this.ocupacion = ocupacion;
        this.urlFoto = urlFoto;
    }

    public String getId(){
        return id;
    }
    
    public String getNombres() {
        return nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getSucursal() {
        return sucursal;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public String getUrlFoto() {
        return urlFoto;
    }
    
}

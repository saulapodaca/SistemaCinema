package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.enums.TipoEmpleado;


public class EmpleadoDTO {

    private String id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private SucursalDTO sucursal;
    private String puesto;
    private String rutaImagen;
    private String usuario;
    private TipoEmpleado tipoEmpleado;

    public EmpleadoDTO(){
    }
    
    public EmpleadoDTO(String id, String nombres, String apellidoPaterno, String apellidoMaterno, SucursalDTO sucursal, String puesto, String rutaImagen, String usuario, TipoEmpleado tipoEmpleado) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sucursal = sucursal;
        this.puesto = puesto;
        this.rutaImagen = rutaImagen;
        this.usuario = usuario;
        this.tipoEmpleado = tipoEmpleado;
    }

    public EmpleadoDTO(String id, String nombres, String apellidoPaterno, SucursalDTO sucursal, String puesto, String rutaImagen, String usuario, TipoEmpleado tipoEmpleado) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.sucursal = sucursal;
        this.puesto = puesto;
        this.rutaImagen = rutaImagen;
        this.usuario = usuario;
        this.tipoEmpleado = tipoEmpleado;
    }

    public EmpleadoDTO(String nombres, String apellidoPaterno, SucursalDTO sucursal, String puesto, String rutaImagen, String usuario, TipoEmpleado tipoEmpleado) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.sucursal = sucursal;
        this.puesto = puesto;
        this.rutaImagen = rutaImagen;
        this.usuario = usuario;
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public SucursalDTO getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDTO sucursal) {
        this.sucursal = sucursal;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
    
}

package dominio;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.enums.TipoEmpleado;
import org.bson.types.ObjectId;


public class Empleado {
    
    private ObjectId id;
    private String usuario;
    private String contrasena;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String puesto;
    private ObjectId sucursalId;
    private String rutaImagen;
    private TipoEmpleado tipoEmpleado;

    public Empleado() {
    }

    public Empleado(ObjectId id, String usuario, String contrasena, String nombres, String apellidoPaterno, String apellidoMaterno, String puesto, ObjectId sucursalId, String rutaImagen, TipoEmpleado tipoEmpleado) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.puesto = puesto;
        this.sucursalId = sucursalId;
        this.rutaImagen = rutaImagen;
        this.tipoEmpleado = tipoEmpleado;
    }

    public Empleado(ObjectId id, String usuario, String contrasena, String nombres, String apellidoPaterno, String puesto, ObjectId sucursalId, String rutaImagen, TipoEmpleado tipoEmpleado) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.puesto = puesto;
        this.sucursalId = sucursalId;
        this.rutaImagen = rutaImagen;
        this.tipoEmpleado = tipoEmpleado;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public ObjectId getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(ObjectId sucursalId) {
        this.sucursalId = sucursalId;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
    
}

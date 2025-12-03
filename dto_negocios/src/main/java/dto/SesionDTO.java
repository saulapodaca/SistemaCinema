package dto;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class SesionDTO {

    private String usuario;
    private String contrasenaHash;
    private char[] contrasena;

    public SesionDTO() {
    }
    
    public SesionDTO(String usuario, char[] contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }

    public char[] getContrasena() {
        return contrasena;
    }

    public void setContrasena(char[] contrasena) {
        this.contrasena = contrasena;
    }
    
    
}

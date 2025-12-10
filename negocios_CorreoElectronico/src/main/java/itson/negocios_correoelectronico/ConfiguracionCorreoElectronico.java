/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.negocios_correoelectronico;

import java.util.Properties;

/**
 * Clase que establece la configuración para el correo electrónico.
 *
 * @author Alejandro Rodríguez Lugo - 00000251622
 */
public class ConfiguracionCorreoElectronico {

    private final String usuario;
    private final String contrasena;
    private final Properties props;

    /**
     * Realiza la configuración del correo electrónico: correo desde donde se
     * envia, contraseña de aplicaciones gmail correspondiente. A su vez, se
     * crea la propiedad SMTP y su configuración.
     */
    public ConfiguracionCorreoElectronico() {
        this.usuario = "sistemacinemac2@gmail.com";
        this.contrasena = "scut wfgb dtrc iueg";
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
    }

    /**
     * Regresa el usuario.
     *
     * @return Usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Regresa la contraseña de aplicación.
     *
     * @return Contraseña de aplicación.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Regresa las propiedades SMTP
     *
     * @return Propiedades SMTP.
     */
    public Properties getProps() {
        return props;
    }
}

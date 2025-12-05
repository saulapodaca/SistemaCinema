package itson.negocios_correoelectronico;

import dto.BoletoDTO;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Date;

/**
 * Implementación del servicio de envío de correos electrónicos utilizando el
 * protocolo SMTP
 *
 * @author Saul Isaac Apodaca Baldenegro - 00000252020
 * @author Alejandor Rodríguez Lugo - 00000251622
 */
public class CorreoElectronico implements ICorreoElectronico {

    private final ConfiguracionCorreoElectronico config;
    private final Session session;

    /**
     * Constructor inicializa la sesión SMTP utilizando la configuración
     * proporcionada.
     *
     * @param config Credenciales de la conexión SMTP y credenciales del
     * remitente.
     */
    public CorreoElectronico(ConfiguracionCorreoElectronico config) {
        this.config = config;
        session = Session.getInstance(config.getProps(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(config.getUsuario(), config.getContrasena());
            }
        });
    }

    /**
     * Envía un correo electrónico con el contenido y un archivo pdf adjunto.
     *
     * @param destino Dirección del destinatario.
     * @param asunto Asunto del correo electrónico.
     * @param mensajeHtml Contenido que formará el cuerpo del correo.
     * @param jasper Arreglo de bytes correspondiente al archivo pdf.
     * @throws Exception Si ocurre un error durante el proceso.
     */
    @Override
    public void enviarBoleto(String destino, String asunto, String mensajeHtml, byte[] jasper) throws Exception {
        Message mensaje = new MimeMessage(session);
        mensaje.setFrom(new InternetAddress(config.getUsuario()));
        mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
        mensaje.setSubject(asunto);
        mensaje.setSentDate(new Date());
        MimeBodyPart cuerpoHtml = new MimeBodyPart();
        cuerpoHtml.setContent(mensajeHtml, "text/html; charset=utf-8");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(cuerpoHtml);
        MimeBodyPart adjunto = new MimeBodyPart();
        adjunto.setFileName("Boleto.pdf");
        adjunto.setContent(jasper, "application/pdf");
        multipart.addBodyPart(adjunto);
        mensaje.setContent(multipart);
        Transport.send(mensaje);
    }
}

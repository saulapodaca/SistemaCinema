package itson.negocios_generadorqr;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import itson.negocios_generadorqr.exceptions.QRGeneradorException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Implementación del servicio encargado de generar códigos QR utilizando
 * la API pública de QRCode Monkey. 
 * 
 * Esta clase se encarga de construir la petición, enviarla, procesar la 
 * respuesta y descargar la imagen generada.
 */
public class GeneradorQR implements IGeneradorQR {

    private static final String ENDPOINT = "https://api.qrcode-monkey.com/qr/custom";
    private static final String CARPETA_QR = "C:\\Users\\saula\\OneDrive\\Documentos\\NetBeansProjects\\SistemaCinema\\presentacion_SistemaCinema\\target\\classes\\ImagenesQr\\";

    /**
     * Genera un código QR a partir del contenido proporcionado.
     * 
     * @param contenido Texto que se desea codificar en el QR.
     * @return Ruta del archivo PNG generado.
     * @throws QRGeneradorException Si ocurre un error durante la generación.
     */
    @Override
    public String generarQR(String contenido) throws QRGeneradorException {
        try {
            String json = construirJson(contenido);
            HttpRequest request = construirRequest(json);
            HttpResponse<String> response = enviarRequest(request);
            validarResponse(response);
            String finalUrl = extraerUrlQR(response.body());
            return descargarQR(contenido, finalUrl);

        } catch (QRGeneradorException | IOException | InterruptedException ex) {
            throw new QRGeneradorException("Error generando el QR: " + ex.getMessage());
        }
    }

    /**
     * Construye el cuerpo JSON que será enviado a la API.
     *
     * @param contenido Datos a codificar en el QR.
     * @return Cadena JSON lista para enviar.
     */
    private String construirJson(String contenido) {
        return """
        {
          "data": "%s",
          "config": {
            "body": "circle"
          },
          "size": 300,
          "download": true,
          "file": "png"
        }
        """.formatted(contenido);
    }

    /**
     * Construye la petición HTTP POST hacia el endpoint de QRCode Monkey.
     *
     * @param body Cuerpo JSON de la petición.
     * @return Objeto HttpRequest configurado.
     */
    private HttpRequest construirRequest(String body) {
        return HttpRequest.newBuilder()
                .uri(URI.create(ENDPOINT))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
    }

    /**
     * Envía la petición HTTP a la API y obtiene la respuesta.
     *
     * @param request Petición previamente construida.
     * @return Respuesta HTTP.
     * @throws IOException Si falla la conexión.
     * @throws InterruptedException Si la ejecución es interrumpida.
     */
    private HttpResponse<String> enviarRequest(HttpRequest request)
            throws IOException, InterruptedException {

        return HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * Valida que la respuesta de la API sea correcta.
     *
     * @param response Respuesta HTTP recibida.
     * @throws QRGeneradorException Si el código HTTP no es 200
     *         o si el cuerpo está vacío.
     */
    private void validarResponse(HttpResponse<String> response)
            throws QRGeneradorException {

        if (response.statusCode() != 200) {
            throw new QRGeneradorException(
                    "Error HTTP al generar QR (status " + response.statusCode() + ")");
        }

        if (response.body() == null || response.body().isBlank()) {
            throw new QRGeneradorException("La API devolvió un body vacío.");
        }
    }

    /**
     * Extrae la URL de la imagen PNG contenida en la respuesta JSON.
     *
     * @param body Cuerpo JSON de la respuesta.
     * @return URL final para descargar el QR.
     * @throws QRGeneradorException Si no existe el campo imageUrl.
     */
    private String extraerUrlQR(String body) throws QRGeneradorException {
        JsonObject json = JsonParser.parseString(body).getAsJsonObject();

        if (!json.has("imageUrl")) {
            throw new QRGeneradorException("La API no regresó el campo 'imageUrl'.");
        }

        String imageUrl = json.get("imageUrl").getAsString();
        imageUrl = imageUrl.replace("/api.qrcode-monkey.com", "");

        return "https://api.qrcode-monkey.com" + imageUrl;
    }

    /**
     * Descarga el archivo PNG desde la URL generada y lo guarda localmente.
     *
     * @param nombreArchivo Nombre base del archivo a guardar.
     * @param finalUrl URL desde donde se descargará la imagen.
     * @return Ruta completa donde se guardó el archivo.
     * @throws QRGeneradorException Si ocurre un error al descargar o guardar.
     */
    private String descargarQR(String nombreArchivo, String finalUrl)
            throws QRGeneradorException {

        try (InputStream in = new URL(finalUrl).openStream()) {

            Files.createDirectories(Paths.get(CARPETA_QR));

            String rutaFinal = CARPETA_QR + nombreArchivo + ".png";
            Files.copy(in, Paths.get(rutaFinal), StandardCopyOption.REPLACE_EXISTING);

            return rutaFinal;

        } catch (Exception ex) {
            throw new QRGeneradorException("Error al descargar el QR desde " + finalUrl, ex);
        }
    }

}

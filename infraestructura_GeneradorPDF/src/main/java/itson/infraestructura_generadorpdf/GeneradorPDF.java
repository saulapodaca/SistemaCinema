/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.infraestructura_generadorpdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import conexion.ManejadorConexion;
import dominio.Boleto;
import dto.BoletoDTO;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class GeneradorPDF implements IGeneradorPDF {

    public GeneradorPDF() {
    }

    public byte[] generarPDFBoleto(BoletoDTO boleto) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, baos);
        document.open();
        Font titulo = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD);
        document.add(new Paragraph("Boleto de Cine", titulo));
        document.add(new Paragraph("Película: " + boleto.getVenta().getFuncion().getPelicula().getTitulo()));
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha = boleto.getVenta().getFuncion().getFechaHora().format(fmt);
        document.add(new Paragraph("Fecha: " + fecha));
        document.add(new Paragraph("Idioma: " + boleto.getVenta().getFuncion().getPelicula().getIdioma()));
        document.add(new Paragraph("Sala: " + boleto.getVenta().getFuncion().getSala().getNombre()));
        String asientos = String.join(", ", boleto.getVenta().getAsientos().stream().map(Object::toString).toList());
        document.add(new Paragraph("Asientos: " + asientos));
        String rutaImagenPelicula = boleto.getVenta().getFuncion().getPelicula().getRutaImagen();
        if (rutaImagenPelicula != null && !rutaImagenPelicula.isBlank()) {
            URL url = Thread.currentThread().getContextClassLoader().getResource("ImagenesPeliculas/spiderman.png");
            if (url == null) {
                throw new RuntimeException("No se encontró la imagen en resources");
            }
            Image imgPelicula = Image.getInstance(url);
            imgPelicula.scaleToFit(150, 150);
            imgPelicula.setAlignment(Image.ALIGN_CENTER);
            document.add(imgPelicula);
        }
        String rutaQr = boleto.getRutaQr();
        if (rutaQr != null && !rutaQr.isBlank()) {
            Image qrImage = Image.getInstance(rutaQr);
            qrImage.scaleToFit(150, 150);
            qrImage.setAlignment(Image.ALIGN_CENTER);
            document.add(qrImage);
        }
        document.close();
        return baos.toByteArray();
    }
}

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
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class GeneradorPDF implements IGeneradorPDF {

    private final MongoCollection<org.bson.Document> coleccion;
    private final MongoCollection<org.bson.Document> coleccionV;
    private final MongoCollection<org.bson.Document> coleccionF;
    private final MongoCollection<org.bson.Document> coleccionP;
    private final MongoCollection<org.bson.Document> coleccionS;

    public GeneradorPDF(MongoCollection<org.bson.Document> coleccion) {
        MongoDatabase db = ManejadorConexion.getInstancia().getBaseDatos();
        this.coleccion = db.getCollection("boletos", org.bson.Document.class);
        this.coleccionV = db.getCollection("ventas", org.bson.Document.class);
        this.coleccionF = db.getCollection("funciones", org.bson.Document.class);
        this.coleccionP = db.getCollection("peliculas", org.bson.Document.class);
        this.coleccionS = db.getCollection("salas", org.bson.Document.class);
    }

    public byte[] generarPDFBoleto(String idBoleto) throws Exception {
        org.bson.Document boleto = coleccion.find(Filters.eq("_id", new ObjectId(idBoleto))).first();
        if (boleto == null) {
            System.out.println("No existe el boleto.");
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, baos);
        document.open();
        Font titulo = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD);
        document.add(new Paragraph("Boleto de Cine", titulo));
        ObjectId ventaId = boleto.getObjectId("ventaId");
        org.bson.Document venta = coleccionV.find(Filters.eq("_id", ventaId)).first();
        ObjectId funcionId = venta.getObjectId("funcionId");
        org.bson.Document funcion = coleccionF.find(Filters.eq("_id", funcionId)).first();
        ObjectId peliculaId = funcion.getObjectId("peliculaId");
        org.bson.Document pelicula = coleccionP.find(Filters.eq("_id", peliculaId)).first();
        ObjectId salaId = funcion.getObjectId("salaId");
        org.bson.Document sala = coleccionS.find(Filters.eq("_id", salaId)).first();
        document.add(new Paragraph("Película: " + pelicula.getString("titulo")));
        Date fecha = funcion.getDate("fechaHora");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        String fechaFormateada = fecha != null ? formatoFecha.format(fecha) : "";
        String horaFormateada = fecha != null ? formatoHora.format(fecha) : "";
        String fechaYHora = fechaFormateada + " " + horaFormateada;
        document.add(new Paragraph("Fecha: " + fechaYHora));
        document.add(new Paragraph("Idioma: " + pelicula.getString("idioma")));
        document.add(new Paragraph("Sala: " + sala.getString("nombre")));
        List<org.bson.Document> asientos = (List<org.bson.Document>) venta.get("asientos");
        StringBuilder sbAsientos = new StringBuilder();
        if (asientos != null) {
            for (org.bson.Document a : asientos) {
                String nombre = a.getString("nombre");
                sbAsientos.append(nombre).append("  ");
            }
        }
        document.add(new Paragraph("Asientos: " + sbAsientos.toString()));
        String rutaImagenPelicula = pelicula.getString("rutaImagen");
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
        String rutaQr = boleto.getString("rutaQr");
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

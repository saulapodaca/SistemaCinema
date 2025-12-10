/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.infraestructura_generadorpdf;

import bos.VentaBO;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dto.BoletoDTO;
import dto.PeliculaDTO;
import dto.VentaDTO;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alejandro Rodríguez Lugo - 00000251622
 */
public class GeneradorPDF implements IGeneradorPDF {

    /**
     * Constructor vacio de generador pdf.
     */
    public GeneradorPDF() {
    }

    /**
     *
     * @param boleto
     * @return
     * @throws Exception
     */
    @Override
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
        String rutaImagen = boleto.getVenta().getFuncion().getPelicula().getRutaImagen();
        if (rutaImagen != null && !rutaImagen.isBlank()) {
            URL url = getClass().getResource("/ImagenesPeliculas/" + rutaImagen);
            if (url == null) {
                throw new RuntimeException("No se encontró la imagen en resources: " + "/ImagenesPeliculas/" + rutaImagen);
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

    @Override
    public byte[] generarPDFPelicula(PeliculaDTO peliculaDTO, LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, baos);
        document.open();
        Font titulo = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD);
        document.add(new Paragraph("Reporte de película " + peliculaDTO.getTitulo(), titulo));
        String rutaImagen = peliculaDTO.getRutaImagen();
        if (rutaImagen != null && !rutaImagen.isBlank()) {
            URL url = getClass().getResource("/ImagenesPeliculas/" + rutaImagen);
            if (url == null) {
                throw new RuntimeException("No se encontró la imagen en resources");
            }
            Image imgPelicula = Image.getInstance(url);
            imgPelicula.scaleToFit(150, 150);
            imgPelicula.setAlignment(Image.ALIGN_CENTER);
            document.add(imgPelicula);
        }
        List<VentaDTO> lista = VentaBO.getInstancia().obtenerVentasPorPelicula(peliculaDTO);
        List<VentaDTO> filtradas = lista.stream()
                .filter(v -> v.getFecha() != null)
                .filter(v -> {
                    if (fechaInicio == null || fechaFin == null) {
                        return true;
                    }
                    LocalDate f = v.getFecha();
                    return !f.isBefore(fechaInicio) && !f.isAfter(fechaFin);
                })
                .toList();
        double totalVenta = 0;
        for (VentaDTO lis : filtradas) {
            document.add(new Paragraph("Venta: " + lis.getTotal()));
            document.add(new Paragraph("Empleado: " + lis.getEmpleado().getNombres() + " " + lis.getEmpleado().getApellidoPaterno() + " " + lis.getEmpleado().getApellidoMaterno()));
            document.add(new Paragraph("Forma de pago: " + lis.getFormaPago()));
            document.add(new Paragraph("--------------------------"));
            totalVenta += lis.getTotal();
        }
        document.add(new Paragraph("Ganancias totales: $" + totalVenta));
        document.close();
        return baos.toByteArray();
    }

}

package itson.negocios_generadorqr;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class GeneradorQR implements IGeneradorQR{

    @Override
    public String generarQR(String contenido) {
         System.out.println("Generado QR para contenido: " + contenido);
         return null;
    }

}

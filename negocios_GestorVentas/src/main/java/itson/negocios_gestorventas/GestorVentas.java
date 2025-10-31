package itson.negocios_gestorventas;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.AsientoDTO;
import dto.DetallePrecioDTO;
import dto.EmpleadoDTO;
import dto.FuncionDTO;
import dto.PeliculaDTO;
import dto.PromocionDTO;
import dto.SalaDTO;
import dto.VentaDTO;
import java.util.Arrays;
import java.util.List;

public class GestorVentas implements IGestorVentas {

    private final double PRECIO_BOLETO = 70.00;

    @Override
    public VentaDTO registrarVenta(VentaDTO venta) {
        double costo = venta.getAsientos().size() * PRECIO_BOLETO;

        if (venta.getPromocion() != null) {
            costo = costo * (1 - venta.getPromocion().getDescuento());
        }
        venta.setTotal(costo);
        return venta;
    }

    @Override
    public VentaDTO obtenerVentaPorID(String id) {
        FuncionDTO funcion = new FuncionDTO(
                new SalaDTO("Sala 1", 5, 5),
                new PeliculaDTO("1", "Spiderman", "/spiderman.png", "180min", "Doblada"),
                "12:30",
                "Tradicional",
                new java.util.Date()
        );

        List<AsientoDTO> asientosSeleccionados = Arrays.asList(
                new AsientoDTO(0, 0, AsientoDTO.Estado.OCUPADO),
                new AsientoDTO(0, 1, AsientoDTO.Estado.OCUPADO)
        );

        EmpleadoDTO empleado = new EmpleadoDTO( "1",
                "Saul",
                "Apoadca",
                "Nainari",
                "Gerente",
                "/fotoDefault.png"
        );

        double costo = asientosSeleccionados.size() * 100.0;
        VentaDTO venta = new VentaDTO();
        return venta;
    }
    
    @Override
    public DetallePrecioDTO calcularPrecios(List<AsientoDTO> asientos, PromocionDTO promo){
        double subtotal = asientos.size()*PRECIO_BOLETO;
        double descuento = 0;
        if (promo != null){
            descuento = subtotal*promo.getDescuento();
        }
        
        double total = subtotal - descuento;
        return new DetallePrecioDTO(subtotal, descuento, total);
    }
}

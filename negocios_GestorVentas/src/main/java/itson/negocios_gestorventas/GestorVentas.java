package itson.negocios_gestorventas;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dto.AsientoDTO;
import dto.EmpleadoDTO;
import dto.FuncionDTO;
import dto.MembresiaDTO;
import dto.PeliculaDTO;
import dto.PromocionDTO;
import dto.SalaDTO;
import dto.VentaDTO;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class GestorVentas implements IGestorVentas {

    private final double PRECIO_BOLETO = 70.00;

    @Override
    public VentaDTO registrarVenta(FuncionDTO funcion, List<AsientoDTO> asientos, EmpleadoDTO empleado, MembresiaDTO membresia, PromocionDTO promoSeleccionada) {
        double costo = asientos.size() * PRECIO_BOLETO;

        if (membresia != null && membresia.isActiva() && promoSeleccionada != null) {
            costo = costo * (1 - promoSeleccionada.getDescuento());
        }

        return new VentaDTO(UUID.randomUUID().toString(), funcion, asientos, empleado, costo);
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

        EmpleadoDTO empleado = new EmpleadoDTO(
                "Saul",
                "Apoadca",
                "Nainari",
                "Gerente",
                "/fotoDefault.png"
        );

        double costo = asientosSeleccionados.size() * 100.0; // mock precio unitario
        VentaDTO venta = new VentaDTO(
                "VENTA0001",
                funcion,
                asientosSeleccionados,
                empleado,
                costo
        );
        return venta;
    }
}

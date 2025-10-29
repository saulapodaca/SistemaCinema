package itson.negocios_venderboleto;

import dto.AsientoDTO;
import dto.BoletoDTO;
import dto.EmpleadoDTO;
import dto.FuncionDTO;
import dto.MembresiaDTO;
import dto.PromocionDTO;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author saula
 */
public interface IVentaBoleto {

    BoletoDTO venderBoleto(FuncionDTO funcion,
            List<AsientoDTO> asientosSeleccionados,
            EmpleadoDTO empleado,
            MembresiaDTO membresia,
            PromocionDTO promoSeleccionada);

    void mandarBoletoCorreo(BoletoDTO boleto, String correo);
}

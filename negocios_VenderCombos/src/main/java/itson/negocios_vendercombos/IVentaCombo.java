/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.negocios_vendercombos;

import dto.ReciboAlimentoDTO;
import dto.VentaAlimentoDTO;
import itson.negocios_vendercombos.exceptions.VentaComboException;

/**
 *
 * @author saula
 */
public interface IVentaCombo {

    public ReciboAlimentoDTO venderCombo(VentaAlimentoDTO venta) throws VentaComboException;

    void mandarBoletoCorreoAlimento(ReciboAlimentoDTO recibo, String correo);
}

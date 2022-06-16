/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.ucs.meraki.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author BRITNEY
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Detalle {
    private int iddetalle;
    private int idproducto;
    private int idcliente;
    private int cantidad;
    private double costounitario;
    private double importe;
}

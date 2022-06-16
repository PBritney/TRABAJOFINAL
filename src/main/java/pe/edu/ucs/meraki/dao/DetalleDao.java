/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.ucs.meraki.dao;

import java.util.List;
import pe.edu.ucs.meraki.model.Detalle;

/**
 *
 * @author BRITNEY
 */
public interface DetalleDao {
    int create(Detalle det);
    int update(Detalle det);
    int delete(int id);
    Detalle read(int id);
    List<Detalle> readAll();
}

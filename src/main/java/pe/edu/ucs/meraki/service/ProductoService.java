/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.ucs.meraki.service;

import java.util.List;
import pe.edu.ucs.meraki.model.Producto;

/**
 *
 * @author Hennessy
 */
public interface ProductoService {
    int create(Producto pro);
    int update(Producto pro);
    int delete(int id);
    Producto read(int id);
    List<Producto> readAll();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.ucs.meraki.service;

import java.util.List;
import pe.edu.ucs.meraki.model.Empleado;

/**
 *
 * @author Hennessy
 */
public interface EmpleadoService {
    int create(Empleado emp);
    int update(Empleado emp);
    int delete(int id);
    Empleado read(int id);
    List<Empleado> readAll();
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.ucs.meraki.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.ucs.meraki.dao.EmpleadoDao;
import pe.edu.ucs.meraki.model.Empleado;
import pe.edu.ucs.meraki.service.EmpleadoService;

@Repository
public class EmpleadoServiceImpl  implements EmpleadoService{
@Autowired
    private EmpleadoDao empleadoDao;
    @Override
    public int create(Empleado emp) {
        return empleadoDao.create(emp);
    }

    @Override
    public int update(Empleado emp) {
        return empleadoDao.update(emp);
    }

    @Override
    public int delete(int id) {
        return empleadoDao.delete(id);
    }

    @Override
    public Empleado read(int id) {
        return empleadoDao.read(id);
    }

    @Override
    public List<Empleado> readAll() {
        return empleadoDao.readAll();
    }
    
}
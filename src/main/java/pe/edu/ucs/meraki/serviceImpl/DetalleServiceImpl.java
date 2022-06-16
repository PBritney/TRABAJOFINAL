/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.ucs.meraki.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.ucs.meraki.dao.DetalleDao;
import pe.edu.ucs.meraki.model.Detalle;
import pe.edu.ucs.meraki.service.DetalleService;

/**
 *
 * @author BRITNEY
 */
@Repository
public class DetalleServiceImpl implements DetalleService{
    @Autowired
    private DetalleDao detalleDao;
    
    @Override
    public int create(Detalle det) {
        return detalleDao.create(det);
    }

    @Override
    public int update(Detalle det) {
        return detalleDao.update(det);
    }

    @Override
    public int delete(int id) {
        return detalleDao.delete(id);
    }

    @Override
    public Detalle read(int id) {
        return detalleDao.read(id);
    }

    @Override
    public List<Detalle> readAll() {
        return detalleDao.readAll();
    }
    
}

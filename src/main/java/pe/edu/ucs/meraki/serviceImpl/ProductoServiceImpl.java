/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.ucs.meraki.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.ucs.meraki.dao.ProductoDao;
import pe.edu.ucs.meraki.model.Producto;
import pe.edu.ucs.meraki.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    public int create(Producto pro) {
        return productoDao.create(pro);
    }

    @Override
    public int update(Producto pro) {
        return productoDao.update(pro);
    }

    @Override
    public int delete(int id) {
        return productoDao.delete(id);
    }

    @Override
    public Producto read(int id) {
        return productoDao.read(id);
    }

    @Override
    public List<Producto> readAll() {
        return productoDao.readAll();
    }
    
} 
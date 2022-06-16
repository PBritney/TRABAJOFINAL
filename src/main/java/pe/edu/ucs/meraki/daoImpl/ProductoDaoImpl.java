/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.ucs.meraki.daoImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.edu.ucs.meraki.dao.ProductoDao;
import pe.edu.ucs.meraki.model.Producto;


@Repository
public class ProductoDaoImpl implements ProductoDao {
    @Autowired//para traer la conexion
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int create(Producto pro) {
        String SQL="INSERT INTO producto(nombre,precio) VALUES(?,?)";
        return jdbcTemplate.update(SQL, new Object[]{pro.getNombre(),pro.getPrecio()});
    }

    @Override
    public int update(Producto pro) {
        String SQL ="UPDATE producto SET nombre=?, precio=? WHERE idproducto=?";                 
        return jdbcTemplate.update(SQL,new Object[]{pro.getNombre(),pro.getPrecio(),pro.getIdproducto()});
    }

    @Override
    public int delete(int id) {
        String SQL ="DELETE FROM producto WHERE idproducto=?"; 
        return jdbcTemplate.update(SQL,id);       
    }

    @Override
    public Producto read(int id) {
            String SQL ="SELECT * FROM producto WHERE idproducto=?";
        try {
            Producto pro = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Producto.class),id);
            return pro;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Producto> readAll() {
        String SQL ="SELECT idproducto,nombre,precio FROM producto";        
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Producto.class));
    }
    
}


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
import pe.edu.ucs.meraki.dao.DetalleDao;
import pe.edu.ucs.meraki.model.Detalle;


/**
 *
 * @author BRITNEY
 */
@Repository
public class DetalleDaoImpl implements DetalleDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public int create(Detalle det) {
        String SQL = "INSERT INTO detalle(idproducto, idcliente, cantidad,costounitario,importe) VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{det.getIdproducto(),det.getIdcliente(),det.getCantidad(),det.getCostounitario(),det.getImporte()});
    }

    @Override
    public int update(Detalle det) {
        String SQL = "UPDATE detalle SET idproducto=?, idcliente=?, cantidad=?, costounitario=?,importe=? WHERE iddetalle=?";
        return jdbcTemplate.update(SQL, new Object[]{det.getIdproducto(),det.getIdcliente(),det.getCantidad(),det.getCostounitario(),det.getImporte(),det.getIddetalle()});
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM detalle WHERE iddetalle=?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public Detalle read(int id) {
        String SQL = "SELECT *FROM detalle WHERE iddetalle=?";
        try {
            Detalle det = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Detalle.class), id);
            return det;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Detalle> readAll() {
        String SQL="select * from detalle";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Detalle.class));
    }
    
}

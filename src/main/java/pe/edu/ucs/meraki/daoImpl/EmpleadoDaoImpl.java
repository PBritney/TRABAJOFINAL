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
import pe.edu.ucs.meraki.dao.EmpleadoDao;
import pe.edu.ucs.meraki.model.Empleado;

@Repository
public class EmpleadoDaoImpl implements EmpleadoDao {
  @Autowired
    private JdbcTemplate jdbcTemplate;
         
    @Override
    public int create(Empleado emp) {
        String SQL = "INSERT INTO empleado(nombres, dni, sueldo, cargo, telefono, direccion) VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{emp.getNombres(), emp.getDni(), emp.getSueldo(), emp.getCargo(), emp.getTelefono(), emp.getDireccion()});
    }
  

    @Override
    public int update(Empleado emp) {

        String SQL = "UPDATE empleado SET nombres=?, dni=?, sueldo=?, cargo=?, telefono=?, direccion=? WHERE idempleado=?";
        return jdbcTemplate.update(SQL, new Object[]{emp.getNombres(), emp.getDni(), emp.getSueldo(), emp.getCargo(), emp.getTelefono(), emp.getDireccion(), emp.getIdempleado()});
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM empleado WHERE idempleado=?";
        return jdbcTemplate.update(SQL, id);
    }

    @Override
    public Empleado read(int id) {
        String SQL = "SELECT *FROM empleado WHERE idempleado=?";
        try {
            Empleado empleado = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Empleado.class), id);
            return empleado;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Empleado> readAll() {
        return jdbcTemplate.query("select idempleado,nombres,dni,sueldo,cargo,telefono,direccion from empleado", BeanPropertyRowMapper.newInstance(Empleado.class));
    }
}

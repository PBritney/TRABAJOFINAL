package pe.edu.ucs.meraki.daoImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pe.edu.ucs.meraki.dao.PostDao;
import pe.edu.ucs.meraki.model.Post;


/**
 *
 * @author admin
 */
@Repository
public class PostDaoImpl implements PostDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(Post cliente) {
        String SQL ="INSERT INTO cliente(nombre,dni,telefono) VALUES(?,?,?)";
        return jdbcTemplate.update(SQL,new Object[]{cliente.getNombre(),cliente.getDni(),cliente.getTelefono()});
    }

    @Override
    public int update(Post cliente) {
        String SQL ="UPDATE cliente SET nombre=?,dni=?,telefono=? WHERE idcliente=?";                 
        return jdbcTemplate.update(SQL,new Object[]{cliente.getNombre(),cliente.getDni(),cliente.getTelefono(), cliente.getIdcliente()});
    }

    @Override
    public int delete(int id) {
        String SQL ="DELETE FROM cliente WHERE idcliente=?"; 
        return jdbcTemplate.update(SQL,id);
        
    }

    @Override
    public Post read(int id) {
        String SQL ="SELECT * FROM cliente WHERE idcliente=?";
        try {
            Post cliente = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Post.class),id);
            return cliente;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Post> readAll() {
        String SQL ="SELECT idcliente, nombre, dni, telefono FROM cliente ORDER BY idcliente ASC";        
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Post.class));
    }
    
}

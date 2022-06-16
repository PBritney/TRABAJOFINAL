
package pe.edu.ucs.meraki.dao;

import java.util.List;
import pe.edu.ucs.meraki.model.Producto;


public interface ProductoDao {
    int create(Producto pro);
    int update(Producto pro);
    int delete(int id);
    Producto read(int id);
    List<Producto> readAll();

    
}

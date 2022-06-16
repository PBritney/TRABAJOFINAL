package pe.edu.ucs.meraki.dao;


import java.util.List;
import pe.edu.ucs.meraki.model.Post;



/**
 *
 * @author admin
 */
public interface PostDao {
    int create(Post cliente);
    int update(Post cliente);
    int delete(int id);
    Post read(int id);
    List<Post> readAll();
}

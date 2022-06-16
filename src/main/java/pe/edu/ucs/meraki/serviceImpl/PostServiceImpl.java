/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.ucs.meraki.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.ucs.meraki.dao.PostDao;
import pe.edu.ucs.meraki.model.Post;
import pe.edu.ucs.meraki.service.PostService;

/**
 *
 * @author admin
 */
@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostDao postDao;
    @Override
    public int create(Post cliente) {
        return postDao.create(cliente);
    }

    @Override
    public int update(Post cliente) {
        return postDao.update(cliente);
    }

    @Override
    public int delete(int id) {
        return postDao.delete(id);
    }

    @Override
    public Post read(int id) {
        return postDao.read(id);
    }

    @Override
    public List<Post> readAll() {
        return postDao.readAll();
    }
    
}

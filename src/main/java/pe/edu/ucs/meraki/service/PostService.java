/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.ucs.meraki.service;

import java.util.List;
import pe.edu.ucs.meraki.model.Post;

/**
 *
 * @author admin
 */
public interface PostService {
    int create(Post cliente);
    int update(Post cliente);
    int delete(int id);
    Post read(int id);
    List<Post> readAll();
}

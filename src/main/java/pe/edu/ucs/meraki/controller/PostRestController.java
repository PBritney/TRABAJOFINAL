/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.ucs.meraki.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.ucs.meraki.model.Post;
import pe.edu.ucs.meraki.service.PostService;

/**
 *
 * @author admin
 */
@RestController
@RequestMapping("/cliente")
public class PostRestController {

    @Autowired
    private PostService postService;

    @GetMapping("/all")
    public List<Post> getPosts() {
        return postService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable int id) {
        Post cliente = postService.read(id);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public int deletePost(@PathVariable int id) {        
        return postService.delete(id);
    }
    @PostMapping("/add")
    public int addPost(@RequestBody Post cliente) {  
        System.out.println(cliente.getNombre());
        System.out.println(cliente.getDni());
        System.out.println(cliente.getTelefono());
        
       return postService.create(cliente);
    }
    @PutMapping("/edit")
    public int editPost(@RequestBody Post cliente) {  
        Post clie = new Post(cliente.getIdcliente(),cliente.getNombre(), cliente.getDni(), cliente.getTelefono());
        System.out.println(cliente.getIdcliente()+" , "+cliente.getNombre()+" , "+cliente.getDni()+" , "+cliente.getTelefono());
        return postService.update(cliente);
    }
}

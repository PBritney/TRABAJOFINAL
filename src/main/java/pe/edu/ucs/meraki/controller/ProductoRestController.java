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
import pe.edu.ucs.meraki.model.Producto;
import pe.edu.ucs.meraki.service.ProductoService;

@RestController
@RequestMapping("/pro")
public class ProductoRestController {
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/all")
    public List<Producto>getPosts(){
        return productoService.readAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable int id){
        Producto pro=productoService.read(id);
        return ResponseEntity.ok(pro);
    }
    
    @DeleteMapping("/{id}")
    public int deleteProducto(@PathVariable int id){
        return productoService.delete(id);
    }
    
    @PostMapping("/add")
    public int addProducto(@RequestBody Producto pro){
        System.out.println(pro.getNombre());
        System.out.println(pro.getPrecio());
        return productoService.create(pro);
    }
    
    @PutMapping("/edit")
    public int editProducto(@RequestBody Producto pro){
        Producto pr =new Producto(pro.getIdproducto(),pro.getNombre(),pro.getPrecio());
        System.out.println(pro.getIdproducto()+","+pro.getNombre()+" , "+pro.getPrecio());
        return productoService.update(pro);
    }
}
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
import pe.edu.ucs.meraki.model.Detalle;
import pe.edu.ucs.meraki.service.DetalleService;

/**
 *
 * @author BRITNEY
 */
@RestController
@RequestMapping("/det")
public class DetalleRestController {
    @Autowired
    private DetalleService detalleService;
    
    @GetMapping("/all")
    public List<Detalle>getPosts(){
        return detalleService.readAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Detalle> getProducto(@PathVariable int id){
        Detalle det=detalleService.read(id);
        return ResponseEntity.ok(det);
    }
    
    @DeleteMapping("/{id}")
    public int deleteProducto(@PathVariable int id){
        return detalleService.delete(id);
    }
    
    @PostMapping("/add")
    public int addProducto(@RequestBody Detalle det){
        return detalleService.create(det);
    }
    
    @PutMapping("/edit")
    public int editProducto(@RequestBody Detalle det){
        Detalle pr =new Detalle(det.getIddetalle(),det.getIdproducto(),det.getIdcliente(),det.getCantidad(),det.getCostounitario(),det.getImporte());
        System.out.println(det.getIddetalle()+","+det.getIdproducto()+","+det.getIdcliente()+","+det.getCantidad()+","+det.getCostounitario()+","+det.getImporte());
        return detalleService.update(det);
    }
}

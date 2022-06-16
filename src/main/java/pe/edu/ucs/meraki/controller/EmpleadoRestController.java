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
import pe.edu.ucs.meraki.model.Empleado;
import pe.edu.ucs.meraki.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/all")
    public List<Empleado> getEmpleado() {
        return empleadoService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleado(@PathVariable int id) {
        Empleado empleado = empleadoService.read(id);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/{id}")
    public int deleteEmpleado(@PathVariable int id) {
        return empleadoService.delete(id);
    }

    @PostMapping("/add")
    public int addEmpleado(@RequestBody Empleado empleado) {
        System.out.println(empleado.getNombres());
        System.out.println(empleado.getDni());
        System.out.println(empleado.getSueldo());
        System.out.println(empleado.getCargo());
        System.out.println(empleado.getTelefono());
        System.out.println(empleado.getDireccion());

        return empleadoService.create(empleado);
    }

    @PutMapping("/edit")
    public int editEmpleado(@RequestBody Empleado empleado) {
        Empleado beb = new Empleado(empleado.getIdempleado(), empleado.getNombres(), empleado.getDni(), empleado.getSueldo(), empleado.getCargo(), empleado.getTelefono(), empleado.getDireccion());
        System.out.println(empleado.getIdempleado() + " , " + empleado.getNombres() + "," + empleado.getDni() + "," + empleado.getSueldo() + "," + empleado.getCargo() + "," + empleado.getTelefono() + "," + empleado.getDireccion());
        return empleadoService.update(beb);
    }
}
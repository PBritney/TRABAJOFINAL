
package pe.edu.ucs.meraki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author admin
 */
@Controller
@RequestMapping("/detalle")
public class DetalleController {
    
    @GetMapping("")
    public String index(){
        return "ventas/detalle";
    }
}
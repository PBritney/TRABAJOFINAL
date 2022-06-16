
package pe.edu.ucs.meraki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author admin
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @GetMapping("")
    public String index(){
        return "clientes/cliente";
    }
}
package com.tienda.controller;

import com.tienda.service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// el controller lo ponemos nosotros 
@Controller
//sirve para ver informacion en el output
@Slf4j
public class IndexController {
    
    @Autowired
    private ArticuloService articuloService; //ahora se llama a la capa de negocio, es importante, la capa de negocio llama a ClienteDao
    
    @GetMapping("/")
    public String inicio(Model model){
        log.info("Ahora se usa arquitectura MVC");
        
        /*String mensaje = "Estamos en la semana 4, saludos";
        model.addAttribute("texto",mensaje);
        
        Cliente cliente = new Cliente("Warren","Robles","Warren30.wr@gmail.com","6032-3410");
        model.addAttribute("cliente",cliente);
        
        Cliente cliente2 = new Cliente("Juan","Lopez","Warren30.wr@gmail.com","6032-3410");
        
        Cliente cliente3 = new Cliente("Juan","Lopez","Warren30.wr@gmail.com","6032-3410");
        
        var clientes = Arrays.asList(cliente, cliente2, cliente3); //listas 
        //var clientes = Arrays.asList(); //lista vacia*/
        
        var articulos =articuloService.getArticulos(true);  //parte importante semana 05 //se hace cambio en semana 8
        
        model.addAttribute("articulos", articulos);
        
        return "index";
    }
}
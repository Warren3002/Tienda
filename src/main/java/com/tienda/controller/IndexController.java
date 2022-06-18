package com.tienda.controller;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import com.tienda.service.ClienteService;
import java.util.Arrays;
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
    private ClienteService clienteService; //ahora se llama a la capa de negocio, es importante, la capa de negocio llama a ClienteDao
    
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
        
        var clientes =clienteService.getClientes();  //parte importante semana 05
        
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {
        return "modificarCliente";
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/"; //linea importante el redirecciona como para volver a cargar el codigo, sino no mostraria nada 
    }
    
    @GetMapping("/modificarCliente/{idCliente}") //en el segundo atributo debe estar dentro de corchetes 
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }//model porque tenemos que enviar datos a la vista
    
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/";
    }
}

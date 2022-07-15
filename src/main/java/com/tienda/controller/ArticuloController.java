package com.tienda.controller;

import com.tienda.domain.Articulo;
import com.tienda.service.ArticuloService;
import com.tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/articulo/listado")
    public String inicio(Model model) {

        var articulos = articuloService.getArticulos(false);  //parte importante semana 05
        model.addAttribute("articulos", articulos);

        return "/articulo/listado";
    }
    
    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/articulo/modificar";
    }
    
    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado"; //linea importante el redirecciona como para volver a cargar el codigo, sino no mostraria nada 
    }
    
    @GetMapping("/articulo/modificar/{idArticulo}") //en el segundo atributo debe estar dentro de corchetes 
    public String modificarArticulo(Articulo articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modificar";
    }//model porque tenemos que enviar datos a la vista
    
    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }

}



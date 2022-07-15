package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;


public interface ArticuloService {
    //solo definiremos los metodos 
    
    //metodo para obtener todos los articulos 
    public List<Articulo> getArticulos(boolean active); 
    
    public Articulo getArticulo(Articulo articulo);
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
}

package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    //solo definiremos los metodos 
    
    //metodo para obtener todos los categorias 
    public List<Categoria> getCategorias(boolean activo); 
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);
}

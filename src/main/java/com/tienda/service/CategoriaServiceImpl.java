package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service  ///siempre debe estar este "service "
public class CategoriaServiceImpl implements CategoriaService{

    //Para quitar el error debemos hacer las importaciones
    
    
    @Autowired
    private CategoriaDao clienteDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) {
        var lista =(List<Categoria>)clienteDao.findAll();
        
        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista; //count 4
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria cliente) {
        return clienteDao.findById(cliente.getIdCategoria()).orElse(null); //si el metodo es algo valido, devuelve eso
    }
      
    @Override
    @Transactional
    public void save(Categoria cliente) {
        clienteDao.save(cliente);
    }
      
    @Override
    @Transactional
    public void delete(Categoria cliente) {
        clienteDao.delete(cliente);
    }

}

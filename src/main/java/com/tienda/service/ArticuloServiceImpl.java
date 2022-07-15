package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service  ///siempre debe estar este "service "
public class ArticuloServiceImpl implements ArticuloService{

    //Para quitar el error debemos hacer las importaciones
    
    
    @Autowired
    private ArticuloDao clienteDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activo) {
        var lista =(List<Articulo>)clienteDao.findAll();
        
        if (activo) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista; //count 4
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo cliente) {
        return clienteDao.findById(cliente.getIdArticulo()).orElse(null); //si el metodo es algo valido, devuelve eso
    }
      
    @Override
    @Transactional
    public void save(Articulo cliente) {
        clienteDao.save(cliente);
    }
      
    @Override
    @Transactional
    public void delete(Articulo cliente) {
        clienteDao.delete(cliente);
    }

}

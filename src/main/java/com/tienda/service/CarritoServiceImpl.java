package com.tienda.service;

import com.tienda.dao.CarritoDao;
import com.tienda.domain.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //etiqueta importante 
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    CarritoDao carritoDao;

    @Override
    public Carrito getCarrito(Carrito carrito) {
        return carritoDao.findById(carrito.getIdCarrito()).orElse(null);
    }

    @Override
    public Carrito getCarritoCliente(long idCliente) {
        var carrito = carritoDao.findByIdCliente(idCliente).orElse(null);
        
        if (carrito == null) {
            Carrito nuevo = new Carrito(idCliente);
            carrito = carritoDao.save(nuevo);
        }
        return carrito;
    }
}

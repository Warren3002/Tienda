package com.tienda.dao;

import com.tienda.domain.Articulo;
import com.tienda.domain.CarritoDetalle;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface CarritoDetalleDao extends CrudRepository<CarritoDetalle, Long> {

    public Optional<CarritoDetalle> findByIdCarritoAndArticulo(Long idCarrito, Articulo articulo); //aca se busca por propiedad //buscar un articulo en un carrito especifico

    public List<CarritoDetalle> findByIdCarrito(Long idCarrito); //trae los detalles del articulo, trae los articulos relacionados implicitamente 

    public void deleteByIdCarrito(Long idCarrito);
}

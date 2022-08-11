
package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data //sirve para tener gets and setters 
@Entity //se convierte en entidad
@Table(name = "articulo")  //hacer relacion con la tabal de BD 

public class Articulo implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_articulo") //se debe poner de todas maneras para que pueda leer los elementos que tengan relaciones en bases de datos 
    private Long idArticulo; //hibernate lo transforma en id_cliente
    private Long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias; // el error que me daba era que habia un problema, entonces decia que no encontraba una tabla porque estaba mal escrita, mi error era buscar en "articulo" era buscar la palabra "existencias"
    private boolean activo;

    public Articulo() {
    }

    public Articulo(Long idCategoria, String descripcion, String detalle, double precio, int existencias, boolean activo) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }

    
    
}

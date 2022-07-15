package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data //sirve para tener gets and setters 
@Entity //se convierte en entidad
@Table(name = "categoria")  //hacer relacion con la tabal de BD 
public class Categoria implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria; //hibernate lo transforma en id_cliente
    private String descripcion;
    private boolean activo;

    
    
    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Categoria() {
    }
    
}

package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data //sirve para tener gets and setters 
@Entity //se convierte en entidad
@Table(name = "cliente")  //hacer relacion con la tabal de BD 

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente; //hibernate lo transforma en id_cliente
    String nombre;
    String apellidos;
    String correo;
    String telefono;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

}

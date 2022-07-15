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
@Table(name = "credito")  //hacer relacion con la tabal de BD 
public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_credito") // esta relacion tambien sirve para hacer referencias a las columnas de la bd 
    private Long idCredito; //hiberner lo trasndorma en id_credito
    private double limite;

    public Credito() {
    }

    public Credito(double limite) {
        this.limite = limite;
    }
   
}

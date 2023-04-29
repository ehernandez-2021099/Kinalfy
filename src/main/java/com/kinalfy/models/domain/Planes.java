package com.kinalfy.models.domain;

import javax.persistence.Column;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@Entity
@Table(name="planes")

@NamedQueries({
    @NamedQuery(name="Planes.findAll", query="from Planes"),
    @NamedQuery(name="Planes.find", query= "from Planes WHERE id = :id")
})
public class Planes implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nombre")
    private String nombrePlan;
    
    @Column
    private Float precio;

    public Planes() {
    }

    public Planes(String nombrePlan, Float precio) {
        this.nombrePlan = nombrePlan;
        this.precio = precio;
    }

    public Planes(int id, String nombrePlan,Float precio  ) {
        this.id = id;
        this.nombrePlan = nombrePlan;
        this.precio = precio;
    }

    public Planes(int id) {
        this.id = id;
    }

    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    
}
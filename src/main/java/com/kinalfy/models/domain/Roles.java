package com.kinalfy.models.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

@Entity
@Table(name="roles")

@NamedQueries({
    @NamedQuery(name="Roles.findAll", query="from Roles"),
    @NamedQuery(name="Roles.find", query= "from Roles WHERE id = :id")
})

public class Roles implements Serializable{
    
    private static final long serialVersionUID = 1L;
   
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    
    @Column
    private String descripcion;

    public Roles() {
    }

    public Roles(int id) {
        this.id = id;
    }
    
    public Roles(String descripcion) {
        this.descripcion = descripcion;
    }

    public Roles(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Roles{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
}

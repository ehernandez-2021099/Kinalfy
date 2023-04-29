package com.kinalfy.models.domain;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

@Entity
@Table(name="albumes")

@NamedQueries({
    @NamedQuery(name="Album.findAll", query="from Album WHERE id > 0"),
    @NamedQuery(name="Album.find", query= "from Album WHERE id = :id")
})

public class Album implements Serializable{
     private static final long serialVersionUID = 1L;
     
    @Id
    @Column(name="id")
    

    private int id;
    @Column
    private String nombre;
    
    @Column(name="cantidad_canciones")
    private String cantidadCanciones;

    public Album() {
        
    }

    public Album(int id, String nombre, String cantidadCanciones_) {
        this.id = id;
        this.nombre = nombre;
        this.cantidadCanciones = cantidadCanciones_;
    }

    public Album(String nombre, String cantidadCanciones_) {
        this.nombre = nombre;
        this.cantidadCanciones = cantidadCanciones_;
    }

    public Album(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCantidadCanciones() {
        return cantidadCanciones;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadCanciones(String cantidadCanciones_) {
        this.cantidadCanciones = cantidadCanciones_;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", nombre=" + nombre + ", cantidad_canciones=" + cantidadCanciones + '}';
    }

}

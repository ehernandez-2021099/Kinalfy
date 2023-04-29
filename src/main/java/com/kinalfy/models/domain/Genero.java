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
@Table(name="generos")

@NamedQueries({
    @NamedQuery(name="Genero.findAll", query="from Genero"),
    @NamedQuery(name="Genero.find", query= "from Genero WHERE id = :id")
})

public class Genero implements Serializable{
    
     private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String nombre;

    public Genero(int id) {
        this.id = id;
    }

    public Genero() {
    }

    public Genero(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Genero(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Genero{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
}

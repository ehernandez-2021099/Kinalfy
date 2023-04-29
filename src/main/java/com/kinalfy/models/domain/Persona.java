package com.kinalfy.models.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="personas")

@NamedQueries({
    @NamedQuery(name="Persona.findAll", query="from Persona"),
    @NamedQuery(name="Persona.find", query= "from Persona WHERE id = :id")
})
public class Persona {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nombre_1")
    private String nombre1;
    
    @Column(name="nombre_2")
    private String nombre2;
    
    @Column(name="nombre_3")
    private String nombre3;
    
    @Column(name="apellido_1")
    private String apellido1;
    
    @Column(name="apellido_2")
    private String apellido2;
    
    private String correo;

    public Persona() {
    }

    public Persona(int id) {
        this.id = id;
    }
    
    public Persona(String nombre1, String nombre2, String nombre3, String apellido1, String apellido2, String correo) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.nombre3 = nombre3;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
    }

    public Persona(int id, String nombre1, String nombre2, String nombre3, String apellido1, String apellido2, String correo) {
        this.id = id;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.nombre3 = nombre3;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getNombre3() {
        return nombre3;
    }

    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre1=" + nombre1 + ", nombre2=" + nombre2 + ", nombre3=" + nombre3 + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", correo=" + correo + '}';
    }

    

    
    
    
}

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
@Table(name="artistas")

@NamedQueries({
    @NamedQuery(name="Artista.findAll", query="from Artista"),
    @NamedQuery(name="Artista.find", query= "from Artista WHERE id = :id")
})

public class Artista implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    @Column
    private String nombre;
    @Column(name="informacion_artista_id")
    private int infoArtistaId;

    public Artista() {
    }

    public Artista(int id) {
        this.id = id;
    }

    public Artista(String nombre, int informacion_artista_id) {
        this.nombre = nombre;
        this.infoArtistaId = informacion_artista_id;
    }

    public Artista(int id, String nombre, int informacion_artista_id) {
        this.id = id;
        this.nombre = nombre;
        this.infoArtistaId = informacion_artista_id;
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

    public int getInfoArtistaId() {
        return infoArtistaId;
    }

    public void setInfoArtistaId(int infoArtistaId) {
        this.infoArtistaId = infoArtistaId;
    }

   

    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", nombre=" + nombre + ", informacion_id=" + infoArtistaId + '}';
    }

}

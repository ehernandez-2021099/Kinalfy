package com.kinalfy.models.domain;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

@Entity
@Table(name="canciones")

@NamedQueries({
    @NamedQuery(name="Cancion.findAll", query="from Cancion WHERE id > 0"),
    @NamedQuery(name="Cancion.find", query= "from Cancion WHERE id = :id")
})

public class Cancion implements Serializable{
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String nombre;
    
    
    @Column(name="album_artista_id")
    private int albumArtistaId;

    
    
    private String albumNombre;

    public Cancion(int id, String nombre,  int albumArtistaId, String albumNombre) {
        this.id = id;
        this.nombre = nombre;
        
        this.albumArtistaId = albumArtistaId;
        this.albumNombre = albumNombre;
    }

    public Cancion(String nombre,  int albumArtistaId) {
        this.nombre = nombre;
        this.albumArtistaId = albumArtistaId;
        
    }
    
    public Cancion(int id,String nombre,  int albumArtistaId) {
        this.id = id;
        this.nombre = nombre;
        this.albumArtistaId = albumArtistaId;
        
    }
    
    
    public Cancion(int id) {
        this.id = id;
    }

   

   

    public Cancion() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }


   


    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    

    public int getAlbumArtistaId() {
        return albumArtistaId;
    }

    public void setAlbumArtistaId(int albumArtistaId) {
        this.albumArtistaId = albumArtistaId;
    }

   

    public String getAlbumNombre() {
        return albumNombre;
    }

    public void setAlbumNombre(String albumNombre) {
        this.albumNombre = albumNombre;
    }

    
    
    @Override
    public String toString() {
        return "Cancion{" + "id=" + id + ", nombre=" + nombre  +  ", album_artista_id=" + albumArtistaId + '}';
    }
    
    
}



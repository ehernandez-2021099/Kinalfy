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
@Table(name="asignaciones_albumes_artistas")

@NamedQueries({
    @NamedQuery(name="AsignacionAlbumArtista.findAll", query="from AsignacionAlbumArtista"),
    @NamedQuery(name="AsignacionAlbumArtista.find", query= "from AsignacionAlbumArtista WHERE id = :id")
})
public class AsignacionAlbumArtista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="artista_id")
    private int artistaId;
    
    @Column(name="album_id")
    private int albumId;

    private String nombreAlbum;
    private String nombreArtista;

    public AsignacionAlbumArtista(int id, int artistaId, int albumId, String nombreAlbum, String nombreArtista) {
        this.id = id;
        this.artistaId = artistaId;
        this.albumId = albumId;
        this.nombreAlbum = nombreAlbum;
        this.nombreArtista = nombreArtista;
    }

    
    
    
    public AsignacionAlbumArtista(int id, int artistaId, int albumId) {
        this.id = id;
        this.artistaId = artistaId;
        this.albumId = albumId;
    }

    public AsignacionAlbumArtista(int id) {
        this.id = id;
    }

    public AsignacionAlbumArtista() {
    }

    public AsignacionAlbumArtista(int artistaId, int albumId) {
        this.artistaId = artistaId;
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(int artistaId) {
        this.artistaId = artistaId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    
    
    @Override
    public String toString() {
        return "AsignacionAlbumArtista{" + "id=" + id + ", artistaId=" + artistaId + ", albumId=" + albumId + '}';
    }

   
}

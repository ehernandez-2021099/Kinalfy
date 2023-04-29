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
@Table(name="asignaciones_artistas_generos")

@NamedQueries({
    @NamedQuery(name="AsignacionGeneroArtista.findAll", query="from AsignacionGeneroArtista"),
    @NamedQuery(name="AsignacionGeneroArtista.find", query= "from AsignacionGeneroArtista WHERE id = :id")
})


public class AsignacionGeneroArtista implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="genero_id")
    private int generoId;
    
    private String nombreGenero;
    
    @Column(name="artista_id")
    private int artistaId;

    private String nombreArtista;
    
    public AsignacionGeneroArtista() {
    }

    public AsignacionGeneroArtista(int generoId, int artistaId) {
        this.generoId = generoId;
        this.artistaId = artistaId;
    }

    public AsignacionGeneroArtista(int id, int generoId, int artistaId) {
        this.id = id;
        this.generoId = generoId;
        this.artistaId = artistaId;
    }

    public AsignacionGeneroArtista(int id) {
        this.id = id;
    }

    public AsignacionGeneroArtista(int id, int generoId, String nombreGenero, int artistaId, String nombreArtista) {
        this.id = id;
        this.generoId = generoId;
        this.nombreGenero = nombreGenero;
        this.artistaId = artistaId;
        this.nombreArtista = nombreArtista;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }

    public int getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(int artistaId) {
        this.artistaId = artistaId;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    
    
    @Override
    public String toString() {
        return "AsignacionGeneroArtista{" + "id=" + id + ", generoId=" + generoId + ", artistaId=" + artistaId + '}';
    }
    
}

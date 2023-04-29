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
@Table(name="informacion_artistas")

@NamedQueries({
    @NamedQuery(name="InformacionArtista.findAll", query="from InformacionArtista"),
    @NamedQuery(name="InformacionArtista.find", query= "from InformacionArtista WHERE id = :id")
})

public class InformacionArtista implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String facebook;
    
    @Column
    private String instagram;
    
    @Column
    private String youtube;
    
    @Column
    private String descripcion;
    
    @Column
    private String imagen;

    public InformacionArtista() {
    }

    public InformacionArtista(String facebook, String instagram, String youtube, String descripcion, String imagen) {
        this.facebook = facebook;
        this.instagram = instagram;
        this.youtube = youtube;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public InformacionArtista(int id, String facebook, String instagram, String youtube, String descripcion, String imagen) {
        this.id = id;
        this.facebook = facebook;
        this.instagram = instagram;
        this.youtube = youtube;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public InformacionArtista(int id) {
        this.id = id;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    @Override
    public String toString() {
        return "InformacionArtista{" + "id=" + id + ", facebook=" + facebook + ", instagram=" + instagram + ", youtube=" + youtube + ", descripcion=" + descripcion + '}';
    }
    
    
}

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
@Table(name="anuncios")

@NamedQueries({
    @NamedQuery(name="Anuncios.findAll", query="from Anuncios WHERE id > 0"),
    @NamedQuery(name="Anuncios.find", query= "from Anuncios WHERE id = :id")
})

public class Anuncios implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    private int id;
    @Column(name="url_de_imagen")
    private String urlImage;
    @Column(name="descripcion_de_anuncio")
    private String descripcion;

    public Anuncios() {
    }

    public Anuncios(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Anuncios(int id, String urlImage, String descripcion) {
        this.id = id;
        this.urlImage = urlImage;
        this.descripcion = descripcion;
    }
    
    public Anuncios(String descripcion, String urlImage){
        this.urlImage = urlImage;
        this.descripcion = descripcion;
    }

    public Anuncios(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Anuncios{" + "id=" + id + ", urlImage=" + urlImage + ", descripcion=" + descripcion + '}';
    }

}

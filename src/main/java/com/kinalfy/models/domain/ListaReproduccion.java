package com.kinalfy.models.domain;

import java.sql.Date;
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
@Table(name="listas_reproduccion")

@NamedQueries({
    @NamedQuery(name="ListaReproduccion.findAll", query="from ListaReproduccion"),
    @NamedQuery(name="ListaReproduccion.find", query= "from ListaReproduccion WHERE id = :id")
})

public class ListaReproduccion implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    @Column(name="cancion_id")
    private int cancionId;

    private String cancionNombre;
    
    
    @Column(name="asignacion_anuncio_id")
    private int asignacionAnuncioId;
    
    private String descripcionAnuncio;
    
    private int tarjetaId;
    
    private String tarjetaNombre;
    
    private long numeroTarjeta;
    
    private int planId;
    
    private String nombrePlan;

    public ListaReproduccion(int id, int cancionId, String cancionNombre, int asignacionAnuncioId, String descripcionAnuncio, int tarjetaId, String tarjetaNombre, long numeroTarjeta, int planId, String nombrePlan) {
        this.id = id;
        this.cancionId = cancionId;
        this.cancionNombre = cancionNombre;
        this.asignacionAnuncioId = asignacionAnuncioId;
        this.descripcionAnuncio = descripcionAnuncio;
        this.tarjetaId = tarjetaId;
        this.tarjetaNombre = tarjetaNombre;
        this.numeroTarjeta = numeroTarjeta;
        this.planId = planId;
        this.nombrePlan = nombrePlan;
    }
    
    

    public ListaReproduccion() {
    }

    public ListaReproduccion(int asignacionAnuncioId, int cancionId) {
        this.asignacionAnuncioId = asignacionAnuncioId;
        this.cancionId = cancionId;
    }

    public ListaReproduccion(int id, int asignacionAnuncioId, int cancionId) {
        this.id = id;
        this.asignacionAnuncioId = asignacionAnuncioId;
        this.cancionId = cancionId;
    }

    public ListaReproduccion(int id) {
        this.id = id;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAsignacionAnuncioId() {
        return asignacionAnuncioId;
    }

    public void setAsignacionAnuncioId(int asignacionAnuncioId) {
        this.asignacionAnuncioId = asignacionAnuncioId;
    }

    public int getCancionId() {
        return cancionId;
    }

    public void setCancionId(int cancionId) {
        this.cancionId = cancionId;
    }

    public String getCancionNombre() {
        return cancionNombre;
    }

    public void setCancionNombre(String cancionNombre) {
        this.cancionNombre = cancionNombre;
    }

    public String getDescripcionAnuncio() {
        return descripcionAnuncio;
    }

    public void setDescripcionAnuncio(String descripcionAnuncio) {
        this.descripcionAnuncio = descripcionAnuncio;
    }

    public int getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(int tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public String getTarjetaNombre() {
        return tarjetaNombre;
    }

    public void setTarjetaNombre(String tarjetaNombre) {
        this.tarjetaNombre = tarjetaNombre;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    
    
    @Override
    public String toString() {
        return "ListaReproduccion{" + "id=" + id + ", asignacionAnuncioId=" + asignacionAnuncioId + ", cancionId=" + cancionId + '}';
    }
    
}

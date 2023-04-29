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
@Table(name="asignaciones_anuncios_planes")



@NamedQueries({
    @NamedQuery(name="AsignacionAnuncios.findAll", query="from AsignacionAnuncios"),
    @NamedQuery(name="AsignacionAnuncios.find", query= "from AsignacionAnuncios WHERE id = :id")
})



public class AsignacionAnuncios implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="asignacion_plan_tarjeta_id")
    private int asignacionPlanTarjeta;
    
    @Column(name="anuncio_id")
    private int anuncioId;

    private int tarjetaId;
    
    private long numeroTarjeta;
    
    private String nombreTarjeta;
    
    private String nombrePlan;
    
    private String descripcionAnuncio;
    
    private int planId;

   public AsignacionAnuncios() {
    }

    public AsignacionAnuncios(int id, int asignacionPlanTarjeta, int anuncioId, int tarjetaId, long numeroTarjeta, String nombreTarjeta, String nombrePlan, String descripcionAnuncio, int planId) {
        this.id = id;
        this.asignacionPlanTarjeta = asignacionPlanTarjeta;
        this.anuncioId = anuncioId;
        this.tarjetaId = tarjetaId;
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTarjeta = nombreTarjeta;
        this.nombrePlan = nombrePlan;
        this.descripcionAnuncio = descripcionAnuncio;
        this.planId = planId;
    }



   public AsignacionAnuncios(int asignacionPlanTarjeta, int anuncioId) {
        this.asignacionPlanTarjeta = asignacionPlanTarjeta;
        this.anuncioId = anuncioId;
    }


   public AsignacionAnuncios(int id, int asignacionPlanTarjeta, int anuncioId) {
        this.id = id;
        this.asignacionPlanTarjeta = asignacionPlanTarjeta;
        this.anuncioId = anuncioId;
    }


   public AsignacionAnuncios(int id) {
        this.id = id;
    }
    

   public int getId() {
        return id;
    }


   public void setId(int id) {
        this.id = id;
    }


   public int getAsignacionPlanTarjeta() {
        return asignacionPlanTarjeta;
    }


   public void setAsignacionPlanTarjeta(int asignacionPlanTarjeta) {
        this.asignacionPlanTarjeta = asignacionPlanTarjeta;
    }


   public int getAnuncioId() {
        return anuncioId;
    }


   public void setAnuncioId(int anuncioId) {
        this.anuncioId = anuncioId;
    }

    public int getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(int tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public String getDescripcionAnuncio() {
        return descripcionAnuncio;
    }

    public void setDescripcionAnuncio(String descripcionAnuncio) {
        this.descripcionAnuncio = descripcionAnuncio;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }


   
   
   @Override
    public String toString() {
        return "AsignacionAnuncios{" + "id=" + id + ", asignacionPlanTarjeta=" + asignacionPlanTarjeta + ", anuncioId=" + anuncioId + '}';
    }
    
}
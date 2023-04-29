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
@Table(name="asignaciones_planes_tarjetas")

@NamedQueries({
    @NamedQuery(name="AsignacionesPlanes.findAll", query="from AsignacionesPlanes"),
    @NamedQuery(name="AsignacionesPlanes.find", query= "from AsignacionesPlanes WHERE id = :id")
})

public class AsignacionesPlanes implements Serializable{
    
        
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="tarjeta_id")
    private int tarjetaId;
    
    private long numeroTarjeta;
    
    private String nombrePropietario;
    
    @Column(name="plan_id")
    private int planId;

    private String nombrePlan;
    
    public AsignacionesPlanes() {
    }

    public AsignacionesPlanes(int tarjetaId, int planId) {
        this.tarjetaId = tarjetaId;
        this.planId = planId;
    }

    public AsignacionesPlanes(int id, int tarjetaId, int planId) {
        this.id = id;
        this.tarjetaId = tarjetaId;
        this.planId = planId;
    }

    public AsignacionesPlanes(int id, int tarjetaId, long numeroTarjeta, String nombrePropietario, int planId, String nombrePlan) {
        this.id = id;
        this.tarjetaId = tarjetaId;
        this.numeroTarjeta = numeroTarjeta;
        this.nombrePropietario = nombrePropietario;
        this.planId = planId;
        this.nombrePlan = nombrePlan;
    }

    
    
    public AsignacionesPlanes(int id) {
        this.id = id;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(int tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    
    
    @Override
    public String toString() {
        return "AsignacionesPlanes{" + "id=" + id + ", tarjetaId=" + tarjetaId + ", planId=" + planId + '}';
    }
    
}

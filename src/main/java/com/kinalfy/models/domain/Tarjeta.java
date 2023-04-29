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
@Table(name="tarjetas")

@NamedQueries({
    @NamedQuery(name="Tarjeta.findAll", query="from Tarjeta WHERE id > 0"),
    @NamedQuery(name="Tarjeta.find", query= "from Tarjeta WHERE id = :id")
})

public class Tarjeta implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="numero_tarjeta")
    private String numeroTarjeta;
    
    @Column(name="nombre")
    private String nombrePropietario;
    
    @Column(name="fecha_vencimiento")
    private Date fechaVencimiento;
    
    @Column(name="tipo_de_tarjeta")
    private String tipoTarjeta;
    
    @Column
    private String empresa;

    public Tarjeta() {
    }

    public Tarjeta(int id) {
        this.id = id;
    }

    public Tarjeta(String numeroTarjeta, String nombrePropietario, Date fechaVencimiento, String tipoTarjeta, String empresa) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombrePropietario = nombrePropietario;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoTarjeta = tipoTarjeta;
        this.empresa = empresa;
    }

    public Tarjeta(int id, String numeroTarjeta, String nombrePropietario, Date fechaVencimiento, String tipoTarjeta, String empresa) {
        this.id = id;
        this.numeroTarjeta = numeroTarjeta;
        this.nombrePropietario = nombrePropietario;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoTarjeta = tipoTarjeta;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "id=" + id + ", numeroTarjeta=" + numeroTarjeta + ", nombrePropietario=" + nombrePropietario + ", fechaVencimiento=" + fechaVencimiento + ", tipoTarjeta=" + tipoTarjeta + ", empresa=" + empresa + '}';
    }
    
}

package com.kinalfy.models.domain;

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
@Table(name="usuarios")

@NamedQueries({
    @NamedQuery(name="Usuario.findAll", query="from Usuario"),
    @NamedQuery(name="Usuario.find", query= "from Usuario WHERE user = :id")
})
public class Usuario implements Serializable{
    
    @Id
    @Column(name="user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String user;
    
    @Column(name="password")
    private String pass;
    
    @Column(name="persona_id")
    private int personaId;
    
    @Column(name="rol_id")
    private int rolId;
    
    @Column(name="lista_reproduccion_id")
    private int listaRepoduccionId;
    
    @Column(name="asignacion_plan_id")
    private int asignacionPlanId;

    private String nombrePersona;
    
    private String nombreRol;
    
    private int cancionId;
    
    private String nombreCancion;
    
    public Usuario() {
    }

    public Usuario(String user, String pass, int personaId, String nombrePersona, int rolId,  String nombreRol, int listaRepoduccionId, int cancionId, String nombreCancion) {
        this.user = user;
        this.pass = pass;
        this.rolId = rolId;
        this.personaId = personaId;
        this.listaRepoduccionId = listaRepoduccionId;
        this.nombrePersona = nombrePersona;
        this.nombreRol = nombreRol;
        this.cancionId = cancionId;
        this.nombreCancion = nombreCancion;
    }

    public Usuario(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    
    public Usuario(String pass, int personaId, int rolId, int listaRepoduccionId, int asignacionPlanId) {
        this.pass = pass;
        this.personaId = personaId;
        this.rolId = rolId;
        this.listaRepoduccionId = listaRepoduccionId;
        this.asignacionPlanId = asignacionPlanId;
    }

    public Usuario(String user, String pass, int personaId, int rolId, int listaRepoduccionId, int asignacionPlanId) {
        this.user = user;
        this.pass = pass;
        this.personaId = personaId;
        this.rolId = rolId;
        this.listaRepoduccionId = listaRepoduccionId;
        this.asignacionPlanId = asignacionPlanId;
    }
    
    
    public Usuario(String user) {
        this.user = user;
    }

    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public int getListaRepoduccionId() {
        return listaRepoduccionId;
    }

    public void setListaRepoduccionId(int listaRepoduccionId) {
        this.listaRepoduccionId = listaRepoduccionId;
    }

    public int getAsignacionPlanId() {
        return asignacionPlanId;
    }

    public void setAsignacionPlanId(int asignacionPlanId) {
        this.asignacionPlanId = asignacionPlanId;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public int getCancionId() {
        return cancionId;
    }

    public void setCancionId(int cancionId) {
        this.cancionId = cancionId;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    
    
    @Override
    public String toString() {
        return "Usuario{" + "user=" + user + ", pass=" + pass + ", personaId=" + personaId + ", rolId=" + rolId + ", listaRepoduccionId=" + listaRepoduccionId + ", asignacionPlanId=" + asignacionPlanId + '}';
    }
    
}

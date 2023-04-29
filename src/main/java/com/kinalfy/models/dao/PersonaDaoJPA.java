package com.kinalfy.models.dao;

import com.kinalfy.db.ConexionPU;
import com.kinalfy.models.domain.Persona;
import com.kinalfy.models.idao.IPersonaDAO;
import java.util.List;

public class PersonaDaoJPA implements IPersonaDAO {

    private ConexionPU con = ConexionPU.getInstance();

    @Override
    public List<Persona> getAll() {
        return con.getEntityManager().createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public int add(Persona persona) {
        System.out.println(persona);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(persona);
            //con.getEntityManager().remove(con.getEntityManager().contains(estudiante) ? estudiante : con.getEntityManager().merge(estudiante));
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.out.println("Se produjo un error al intentar insertar el siguiente registro: " + persona);
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }

        return rows;
    }

    @Override
    public int update(Persona persona) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(persona);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int delete(Persona persona) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            //con.getEntityManager().remove(con.getEntityManager().contains(estudiante) ? estudiante : con.getEntityManager().merge(estudiante));
            con.getEntityManager().remove(persona);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
            System.out.println("Se elimino");
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("No se elimino");
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    public Persona get(Persona personas) {
        return (Persona) con.getEntityManager().createNamedQuery("Persona.find").setParameter("id", personas.getId()).getSingleResult();
    }
}

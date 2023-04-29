package com.kinalfy.models.dao;

import com.kinalfy.db.ConexionPU;
import com.kinalfy.models.domain.Genero;
import com.kinalfy.models.idao.IGeneroDAO;
import java.util.List;

public class GeneroDaoJPA implements IGeneroDAO {
private ConexionPU con = ConexionPU.getInstance();

    @Override
    public List<Genero> getAll() {
        return con.getEntityManager().createNamedQuery("Genero.findAll").getResultList();
    }

    @Override
    public int add(Genero genero) {
        System.out.println(genero);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(genero);
            //con.getEntityManager().remove(con.getEntityManager().contains(estudiante) ? estudiante : con.getEntityManager().merge(estudiante));
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.out.println("Se produjo un error al intentar insertar el siguiente registro: " + genero);
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }

        return rows;
    }

    @Override
    public int update(Genero genero) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(genero);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int delete(Genero genero) {
       int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            //con.getEntityManager().remove(con.getEntityManager().contains(estudiante) ? estudiante : con.getEntityManager().merge(estudiante));
            con.getEntityManager().remove(genero);
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
    public Genero get(Genero genero){
        return (Genero) con.getEntityManager().createNamedQuery("Genero.find").setParameter("id",genero.getId()).getSingleResult();
    }
    
}

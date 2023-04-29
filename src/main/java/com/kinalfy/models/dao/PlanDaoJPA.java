package com.kinalfy.models.dao;

import com.kinalfy.db.ConexionPU;
import com.kinalfy.models.domain.Planes;
import com.kinalfy.models.idao.IPlanDAO;
import java.util.List;

public class PlanDaoJPA implements IPlanDAO {
private ConexionPU con = ConexionPU.getInstance();
    @Override
    public List<Planes> getAll() {
        return con.getEntityManager().createNamedQuery("Planes.findAll").getResultList();
    }

    @Override
    public int add(Planes planes) {
      System.out.println(planes);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(planes);
            //con.getEntityManager().remove(con.getEntityManager().contains(estudiante) ? estudiante : con.getEntityManager().merge(estudiante));
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.out.println("Se produjo un error al intentar insertar el siguiente registro: " + planes);
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }

        return rows;
    }

    @Override
    public int update(Planes planes) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(planes);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int delete(Planes planes) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            //con.getEntityManager().remove(con.getEntityManager().contains(estudiante) ? estudiante : con.getEntityManager().merge(estudiante));
            con.getEntityManager().remove(planes);
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
    public Planes get(Planes plan){
        return (Planes) con.getEntityManager().createNamedQuery("Planes.find").setParameter("id",plan.getId()).getSingleResult();
    }
    
}

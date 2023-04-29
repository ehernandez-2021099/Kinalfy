package com.kinalfy.models.dao;

import com.kinalfy.db.ConexionPU;
import com.kinalfy.models.domain.Tarjeta;
import com.kinalfy.models.idao.ITarjetaDAO;
import java.util.List;

public class TarjetaDaoJPA implements ITarjetaDAO {
private ConexionPU con = ConexionPU.getInstance();
    @Override
    public List<Tarjeta> getAll() {
         return con.getEntityManager().createNamedQuery("Tarjeta.findAll").getResultList();
    }

    @Override
    public int add(Tarjeta tarjeta) {
        System.out.println(tarjeta);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(tarjeta);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.out.println("Se produjo un error al intentar insertar el siguiente registro: "+tarjeta);
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        
        return rows;
    }

    @Override
    public int update(Tarjeta tarjeta) {
        System.out.println(tarjeta);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(tarjeta);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.out.println("Se produjo un error al intentar insertar el siguiente registro: "+ tarjeta);
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        
        return rows;
    }

    @Override
    public int delete(Tarjeta tarjeta) {
       int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            //con.getEntityManager().remove(con.getEntityManager().contains(estudiante) ? estudiante : con.getEntityManager().merge(estudiante));
            con.getEntityManager().remove(tarjeta);
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
    public Tarjeta get(Tarjeta tarjeta){
        return (Tarjeta) con.getEntityManager().createNamedQuery("Tarjeta.find").setParameter("id",tarjeta.getId()).getSingleResult();
    }
}

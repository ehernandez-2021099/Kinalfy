package com.kinalfy.models.dao;

import com.kinalfy.db.ConexionPU;
import com.kinalfy.models.domain.Anuncios;
import com.kinalfy.models.idao.IAnuncioDAO;
import java.util.List;

public class AnuncioDaoJPA implements IAnuncioDAO{
   private ConexionPU con = ConexionPU.getInstance(); 

    @Override
    public List<Anuncios> getAll() {
        return con.getEntityManager().createNamedQuery("Anuncios.findAll").getResultList();
    }

    @Override
    public int add(Anuncios anuncio) {
        System.out.println(anuncio);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(anuncio);
            //con.getEntityManager().remove(con.getEntityManager().contains(estudiante) ? estudiante : con.getEntityManager().merge(estudiante));
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.out.println("Se produjo un error al intentar insertar el siguiente registro: " + anuncio);
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }

        return rows;
    }

    @Override
    public int update(Anuncios anuncio) {
       int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(anuncio);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }
    
    @Override
    public int delete(Anuncios anuncio) {
       int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            //con.getEntityManager().remove(con.getEntityManager().contains(estudiante) ? estudiante : con.getEntityManager().merge(estudiante));
            con.getEntityManager().remove(anuncio);
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
    public Anuncios get(Anuncios anuncio){
        return (Anuncios) con.getEntityManager().createNamedQuery("Anuncios.find").setParameter("id",anuncio.getId()).getSingleResult();
    }
}

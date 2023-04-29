package com.kinalfy.models.dao;

import com.kinalfy.db.ConexionPU;
import com.kinalfy.models.domain.InformacionArtista;
import com.kinalfy.models.idao.IInformacionArtistaDAO;
import java.util.List;

public class InformacionArtistaDaoJPA implements IInformacionArtistaDAO {

    private ConexionPU con = ConexionPU.getInstance();

    @Override
    public List<InformacionArtista> getAll() {
        return con.getEntityManager().createNamedQuery("InformacionArtista.findAll").getResultList();
    }

    @Override
    public int add(InformacionArtista informacion) {
        System.out.println(informacion);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(informacion);
            //con.getEntityManager().remove(con.getEntityManager().contains(estudiante) ? estudiante : con.getEntityManager().merge(estudiante));
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.out.println("Se produjo un error al intentar insertar el siguiente registro: " + informacion);
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }

        return rows;
    }

    @Override
    public int update(InformacionArtista informacion) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(informacion);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int delete(InformacionArtista informacion) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            //con.getEntityManager().remove(con.getEntityManager().contains(estudiante) ? estudiante : con.getEntityManager().merge(estudiante));
            con.getEntityManager().remove(informacion);
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

    public InformacionArtista get(InformacionArtista informacionArtista) {
        return (InformacionArtista) con.getEntityManager().createNamedQuery("InformacionArtista.find").setParameter("id", informacionArtista.getId()).getSingleResult();
    }
}

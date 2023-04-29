package com.kinalfy.models.dao;

import com.kinalfy.db.ConexionPU;
import com.kinalfy.models.domain.Album;
import com.kinalfy.models.idao.IAlbumDAO;
import java.util.List;

public class AlbumDaoJPA implements IAlbumDAO {

    private ConexionPU con = ConexionPU.getInstance();

    @Override
    public List<Album> getAll() {
        return con.getEntityManager().createNamedQuery("Album.findAll").getResultList();
    }

    @Override
    public int add(Album album) {
        System.out.println(album);
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().persist(album);
            //con.getEntityManager().remove(con.getEntityManager().contains(estudiante) ? estudiante : con.getEntityManager().merge(estudiante));
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            System.out.println("Se produjo un error al intentar insertar el siguiente registro: " + album);
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }

        return rows;
    }

    @Override
    public int update(Album album) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            con.getEntityManager().merge(album);
            con.getEntityManager().getTransaction().commit();
            rows = 1;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            con.getEntityManager().getTransaction().rollback();
        }
        return rows;
    }

    @Override
    public int delete(Album album) {
        int rows = 0;
        try {
            con.getEntityManager().getTransaction().begin();
            //con.getEntityManager().remove(con.getEntityManager().contains(estudiante) ? estudiante : con.getEntityManager().merge(estudiante));
            con.getEntityManager().remove(album);
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

    public Album get(Album album) {
        return (Album) con.getEntityManager().createNamedQuery("Album.find").setParameter("id", album.getId()).getSingleResult();
    }

}

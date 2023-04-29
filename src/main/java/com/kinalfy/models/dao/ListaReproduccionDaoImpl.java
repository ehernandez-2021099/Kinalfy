/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.ListaReproduccion;
import com.kinalfy.models.idao.IListaReproduccionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaReproduccionDaoImpl implements IListaReproduccionDAO {

    private static final String SQL_SELECT = "SELECT l.id,c.id, c.nombre, l.asignacion_anuncio_id, a.descripcion_de_anuncio, t.id, t.nombre, t.numero_tarjeta, p.id, p.nombre FROM listas_reproduccion AS l\n"
            + "INNER JOIN canciones AS c\n"
            + "ON l.cancion_id=c.id\n"
            + "INNER JOIN asignaciones_anuncios_planes AS aa\n"
            + "ON l.asignacion_anuncio_id = aa.id\n"
            + "INNER JOIN anuncios AS a\n"
            + "ON aa.anuncio_id = a.id\n"
            + "INNER JOIN asignaciones_planes_tarjetas AS apt\n"
            + "ON aa.asignacion_plan_tarjeta_id = apt.id\n"
            + "INNER JOIN tarjetas AS t \n"
            + "ON apt.tarjeta_id = t.id\n"
            + "INNER JOIN planes AS p\n"
            + "ON apt.plan_id = p.id;";
    private static final String SQL_DELETE = "DELETE FROM listas_reproduccion WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO listas_reproduccion(cancion_id,asignacion_anuncio_id) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE listas_reproduccion SET cancion_id=?, asignacion_anuncio_id=? WHERE id= ?";
    private static final String SQL_SELECT_BY_ID = "SELECT id, cancion_id, asignacion_anuncio_id FROM listas_reproduccion WHERE id = ?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private ListaReproduccion lista = null;
    private List<ListaReproduccion> listaRepro = new ArrayList<>();

    @Override
    public List<ListaReproduccion> getAll() {
        try {

            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                lista = new ListaReproduccion(rs.getInt("l.id"),
                        rs.getInt("c.id"),
                        rs.getString("c.nombre"),
                        rs.getInt("l.asignacion_anuncio_id"),
                        rs.getString("a.descripcion_de_anuncio"),
                        rs.getInt("t.id"),
                        rs.getString("t.nombre"),
                        rs.getLong("t.numero_tarjeta"),
                        rs.getInt("p.id"),
                        rs.getString("p.nombre"));

                listaRepro.add(lista);
                System.out.println(listaRepro);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return listaRepro;
    }

    @Override
    public int add(ListaReproduccion lista) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);

            pstmt.setInt(1, lista.getCancionId());
            pstmt.setInt(2, lista.getAsignacionAnuncioId());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO AGREGAR EL REGISTRO: " + lista);
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return rows;
    }

    @Override
    public int update(ListaReproduccion lista) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, lista.getCancionId());
            pstmt.setInt(2, lista.getAsignacionAnuncioId());
            pstmt.setInt(3, lista.getId());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO ACTUALIZAR EL REGISTRO: " + lista);
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return rows;
    }

    @Override
    public int delete(ListaReproduccion lista) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, lista.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("NO SE PUDO ELIMINAR EL REGISTRO CON EL ID: " + lista.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

     public ListaReproduccion get(ListaReproduccion lista) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, lista.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                lista = new ListaReproduccion(rs.getInt("id"),rs.getInt("cancion_id") ,rs.getInt("asignacion_anuncio_id"));
            }
            System.out.println("Lista Repro: " + lista);
        } catch (SQLException e) {
            System.out.println("\nSQLException\n");
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return lista;
    }
}

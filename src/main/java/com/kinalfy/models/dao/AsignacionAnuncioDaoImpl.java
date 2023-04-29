/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.AsignacionAnuncios;
import com.kinalfy.models.idao.IAsignacionAnuncioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsignacionAnuncioDaoImpl implements IAsignacionAnuncioDAO {

    private static final String SQL_SELECT = "SELECT asi.id, asi.asignacion_plan_tarjeta_id, t.id, t.numero_tarjeta, t.nombre, p.id, p.nombre, a.id, a.descripcion_de_anuncio FROM asignaciones_anuncios_planes AS asi\n"
            + "INNER JOIN anuncios AS a\n"
            + "ON asi.anuncio_id = a.id\n"
            + "INNER JOIN asignaciones_planes_tarjetas AS aa\n"
            + "ON asi.asignacion_plan_tarjeta_id = aa.id\n"
            + "INNER JOIN tarjetas AS t\n"
            + "ON aa.tarjeta_id = t.id\n"
            + "INNER JOIN planes AS p\n"
            + "ON aa.plan_id = p.id\n"
            + "ORDER BY asi.id;";
    private static final String SQL_DELETE = "DELETE FROM asignaciones_anuncios_planes WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO asignaciones_anuncios_planes(asignacion_plan_tarjeta_id,anuncio_id)\n"
            + "VALUES(?,?);";
    private static final String SQL_SELECT_BY_ID = "SELECT id, asignacion_plan_tarjeta_id, anuncio_id FROM asignaciones_anuncios_planes\n"
            + "WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE asignaciones_anuncios_planes SET asignacion_plan_tarjeta_id=?,anuncio_id=? \n"
            + "WHERE id=?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private AsignacionAnuncios asignacionA = null;
    private List<AsignacionAnuncios> listaAsignacionA = new ArrayList<>();

    @Override
    public List<AsignacionAnuncios> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                asignacionA = new AsignacionAnuncios(rs.getInt("asi.id"), 
                        rs.getInt("asi.asignacion_plan_tarjeta_id"), 
                        rs.getInt("a.id"), 
                        rs.getInt("t.id"), 
                        rs.getLong("t.numero_tarjeta"), 
                        rs.getString("t.nombre"), 
                        rs.getString("p.nombre"), 
                        rs.getString("a.descripcion_de_anuncio"), 
                        rs.getInt("p.id"));
                listaAsignacionA.add(asignacionA);
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
        return listaAsignacionA;
    }

    @Override
    public int add(AsignacionAnuncios asignacionAnuncio) {
        int row = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, asignacionAnuncio.getAsignacionPlanTarjeta());
            pstmt.setInt(2, asignacionAnuncio.getAnuncioId());
            System.out.println(pstmt.toString());
            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO AGREGAR EL REGISTRO: " + asignacionAnuncio);
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return row;
    }

    @Override
    public int update(AsignacionAnuncios asignacionAnuncio) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, asignacionAnuncio.getAsignacionPlanTarjeta());
            pstmt.setInt(2, asignacionAnuncio.getAnuncioId());
            pstmt.setInt(3, asignacionAnuncio.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO ACTUALIZAR EL REGISTRO: " + asignacionAnuncio);
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
    public int delete(AsignacionAnuncios asignacionAnuncio) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, asignacionAnuncio.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("NO SE PUDO ELIMINAR EL REGISTRO CON EL ID: " + asignacionAnuncio.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    public AsignacionAnuncios get(AsignacionAnuncios asignacion) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, asignacion.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                asignacion = new AsignacionAnuncios(rs.getInt("id"), rs.getInt("asignacion_plan_tarjeta_id"), rs.getInt("anuncio_id"));
            }
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
        return asignacion;
    }

}

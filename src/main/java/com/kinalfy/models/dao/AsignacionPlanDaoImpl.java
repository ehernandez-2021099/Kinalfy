/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.AsignacionesPlanes;
import com.kinalfy.models.idao.IAsignacionPlanesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsignacionPlanDaoImpl implements IAsignacionPlanesDAO {

    private static final String SQL_SELECT = "SELECT a.id,t.id, t.numero_tarjeta, t.nombre,p.id,p.nombre FROM asignaciones_planes_tarjetas AS a\n"
            + "INNER JOIN tarjetas AS t\n"
            + "ON a.tarjeta_id = t.id\n"
            + "INNER JOIN planes AS p\n"
            + "ON a.plan_id = p.id\n"
            + "WHERE a.id > 1";
    private static final String SQL_DELETE = "DELETE FROM asignaciones_planes_tarjetas WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO asignaciones_planes_tarjetas(tarjeta_id,plan_id)\n"
            + "VALUES(?,?);";
    private static final String SQL_SELECT_BY_ID = "SELECT id, tarjeta_id, plan_id FROM asignaciones_planes_tarjetas\n"
            + "WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE asignaciones_planes_tarjetas SET tarjeta_id=?,plan_id=?\n"
            + "WHERE id=?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private AsignacionesPlanes asignacionP = null;
    private List<AsignacionesPlanes> listaAsignacionP = new ArrayList<>();

    @Override
    public List<AsignacionesPlanes> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                asignacionP = new AsignacionesPlanes(rs.getInt("a.id"), 
                        rs.getInt("t.id"), 
                        rs.getLong("t.numero_tarjeta"), 
                        rs.getString("t.nombre"), 
                        rs.getInt("p.id"), 
                        rs.getString("p.nombre"));
                listaAsignacionP.add(asignacionP);
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
        return listaAsignacionP;

    }

    @Override
    public int add(AsignacionesPlanes asignacionP) {
        int row = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, asignacionP.getTarjetaId());
            pstmt.setInt(2, asignacionP.getPlanId());
            System.out.println(pstmt.toString());
            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO AGREGAR EL REGISTRO: " + asignacionP);
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
    public int update(AsignacionesPlanes asignacionP) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, asignacionP.getTarjetaId());
            pstmt.setInt(2, asignacionP.getPlanId());
            pstmt.setInt(3, asignacionP.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO ACTUALIZAR EL REGISTRO: " + asignacionP);
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
    public int delete(AsignacionesPlanes asignacionP) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, asignacionP.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("NO SE PUDO ELIMINAR EL REGISTRO CON EL ID: " + asignacionP.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    public AsignacionesPlanes get(AsignacionesPlanes asignacion) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, asignacion.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                asignacion = new AsignacionesPlanes(rs.getInt("id"), rs.getInt("tarjeta_id"), rs.getInt("plan_id"));
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

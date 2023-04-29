/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.Planes;
import com.kinalfy.models.idao.IPlanDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanDaoImpl implements IPlanDAO{
    private static final String SQL_SELECT = "SELECT id, nombre,precio FROM planes";
    private static final String SQL_DELETE = "DELETE FROM planes WHERE id = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT id, nombre,precio FROM planes WHERE id=?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Planes planes = null;
    private List<Planes> listaPlanes = new ArrayList<>();
    
    @Override
    public List<Planes> getAll() {
        try{
           con = Conexion.getConnection();
           pstmt = con.prepareStatement(SQL_SELECT);
           rs = pstmt.executeQuery();
           
           while(rs.next()){
               planes = new Planes(
                       rs.getInt("id"),
                       rs.getString("nombre"),
                       rs.getFloat("precio"));
                                  
               listaPlanes.add(planes);
           }
        }catch(SQLException e){
            e.printStackTrace(System.out);
        }catch(Exception e){
            e.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return listaPlanes;
        
    }

 
    @Override
    public int add(Planes planes) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Planes planes) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Planes planes) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, planes.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("NO SE PUDO ELIMINAR EL REGISTRO CON EL ID: " + planes.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    public Planes get(Planes plan) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, plan.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                plan = new Planes(rs.getInt("id"),rs.getString("nombre") ,rs.getFloat("precio"));
            }
            System.out.println("estudiante: " + plan);
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
        return plan;
    }
    
}

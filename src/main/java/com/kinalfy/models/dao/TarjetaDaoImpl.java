/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.Tarjeta;
import com.kinalfy.models.idao.ITarjetaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TarjetaDaoImpl implements ITarjetaDAO{
    private static final String SQL_SELECT = "SELECT id, numero_tarjeta,nombre,fecha_vencimiento,tipo_de_tarjeta,empresa FROM tarjetas WHERE id > 2";
    private static final String SQL_DELETE ="DELETE FROM tarjetas WHERE id = ?";
    private static final String SQL_INSERT =   "INSERT INTO tarjetas(numero_tarjeta,nombre, fecha_vencimiento,tipo_de_tarjeta,empresa) VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT id, numero_tarjeta,nombre, fecha_vencimiento,tipo_de_tarjeta,empresa FROM tarjetas WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE tarjetas SET numero_tarjeta=? ,nombre=? , fecha_vencimiento=? ,tipo_de_tarjeta=? ,empresa=? WHERE id= ?";

    
    
    
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Tarjeta tarjeta = null;
    private List<Tarjeta> listaTarjeta = new ArrayList<>();
    
    
    @Override
    public List<Tarjeta> getAll() {
        try{
            System.out.println("REGISTROS");
           con = Conexion.getConnection();
           pstmt = con.prepareStatement(SQL_SELECT);
           rs = pstmt.executeQuery();
           
           while(rs.next()){
               tarjeta = new Tarjeta(
                       rs.getInt("id"),
                       rs.getString("numero_tarjeta"),
                       rs.getString("nombre"),
                       rs.getDate("fecha_vencimiento"),
                       rs.getString("tipo_de_tarjeta"),
                       rs.getString("empresa"));
               
               System.out.println("tarjeta" + tarjeta );
               listaTarjeta.add(tarjeta);
               System.out.println(listaTarjeta);
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
        return listaTarjeta;
        
    }

    public Tarjeta get (Tarjeta tarjeta){
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, tarjeta.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                tarjeta = new Tarjeta(rs.getInt("id"),
                       rs.getString("numero_tarjeta"),
                       rs.getString("nombre"),
                       rs.getDate("fecha_vencimiento"),
                       rs.getString("tipo_de_tarjeta"),
                       rs.getString("empresa"));
            }
            System.out.println("tarjeta: " + tarjeta);
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
        return tarjeta;
    }
 
    @Override
    public int add(Tarjeta tarjeta) {
        int rows = 0;
        try{
         con = Conexion.getConnection() ;
         pstmt = con.prepareStatement(SQL_INSERT);
         pstmt.setString(1, tarjeta.getNumeroTarjeta());
         pstmt.setString(2, tarjeta.getNombrePropietario());
         pstmt.setDate(3, tarjeta.getFechaVencimiento());
         pstmt.setString(4, tarjeta.getTipoTarjeta());
         pstmt.setString(5, tarjeta.getEmpresa());
         
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        }catch(SQLException e){
            System.err.println("NO SE PUDO AGREGAR EL REGISTRO: " + tarjeta);
            e.printStackTrace(System.out);
        }catch (Exception e){
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return rows;
    }

    @Override
    public int update(Tarjeta tarjeta) {
        int rows = 0;
        try{
         con = Conexion.getConnection() ;
         pstmt = con.prepareStatement(SQL_UPDATE);
         pstmt.setString(1, tarjeta.getNumeroTarjeta());
         pstmt.setString(2, tarjeta.getNombrePropietario());
         pstmt.setDate(3, tarjeta.getFechaVencimiento());
         pstmt.setString(4, tarjeta.getTipoTarjeta());
         pstmt.setString(5, tarjeta.getEmpresa());
         pstmt.setInt(6,tarjeta.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        }catch(SQLException e){
            System.err.println("NO SE PUDO ACTUALIZAR EL REGISTRO: " + tarjeta);
            e.printStackTrace(System.out);
        }catch (Exception e){
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return rows;
    }

    @Override
    public int delete(Tarjeta tarjeta) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, tarjeta.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.err.println("Se produjo un error al eliminar el registro: " +tarjeta.getId());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        return rows;
    }
}

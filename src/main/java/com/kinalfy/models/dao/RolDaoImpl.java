
package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.Roles;
import com.kinalfy.models.domain.Tarjeta;
import com.kinalfy.models.idao.IRolesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RolDaoImpl implements IRolesDAO{
    private static final String SQL_SELECT = "SELECT id,descripcion FROM roles";
    private static final String SQL_DELETE = "DELETE FROM roles WHERE id=?";
    private static final String SQL_SELECT_BY_ID = "SELECT id, descripcion FROM roles WHERE id = ?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Roles roles = null;
    private List<Roles> listaRoles = new ArrayList<>();     
    
    
    @Override
    public List<Roles> getAll() {
        try{
           con = Conexion.getConnection();
           pstmt = con.prepareStatement(SQL_SELECT);
           rs = pstmt.executeQuery();
           
           while(rs.next()){
               roles = new Roles(
                       rs.getInt("id"),
                       rs.getString("descripcion"));
               listaRoles.add(roles);
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
        return listaRoles;
    }

    @Override
    public int add(Roles rol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Roles rol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Roles rol) {
       int rows = 0;
        try{
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1,rol.getId()); 
            System.err.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace(System.out);
            System.err.println("Se produjo un erro al intentar eliminar el registro con el id "+ rol.getId());
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return rows;
    }
    
     public Roles get(Roles roles) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, roles.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                roles = new Roles(rs.getInt("id"),rs.getString("descripcion"));
            }
            System.out.println("estudiante: " + roles);
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
        return roles;
    }
    
}

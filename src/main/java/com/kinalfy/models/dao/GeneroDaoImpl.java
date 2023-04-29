/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.Genero;
import com.kinalfy.models.idao.IGeneroDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDaoImpl implements IGeneroDAO {

    private static final String SQL_SELECT = "SELECT id,nombre FROM generos ";
    private static final String SQL_DELETE = "DELETE FROM generos WHERE id = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT id, nombre FROM generos WHERE id = ?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Genero genero = null;
    private List<Genero> listaGenero = new ArrayList<>();

    @Override
    public List<Genero> getAll() {
        try {
            System.out.println("REGISTROS");

            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                genero = new Genero(rs.getInt("id"),
                        rs.getString("nombre"));

                listaGenero.add(genero);
                System.out.println(listaGenero);
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
        return listaGenero;
    }

    @Override
    public int add(Genero genero) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int update(Genero genero) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(Genero genero) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, genero.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("NO SE PUDO ELIMINAR EL REGISTRO CON EL ID: " + genero.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }
     public Genero get(Genero genero) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, genero.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                genero = new Genero(rs.getInt("id"),rs.getString("nombre"));
            }
            System.out.println("estudiante: " + genero);
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
        return genero;
    }
}

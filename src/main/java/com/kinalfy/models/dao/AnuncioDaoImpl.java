/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.Anuncios;
import com.kinalfy.models.idao.IAnuncioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AnuncioDaoImpl implements IAnuncioDAO {

    private static final String SQL_SELECT = "SELECT id,url_de_imagen, descripcion_de_anuncio FROM anuncios WHERE id > 0";
    private static final String SQL_DELETE = "DELETE FROM anuncios WHERE id = ?";
        private static final String SQL_SELECT_BY_ID = "SELECT id, url_de_imagen, descripcion_de_anuncio FROM anuncios WHERE id = ?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Anuncios anuncio = null;
    private List<Anuncios> listaAnuncios = new ArrayList<>();

    @Override
    public List<Anuncios> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                anuncio = new Anuncios(
                        rs.getInt("id"),
                        rs.getString("url_de_imagen"),
                        rs.getString("descripcion_de_anuncio"));
                listaAnuncios.add(anuncio);
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
        return listaAnuncios;
    }

    @Override
    public int add(Anuncios anuncio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Anuncios anuncio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Anuncios anuncio) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, anuncio.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("NO SE PUDO ELIMINAR EL REGISTRO CON EL ID: " + anuncio.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

     public Anuncios get(Anuncios anuncio) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, anuncio.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                anuncio = new Anuncios(rs.getInt("id"),rs.getString("url_de_imagen") ,rs.getString("descripcion_de_anuncio"));
            }
            System.out.println("estudiante: " + anuncio);
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
        return anuncio;
    }
    
}

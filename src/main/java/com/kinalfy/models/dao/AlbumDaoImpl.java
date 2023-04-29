/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.Album;
import com.kinalfy.models.domain.Cancion;
import com.kinalfy.models.idao.IAlbumDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDaoImpl implements IAlbumDAO {

    private static final String SQL_SELECT = "SELECT id,nombre,cantidad_canciones FROM albumes WHERE id > 0";
    private static final String SQL_DELETE = "DELETE FROM albumes WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO albumes(nombre,cantidad_canciones) VALUES (?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT id, nombre, cantidad_canciones FROM albumes WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE albumes SET nombre=?,cantidad_canciones=? WHERE id= ?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Album album = null;
    private List<Album> listaAlbumes = new ArrayList<>();

    @Override
    public List<Album> getAll() {
        try {
            System.out.println("REGISTROS");

            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                album = new Album(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("cantidad_canciones"));

                System.out.println("album" + album);
                listaAlbumes.add(album);
                System.out.println(listaAlbumes);
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
        return listaAlbumes;
    }

    @Override
    public int add(Album album) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, album.getNombre());
            pstmt.setString(2, album.getCantidadCanciones());
            
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO AGREGAR EL REGISTRO: " + album);
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
    public int update(Album album) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, album.getNombre());
            pstmt.setString(2, album.getCantidadCanciones());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO ACTUALIZAR EL REGISTRO: " + album);
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
    public int delete(Album album) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, album.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("NO SE PUDO ELIMINAR EL REGISTRO CON EL ID: " + album.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

     public Album get(Album album) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, album.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                album = new Album(rs.getInt("id"),rs.getString("nombre") ,rs.getString("cantidad_canciones"));
            }
            System.out.println("estudiante: " + album);
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
        return album;
    }
}

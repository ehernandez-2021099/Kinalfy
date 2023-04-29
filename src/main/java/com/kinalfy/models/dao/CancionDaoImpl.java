/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.models.dao;

import com.kinalfy.models.domain.Cancion;
import com.kinalfy.models.idao.ICancionDAO;
import com.kinalfy.db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CancionDaoImpl implements ICancionDAO {

    private static final String SQL_SELECT = "SELECT c.id, c.nombre, a.id, a.nombre FROM canciones AS c\n"
            + "INNER JOIN albumes AS a\n"
            + "ON c.album_artista_id = a.id\n"
            + "WHERE c.id > 0;";
    private static final String SQL_DELETE = "DELETE FROM canciones WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO canciones (nombre,album_artista_id) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE canciones SET nombre=?, album_artista_id=?  WHERE id=?";
    private static final String SQL_SELECT_BY_ID = "SELECT id, nombre, album_artista_id FROM canciones WHERE id=?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Cancion cancion = null;
    private List<Cancion> listaCanciones = new ArrayList<>();

    @Override
    public List<Cancion> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                cancion = new Cancion(rs.getInt("c.id"),
                        rs.getString("c.nombre"),
                        
                        rs.getInt("a.id"),
                        rs.getString("a.nombre"));
                listaCanciones.add(cancion);
                System.out.println(listaCanciones);
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
        return listaCanciones;
    }

    @Override
    public int add(Cancion cancion) {
        int row = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, cancion.getNombre());
           
            pstmt.setInt(2, cancion.getAlbumArtistaId());
            System.out.println(pstmt.toString());
            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO AGREGAR EL REGISTRO: " + cancion);
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
    public int update(Cancion cancion) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, cancion.getNombre());          
            pstmt.setInt(2, cancion.getAlbumArtistaId());
            pstmt.setInt(3, cancion.getId());
            
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO ACTUALIZAR EL REGISTRO: " + cancion);
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
    public int delete(Cancion cancion) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, cancion.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("NO SE PUDO ELIMINAR EL REGISTRO CON EL ID: " + cancion.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }
    
    public Cancion get(Cancion cancion) {
       try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, cancion.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                cancion = new Cancion(rs.getInt("id"), rs.getString("nombre"), rs.getInt("album_artista_id"));
            }
            System.out.println("CANCION: " + cancion);
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
        return cancion;
    }

}

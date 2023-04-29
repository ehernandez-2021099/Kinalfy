/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.Artista;
import com.kinalfy.models.idao.IArtistaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistaDaoImpl implements IArtistaDAO {

    private static final String SQL_SELECT = "SELECT id,nombre,informacion_artista_id FROM artistas";
    private static final String SQL_DELETE = "DELETE  FROM artistas WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE artistas SET nombre=?,informacion_artista_id=? WHERE id= ?";
    private static final String SQL_SELECT_BY_ID = "SELECT id, nombre, informacion_artista_id FROM artistas WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO artistas(nombre,informacion_artista_id) VALUES (?,?)";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Artista artista = null;
    private List<Artista> listaArtista = new ArrayList<>();

    @Override
    public List<Artista> getAll() {
        try {

            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                artista = new Artista(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("informacion_artista_id"));

                listaArtista.add(artista);
                System.out.println(listaArtista);
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
        return listaArtista;
    }

    @Override
    public int add(Artista artista) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, artista.getNombre());
            pstmt.setInt(2, artista.getInfoArtistaId());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO AGREGAR EL REGISTRO: " + artista);
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
    public int update(Artista artista) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            
            pstmt.setString(1, artista.getNombre());
            pstmt.setInt(2, artista.getInfoArtistaId());
            pstmt.setInt(3, artista.getId());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO ACTUALIZAR EL REGISTRO: " + artista);
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
    public int delete(Artista artista) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, artista.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("NO SE PUDO ELIMINAR EL REGISTRO CON EL ID: " + artista.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    public Artista get(Artista artista) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, artista.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                artista = new Artista(rs.getInt("id"), rs.getString("nombre"), rs.getInt("informacion_artista_id"));
            }
            System.out.println("artista: " + artista);
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
        return artista;
    }
}

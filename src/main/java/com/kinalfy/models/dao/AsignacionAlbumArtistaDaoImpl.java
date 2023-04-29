/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.AsignacionAlbumArtista;
import com.kinalfy.models.idao.IAsignacionAlbumArtistaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsignacionAlbumArtistaDaoImpl implements IAsignacionAlbumArtistaDAO {

    private static final String SQL_SELECT = "SELECT asi.id, a.id,a.nombre,ar.id, ar.nombre FROM asignaciones_albumes_artistas AS asi\n"
            + "INNER JOIN albumes AS a\n"
            + "ON asi.album_id = a.id\n"
            + "INNER JOIN artistas AS ar\n"
            + "ON asi.artista_id = ar.id;";
    private static final String SQL_DELETE = "DELETE FROM asignaciones_albumes_artistas WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO asignaciones_albumes_artistas(artista_id,album_id)\n"
            + "VALUES(?,?);";
    private static final String SQL_SELECT_BY_ID = "SELECT id, artista_id, album_id FROM asignaciones_albumes_artistas\n"
            + "WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE asignaciones_albumes_artistas SET artista_id=?,album_id=?\n"
            + "WHERE id=?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private AsignacionAlbumArtista artista = null;
    private List<AsignacionAlbumArtista> listaArtista = new ArrayList<>();

   @Override
    public List<AsignacionAlbumArtista> getAll() {
        try {

            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                artista = new AsignacionAlbumArtista(rs.getInt("asi.id"),rs.getInt("ar.id"), rs.getInt("a.id"), rs.getString("a.nombre"),rs.getString("ar.nombre"));

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
    public int add(AsignacionAlbumArtista asignacionAlbumArtista) {
        int row = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, asignacionAlbumArtista.getArtistaId());
            pstmt.setInt(2, asignacionAlbumArtista.getAlbumId());
            System.out.println(pstmt.toString());
            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO AGREGAR EL REGISTRO: " + asignacionAlbumArtista);
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
    public int update(AsignacionAlbumArtista asignacionAlbumArtista) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, asignacionAlbumArtista.getArtistaId());
            pstmt.setInt(2, asignacionAlbumArtista.getAlbumId());
            pstmt.setInt(3, asignacionAlbumArtista.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO ACTUALIZAR EL REGISTRO: " + asignacionAlbumArtista);
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
    public int delete(AsignacionAlbumArtista asignacionAlbumArtista) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, asignacionAlbumArtista.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("NO SE PUDO ELIMINAR EL REGISTRO CON EL ID: " + asignacionAlbumArtista.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    public AsignacionAlbumArtista get(AsignacionAlbumArtista asignacion) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, asignacion.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                asignacion = new AsignacionAlbumArtista(rs.getInt("id"), rs.getInt("artista_id"), rs.getInt("album_id"));
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

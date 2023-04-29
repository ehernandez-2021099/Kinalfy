/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.AsignacionGeneroArtista;
import com.kinalfy.models.idao.IAsignacionGeneroArtistaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsignacionGeneroArtistaDaoImpl implements IAsignacionGeneroArtistaDAO {

    private static final String SQL_SELECT = "SELECT asi.id, asi.genero_id, g.nombre,asi.artista_id, a.nombre FROM asignaciones_artistas_generos AS asi\n"
            + "INNER JOIN generos AS g\n"
            + "ON asi.genero_id = g.id\n"
            + "INNER JOIN artistas AS a\n"
            + "ON asi.artista_id = a.id";
    private static final String SQL_DELETE = "DELETE FROM asignaciones_artistas_generos WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO asignaciones_artistas_generos(genero_id,artista_id)\n"
            + "VALUES(?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT id, genero_id, artista_id FROM asignaciones_artistas_generos\n"
            + "WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE asignaciones_artistas_generos SET genero_id=?,artista_id=? \n"
            + "WHERE id=?";
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private AsignacionGeneroArtista aga = null;
    private List<AsignacionGeneroArtista> listaAga = new ArrayList<>();

    @Override
    public List<AsignacionGeneroArtista> getAll() {
        try {
            System.out.println("REGISTROS");

            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                aga = new AsignacionGeneroArtista(rs.getInt("asi.id"), 
                        rs.getInt("asi.genero_id"), 
                        rs.getString("g.nombre"), 
                        rs.getInt("asi.artista_id"),
                        rs.getString("a.nombre"));

                listaAga.add(aga);
                System.out.println(listaAga);
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
        return listaAga;
    }

    @Override
    public int add(AsignacionGeneroArtista aga) {
        int row = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, aga.getGeneroId());
            pstmt.setInt(2, aga.getArtistaId());
            System.out.println(pstmt.toString());
            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO AGREGAR EL REGISTRO: " + aga);
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
    public int update(AsignacionGeneroArtista aga) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, aga.getGeneroId());
            pstmt.setInt(2, aga.getArtistaId());
            pstmt.setInt(3, aga.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO ACTUALIZAR EL REGISTRO: " + aga);
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
    public int delete(AsignacionGeneroArtista aga) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, aga.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("NO SE PUDO ELIMINAR EL REGISTRO CON EL ID: " + aga.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    public AsignacionGeneroArtista get(AsignacionGeneroArtista asignacion) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, asignacion.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                asignacion = new AsignacionGeneroArtista(rs.getInt("id"), rs.getInt("genero_id"), rs.getInt("artista_id"));
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

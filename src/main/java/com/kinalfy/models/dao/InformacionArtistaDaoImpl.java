/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.InformacionArtista;
import com.kinalfy.models.idao.IInformacionArtistaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformacionArtistaDaoImpl implements IInformacionArtistaDAO {

    private static final String SQL_SELECT = "SELECT id, facebook, instagram, youtube, descripcion, imagen FROM informacion_artistas";
    private static final String SQL_DELETE = "DELETE FROM informacion_artistas WHERE id = ?";

    private static final String SQL_INSERT = "INSERT INTO informacion_artistas(facebook,instagram, youtube, descripcion, imagen) VALUES (?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT id, facebook, instagram, youtube, descripcion, imagen FROM informacion_artistas WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE informacion_artistas SET facebook=?, instagram=?, youtube=?, descripcion=?, imagen=? WHERE id= ?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private InformacionArtista info = null;
    private List<InformacionArtista> listaInfo = new ArrayList<>();

    @Override
    public List<InformacionArtista> getAll() {
        try {
            System.out.println("REGISTROS");

            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                info = new InformacionArtista(rs.getInt("id"),
                        rs.getString("facebook"),
                        rs.getString("instagram"),
                        rs.getString("youtube"),
                        rs.getString("descripcion"),
                        rs.getString("imagen"));

                listaInfo.add(info);
                System.out.println(listaInfo);
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
        return listaInfo;
    }

    @Override
    public int add(InformacionArtista informacion) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, informacion.getFacebook());
            pstmt.setString(2, informacion.getInstagram());
            pstmt.setString(3, informacion.getYoutube());
            pstmt.setString(4, informacion.getDescripcion());
            pstmt.setString(5, informacion.getImagen());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO AGREGAR EL REGISTRO: " + informacion);
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
    public int update(InformacionArtista informacion) {
 int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, informacion.getFacebook());
            pstmt.setString(2, informacion.getInstagram());
            pstmt.setString(3, informacion.getYoutube());
            pstmt.setString(4, informacion.getDescripcion());
            pstmt.setString(5, informacion.getImagen());
            pstmt.setInt(6, informacion.getId());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO ACTUALIZAR EL REGISTRO: " + informacion);
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pstmt);
            Conexion.close(con);
        }
        return rows;    }

    @Override
    public int delete(InformacionArtista informacion) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, informacion.getId());
            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("NO SE PUDO ELIMINAR EL REGISTRO CON EL ID: " + informacion.getId());
            e.printStackTrace(System.out);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }
    
    public InformacionArtista get(InformacionArtista info) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, info.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                info = new InformacionArtista(rs.getInt("id"),rs.getString("facebook") ,rs.getString("instagram"), rs.getString("youtube"), rs.getString("descripcion"), rs.getString("imagen"));
            }
            System.out.println("estudiante: " + info);
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
        return info;
    }
}

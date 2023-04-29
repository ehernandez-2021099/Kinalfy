/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.Tarjeta;
import com.kinalfy.models.domain.Usuario;
import com.kinalfy.models.idao.IUsuariosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements IUsuariosDAO {

    private static final String SQL_SELECT = "SELECT u.user, u.password, p.id, CONCAT(p.nombre_1, \" \", p.nombre_2,\" \", p.apellido_1,\" \", p.apellido_2) AS nombre,r.id, r.descripcion, u.lista_reproduccion_id,c.id, c.nombre AS canciones FROM usuarios AS u\n"
            + "INNER JOIN personas AS p\n"
            + "ON u.persona_id = p.id\n"
            + "INNER JOIN roles AS r\n"
            + "ON u.rol_id = r.id\n"
            + "INNER JOIN listas_reproduccion AS li\n"
            + "ON u.lista_reproduccion_id = li.id\n"
            + "INNER JOIN canciones AS c\n"
            + "ON li.cancion_id = c.id;";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE user=?";

    private static final String SQL_INSERT = "INSERT INTO usuarios(user,password, rol_id,persona_id,lista_reproduccion_id, asignacion_plan_id) VALUES (?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT user, password,  persona_id,rol_id, lista_reproduccion_id, asignacion_plan_id FROM usuarios WHERE user = ?";
    private static final String SQL_UPDATE = "UPDATE usuarios SET  password=?, rol_id=?, persona_id, lista_reproduccion_id, asignacion_plan_id WHERE user= ?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Usuario usuario = null;
    private List<Usuario> listaUsuario = new ArrayList<>();

    @Override
    public List<Usuario> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario(rs.getString("u.user"),
                        rs.getString("u.password"),
                        rs.getInt("p.id"),
                        rs.getString("nombre"),
                        rs.getInt("r.id"),
                        rs.getString("r.descripcion"),
                        rs.getInt("u.lista_reproduccion_id"),
                        rs.getInt("c.id"),
                        rs.getString("canciones"));
                listaUsuario.add(usuario);
                System.out.println("USER ALL: " + usuario);
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
        return listaUsuario;
    }

    @Override
    public int add(Usuario usuario) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, usuario.getUser());
            pstmt.setString(2, usuario.getPass());
            pstmt.setInt(3, usuario.getPersonaId());
            pstmt.setInt(4, usuario.getRolId());
            pstmt.setInt(5, usuario.getListaRepoduccionId());
            pstmt.setInt(6, usuario.getAsignacionPlanId());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO AGREGAR EL REGISTRO: " + usuario);
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
    public int update(Usuario usuario) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            
            pstmt.setString(1, usuario.getPass());
            pstmt.setInt(2, usuario.getPersonaId());
            pstmt.setInt(3, usuario.getRolId());
            pstmt.setInt(4, usuario.getListaRepoduccionId());
            pstmt.setInt(5, usuario.getAsignacionPlanId());
            pstmt.setString(6, usuario.getUser());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO ACTUALIZAR EL REGISTRO: " + usuario);
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
    public int delete(Usuario usuario) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setString(1, usuario.getUser());
            System.err.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.err.println("Se produjo un erro al intentar eliminar el registro con el id " + usuario.getUser());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }
    
    public Usuario get(Usuario usuario) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setString(1, usuario.getUser());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(rs.getString("user"),rs.getString("password") ,rs.getInt("persona_id"), rs.getInt("rol_id"), rs.getInt("lista_reproduccion_id"), rs.getInt("asignacion_plan_id"));
            }
            System.out.println("estudiante: " + usuario);
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
        return usuario;
    }

}

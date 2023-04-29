package com.kinalfy.models.dao;

import com.kinalfy.db.Conexion;
import com.kinalfy.models.domain.Persona;
import com.kinalfy.models.domain.Tarjeta;
import com.kinalfy.models.idao.IPersonaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoImpl implements IPersonaDAO {

    private static final String SQL_SELECT = "SELECT id, nombre_1 ,nombre_2,nombre_3,apellido_1,apellido_2,correo FROM personas";
    private static final String SQL_DELETE = "DELETE FROM personas WHERE id=?";

    private static final String SQL_INSERT = "INSERT INTO personas (nombre_1,nombre_2, nombre_3, apellido_1, appellido_2, correo) VALUES (?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "SELECT id, nombre_1, nombre_2, nombre_3, apellido_1, apellido_2, correo FROM personas WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE albumes SET nombre_1=?,nombre_2=?, nombre_3=?, apellido_1=?, apellido_2=?, correo=? WHERE id= ?";

    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Persona persona = null;
    private List<Persona> listaPersona = new ArrayList<>();

    @Override
    public List<Persona> getAll() {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                persona = new Persona(
                        rs.getInt("id"),
                        rs.getString("nombre_1"),
                        rs.getString("nombre_2"),
                        rs.getString("nombre_3"),
                        rs.getString("apellido_1"),
                        rs.getString("apellido_2"),
                        rs.getString("correo"));

                listaPersona.add(persona);
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
        return listaPersona;
    }

    @Override
    public int add(Persona persona) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, persona.getNombre1());
            pstmt.setString(2, persona.getNombre2());
            pstmt.setString(3, persona.getNombre3());
            pstmt.setString(4, persona.getApellido1());
            pstmt.setString(5, persona.getApellido2());
            pstmt.setString(6, persona.getCorreo());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO AGREGAR EL REGISTRO: " + persona);
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
    public int update(Persona persona) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
           pstmt.setString(1, persona.getNombre1());
            pstmt.setString(2, persona.getNombre2());
            pstmt.setString(3, persona.getNombre3());
            pstmt.setString(4, persona.getApellido1());
            pstmt.setString(5, persona.getApellido2());
            pstmt.setString(6, persona.getCorreo());
            pstmt.setInt(7, persona.getId());

            System.out.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("NO SE PUDO ACTUALIZAR EL REGISTRO: " + persona);
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
    public int delete(Persona persona) {
        int rows = 0;
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, persona.getId());
            System.err.println(pstmt.toString());
            rows = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.err.println("Se produjo un erro al intentar eliminar el registro con el id " + persona.getId());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return rows;
    }

    public Persona get(Persona persona) {
        try {
            con = Conexion.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_ID);
            pstmt.setInt(1, persona.getId());
            System.out.println(pstmt.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                persona = new Persona(rs.getInt("id"),rs.getString("nombre_1") ,rs.getString("nombre_2"), rs.getString("nombre_3"), rs.getString("apellido_1"), rs.getString("apellido_2"), rs.getString("correo"));
            }
            System.out.println("persona: " + persona);
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
        return persona;
    }
    
}

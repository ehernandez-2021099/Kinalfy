/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.db;


import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String HOST = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String DB = "db_reproductor_musica_in5bm";
    private static final String USER = "kinal"; 
    private static final String PASS = "admin";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static BasicDataSource instance;

    public static DataSource getInstance() {
        if (instance == null) {

            instance = new BasicDataSource();
            instance.setUrl(URL);
            instance.setUsername(USER);
            instance.setPassword(PASS);
            instance.setInitialSize(25);

        }
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }

    public static void close(ResultSet rs) {
        if(rs != null){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        }
    }

    public static void close(PreparedStatement psmt) {
        if (psmt != null){
        try {
            psmt.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        }
    }

    public static void close(Connection con) {
        if(con != null){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        }
    }

}

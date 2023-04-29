/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.controllers;

import com.kinalfy.models.domain.Cancion;
import com.kinalfy.models.dao.CancionDaoImpl;
import java.io.IOException;
import java.sql.Time;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ServletCancion")
public class ServletCancion extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarCancion(request, response);
                    break;
                case "actualizar":
                    actualizarCancion(request, response);
                    break;
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "listar":
                    // Acciones para listar los registros 
                    listarCancion(request, response);
                    break;
                case "editar":
                    editarCancion(request, response);
                    break;
                case "eliminar":
                    eliminarCancion(request, response);
                    break;
            }
        }
    }

    private void listarCancion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Cancion> listaCanciones = new CancionDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaCanciones);
        response.sendRedirect("canciones/cancion.jsp");
    }

    private void eliminarCancion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCancion = Integer.parseInt(request.getParameter("carne"));
        Cancion cancion = new Cancion(idCancion);
        int registrosEliminados = new CancionDaoImpl().delete(cancion);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        listarCancion(request, response);
    }

    private void insertarCancion(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String nombre = request.getParameter("nombre");
       
        int albumId = Integer.valueOf(request.getParameter("albumId"));

        Cancion canciones = new Cancion(nombre,  albumId);

        System.out.println(
                "Estudiante: " + canciones);

        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new CancionDaoImpl().add(canciones);

        listarCancion(request, response);
    }

    private void actualizarCancion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");  
        int albumId = Integer.valueOf(request.getParameter("albumId"));
        System.out.println("Dentro de actualizar");
        Cancion cancion = new Cancion(id, nombre, albumId);
        System.out.println("Cancion UPDATE: " + cancion);

        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new CancionDaoImpl().update(cancion);
        listarCancion(request, response);
    }

    private void editarCancion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Recuperar el id del estudiante
        int idCancion = Integer.parseInt(request.getParameter("id"));

        //Crear un objeto tipo estudiante
        Cancion cancion = new CancionDaoImpl().get(new Cancion(idCancion));
        System.out.println(cancion.toString());

        HttpSession sesion = request.getSession();
        sesion.setAttribute("cancion", cancion);
        response.sendRedirect(request.getContextPath() + "/" + "canciones/editar-cancion.jsp");

    }

}

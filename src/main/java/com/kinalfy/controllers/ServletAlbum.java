/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.controllers;

import com.kinalfy.models.dao.AlbumDaoImpl;
import com.kinalfy.models.dao.AlbumDaoJPA;
import com.kinalfy.models.domain.Album;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletAlbum")
public class ServletAlbum extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarAlbum(request, response);
                    break;
                case "actualizar":
                    actualizarAlbum(request, response);
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
                    listarAlbum(request, response);
                    break;
                case "editar":
                    editarAlbum(request, response);
                    break;
                case "eliminar":
                    eliminarAlbum(request, response);
                    break;
            }
        }
    }

    private void listarAlbum(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Album> listaAlbumes = new AlbumDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaAlbumes);
        response.sendRedirect("albumes/album.jsp");
    }

    private void eliminarAlbum(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idAlbum = Integer.parseInt(request.getParameter("id"));
        Album album = new AlbumDaoJPA().get(new Album(idAlbum));
        int registrosEliminados = new AlbumDaoJPA().delete(album);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        listarAlbum(request, response);
    }
    
    private void insertarAlbum(HttpServletRequest request, HttpServletResponse response) throws IOException{

        int id = Integer.valueOf(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String cantidadCanciones = request.getParameter("cantidadCanciones");
        
        
        Album albumes = new Album(id,nombre, cantidadCanciones);
        System.out.println("Estudiante: " +albumes);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new AlbumDaoJPA().add(albumes);
        listarAlbum(request, response);
    }
    
     private void actualizarAlbum(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String cantidad = String.valueOf(request.getParameter("cantidadCanciones"));
        System.out.println("Dentro de actualizar");
        Album album = new Album(id, nombre, cantidad);
        System.out.println("Album UPDATE: " + album);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new AlbumDaoJPA().update(album);
        listarAlbum(request, response);
    }
     
     private void editarAlbum(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Recuperar el id del estudiante
        int idAlbum = Integer.parseInt(request.getParameter("id"));
        
        //Crear un objeto tipo estudiante
        Album album = new AlbumDaoImpl().get(new Album(idAlbum));
        System.out.println(album.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("album", album);
        response.sendRedirect(request.getContextPath()+ "/" + "albumes/editar-album.jsp");
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kinalfy.controllers;

import com.kinalfy.models.dao.AnuncioDaoImpl;
import com.kinalfy.models.dao.AnuncioDaoJPA;
import com.kinalfy.models.domain.Anuncios;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletAnuncios")
public class ServletAnuncios extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
         request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarAnuncio(request, response);
                    break;
                case "actualizar":
                    actualizarAnuncio(request, response);
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
                    listarAnuncios(request, response);
                    break;
                case "editar":
                    editarAnuncio(request, response);
                    break;
                case "eliminar":
                    eliminarAnuncio(request, response);
                    break;
            }
        }
    }

    private void listarAnuncios(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Anuncios> listaAnuncios = new AnuncioDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaAnuncios);
        response.sendRedirect("anuncios/anuncio.jsp");
    }

     private void eliminarAnuncio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idAnuncio = Integer.parseInt(request.getParameter("id"));
        Anuncios anuncio = new AnuncioDaoJPA().get(new Anuncios(idAnuncio));
        int registrosEliminados = new AnuncioDaoJPA().delete(anuncio);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        listarAnuncios(request, response);
    }
     
      private void insertarAnuncio(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.valueOf(request.getParameter("id"));
          String nombre = request.getParameter("nombre");
        String url = request.getParameter("url");
        
      Anuncios anuncio = new Anuncios(id,url,nombre);
        System.out.println("Estudiante: " +anuncio);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new AnuncioDaoJPA().add(anuncio);
        listarAnuncios(request, response);
    }
    
     private void actualizarAnuncio(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String url = request.getParameter("url");
        System.out.println("Dentro de actualizar");
        Anuncios anuncio = new Anuncios(id, url, nombre);
        System.out.println("Anuncio UPDATE: " + anuncio);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new AnuncioDaoJPA().update(anuncio);
        listarAnuncios(request, response);
    }
     
     private void editarAnuncio(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Recuperar el id del estudiante
        int idAnuncio = Integer.parseInt(request.getParameter("id"));
        
        //Crear un objeto tipo estudiante
        Anuncios anuncio = new AnuncioDaoImpl().get(new Anuncios(idAnuncio));
        System.out.println(anuncio.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("anuncio", anuncio);
        response.sendRedirect(request.getContextPath()+ "/" + "anuncios/editar-anuncio.jsp");
        
    }

}


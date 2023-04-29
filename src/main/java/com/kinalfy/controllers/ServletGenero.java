package com.kinalfy.controllers;

import com.kinalfy.models.dao.GeneroDaoImpl;
import com.kinalfy.models.dao.GeneroDaoJPA;
import com.kinalfy.models.domain.Genero;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ServletGenero")
public class ServletGenero extends HttpServlet{



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
         request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarGenero(request, response);
                    break;
                case "actualizar":
                    actualizarGenero(request, response);
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
                    listarGenero(request, response);
                    break;
               case "editar":
                    editarGenero(request, response);
                    break;
                case "eliminar":
                    eliminarGenero(request, response);
                    break;
            }
        }
    }

    private void listarGenero(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Genero> listaGenero = new GeneroDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaGenero);
        response.sendRedirect("generos/genero.jsp");
    }
     private void eliminarGenero(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idGenero = Integer.parseInt(request.getParameter("id"));
        Genero genero = new GeneroDaoJPA().get(new Genero(idGenero));
        int registrosEliminados = new GeneroDaoJPA().delete(genero);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        listarGenero(request, response);
    }
     
     private void insertarGenero(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String nombre = request.getParameter("nombre");
        
        
      Genero genero = new Genero(nombre);
        System.out.println("Estudiante: " +genero);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new GeneroDaoJPA().add(genero);
        listarGenero(request, response);
    }
    
     private void actualizarGenero(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        System.out.println("Dentro de actualizar");
        Genero genero = new Genero(id, nombre);
        System.out.println("Genero UPDATE: " + genero);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new GeneroDaoJPA().update(genero);
        listarGenero(request, response);
    }
     
     private void editarGenero(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Recuperar el id del estudiante
        int idGenero = Integer.parseInt(request.getParameter("id"));
        
        //Crear un objeto tipo estudiante
        Genero genero = new GeneroDaoImpl().get(new Genero(idGenero));
        System.out.println(genero.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("genero", genero);
        response.sendRedirect(request.getContextPath()+ "/" + "generos/editar-genero.jsp");
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kinalfy.controllers;

import com.kinalfy.models.dao.RolDaoImpl;
import com.kinalfy.models.dao.RolDaoJPA;
import com.kinalfy.models.domain.Roles;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ServletRol")
public class ServletRol extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarRoles(request, response);
                    break;
                case "actualizar":
                    actualizarRoles(request, response);
                    break;
            }

        }
    } 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
    
        String accion = request.getParameter("accion");
        
        if(accion != null){
            switch(accion){
                case "listar":
                    listarRoles(request, response);
                    //acciones...
                    break;
                case "editar":
                    editarRoles(request, response);
                    break;
                case "eliminar":
                    //...
                    eliminarRoles(request, response);
                    break;
            }
            
        }
           
        
    }
    private void listarRoles(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Roles> listaRoles = new RolDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaRoles);
        response.sendRedirect("roles/rol.jsp");
    }
    
    private void eliminarRoles(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idRoles = Integer.parseInt(request.getParameter("rol"));
        Roles rol = new RolDaoJPA().get(new Roles(idRoles));
        int registrosEliminados = new RolDaoJPA().delete(rol);

        listarRoles(request, response);

       if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        
    }
    
     private void insertarRoles(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String descripcion = request.getParameter("descripcion");

        
        
        Roles roles = new Roles(descripcion);
        System.out.println("Estudiante: " +roles);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new RolDaoJPA().add(roles);
        listarRoles(request, response);
    }
    
     private void actualizarRoles(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        System.out.println("Dentro de actualizar");
        Roles album = new Roles(id, descripcion);
        System.out.println("Roles UPDATE: " + album);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new RolDaoJPA().update(album);
        listarRoles(request, response);
    }
     
     private void editarRoles(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Recuperar el id del estudiante
        int idRoles = Integer.parseInt(request.getParameter("id"));
        
        //Crear un objeto tipo estudiante
        Roles roles = new RolDaoImpl().get(new Roles(idRoles));
        System.out.println(roles.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rol", roles);
        response.sendRedirect(request.getContextPath()+ "/" + "roles/editar-rol.jsp");
        
    }
   
     
}

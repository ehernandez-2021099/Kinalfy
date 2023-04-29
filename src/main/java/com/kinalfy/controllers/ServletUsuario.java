/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kinalfy.controllers;

import com.kinalfy.models.dao.UsuarioDaoImpl;
import com.kinalfy.models.domain.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
         request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarUsuario(request, response);
                    break;
                case "actualizar":
                    actualizarUsuario(request, response);
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
                    listarUsuarios(request, response);
                    //acciones...
                    break;
                case "editar":
                    editarUsuario(request, response);
                    break;
                case "eliminar":
                    //...
                    eliminarUsuario(request, response);
                    break;
            }
            
        }
           
        
    }
    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Usuario> listaUsuarios = new UsuarioDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaUsuarios);
        response.sendRedirect("usuarios/usuario.jsp");
    }
    
    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idUsuario = request.getParameter("user");
        Usuario usuario = new Usuario(idUsuario);
        int registrosEliminados = new UsuarioDaoImpl().delete(usuario);



       if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        listarUsuarios(request, response);
    }
    
    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException{

        String user = request.getParameter("user");
        String pass = request.getParameter("password");
        int personaId = Integer.valueOf(request.getParameter("perosnaId"));
        int rolId = Integer.valueOf(request.getParameter("rolId"));
        int listaId = Integer.valueOf(request.getParameter("listaId"));
        int asigId = Integer.valueOf(request.getParameter("asigId"));
        
        
        Usuario usuarios = new Usuario(user ,pass, personaId, rolId, listaId, asigId);
        System.out.println("Estudiante: " +usuarios);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new UsuarioDaoImpl().add(usuarios);
        listarUsuarios(request, response);
    }
    
     private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String pass = request.getParameter("password");
        int personaId = Integer.valueOf(request.getParameter("personaId"));
        int rolId = Integer.valueOf(request.getParameter("rolId"));
        int listaId = Integer.valueOf(request.getParameter("listaId"));
        int asigId = Integer.valueOf(request.getParameter("asigId"));
        
        System.out.println("Dentro de actualizar");
        Usuario usuario = new Usuario( pass, personaId, rolId, listaId, asigId);
        System.out.println("Album UPDATE: " + usuario);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new UsuarioDaoImpl().update(usuario);
        listarUsuarios(request, response);
    }
     
     private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Recuperar el id del estudiante
        String user = request.getParameter("user");
        
        //Crear un objeto tipo estudiante
        Usuario usuario = new UsuarioDaoImpl().get(new Usuario(user));
        System.out.println(usuario.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", usuario);
        response.sendRedirect(request.getContextPath()+ "/" + "usuarios/editar-usuario.jsp");
        
    }
}

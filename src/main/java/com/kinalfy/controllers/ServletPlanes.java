/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kinalfy.controllers;

import com.kinalfy.models.dao.PlanDaoImpl;
import com.kinalfy.models.dao.PlanDaoJPA;
import com.kinalfy.models.domain.Planes;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/ServletPlanes")
public class ServletPlanes extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
         request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarPlanes(request, response);
                    break;
                case "actualizar":
                    actualizarPlan(request, response);
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
                    listarPlanes(request, response);
                    //acciones...
                    break;
                case "editar":
                    editarPlan(request,response);
                    break;
                case "eliminar":
                    eliminarPlanes(request, response);
                    break;
            }
            
        }
           
        
    }
    private void listarPlanes(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Planes> listaPlanes = new PlanDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaPlanes);
        response.sendRedirect("planes/planes.jsp");
    }
    
     private void eliminarPlanes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idPlan = Integer.parseInt(request.getParameter("id"));
        Planes plan = new PlanDaoJPA().get(new Planes(idPlan));
        int registrosEliminados = new PlanDaoJPA().delete(plan);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        listarPlanes(request, response);
    }

      private void insertarPlanes(HttpServletRequest request, HttpServletResponse response) throws IOException{
          String nombre = request.getParameter("nombre");
        Float precio = Float.parseFloat(request.getParameter("precio"));
        
      Planes plan = new Planes(nombre,precio);
        System.out.println("Estudiante: " +plan);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new PlanDaoJPA().add(plan);
        listarPlanes(request, response);
    }
    
     private void actualizarPlan(HttpServletRequest request, HttpServletResponse response) throws IOException{
       int id = Integer.valueOf(request.getParameter("id"));
          String nombre = request.getParameter("nombre");
        Float precio = Float.parseFloat(request.getParameter("precio"));
        System.out.println("Dentro de actualizar");
        Planes plan = new Planes(id, nombre, precio);
        System.out.println("Anuncio UPDATE: " + plan);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new PlanDaoJPA().update(plan);
        listarPlanes(request, response);
    }
     
     private void editarPlan(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Recuperar el id del estudiante
        int idAnuncio = Integer.parseInt(request.getParameter("id"));
        
        //Crear un objeto tipo estudiante
        Planes plan = new PlanDaoImpl().get(new Planes(idAnuncio));
        System.out.println(plan.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("plan", plan);
        response.sendRedirect(request.getContextPath()+ "/" + "planes/editar-plan.jsp");
        
    }
}

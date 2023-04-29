/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.controllers;

import com.kinalfy.models.dao.PersonaDaoImpl;
import com.kinalfy.models.dao.PersonaDaoJPA;
import com.kinalfy.models.domain.Persona;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletPersona")
public class ServletPersona extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarPersona(request, response);
                    break;
                case "actualizar":
                    actualizarPersona(request, response);
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
                    listarPersonas(request, response);
                    //acciones...
                    break;
                case "editar":
                    editarPersona(request, response);
                    break;
                case "eliminar":

                    eliminarPersona(request, response);
                    break;
            }

        }

    }

    private void listarPersonas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Persona> listarPersonas = new PersonaDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listarPersonas);
        response.sendRedirect("personas/persona.jsp");
    }

    private void eliminarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idPersona = Integer.parseInt(request.getParameter("persona"));
        Persona persona = new PersonaDaoJPA().get(new Persona(idPersona));
        int registrosEliminados = new PersonaDaoJPA().delete(persona);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        } else {
            System.out.println("error");
        }
        listarPersonas(request, response);
    }
    private void insertarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException{

        
        String nombre = request.getParameter("nombre1");
        String nombre2 = request.getParameter("nombre2");
        String nombre3 = request.getParameter("nombre3");
        String apellido = request.getParameter("apellido1");
        String apellido2= request.getParameter("apellido2");
        String correo = request.getParameter("correo");
        
        
        Persona persona = new Persona(nombre,nombre2, nombre3, apellido, apellido2, correo );
        System.out.println("Estudiante: " +persona);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new PersonaDaoJPA().add(persona);
        listarPersonas(request, response);
    }
    
     private void actualizarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre1");
        String nombre2 = String.valueOf(request.getParameter("nombre2"));
        String nombre3 = String.valueOf(request.getParameter("nombre3"));
        String apellido1 = String.valueOf(request.getParameter("apellido1"));
        String apellido2 = String.valueOf(request.getParameter("apellido2"));
        String correo = String.valueOf(request.getParameter("correo"));
        System.out.println("Dentro de actualizar");
        Persona persona = new Persona(id, nombre, nombre2, nombre3, apellido1, apellido2, correo);
        System.out.println("Album UPDATE: " + persona);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new PersonaDaoJPA().update(persona);
        listarPersonas(request, response);
    }
     
     private void editarPersona(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Recuperar el id del estudiante
        int idPersona = Integer.parseInt(request.getParameter("id"));
        
        //Crear un objeto tipo estudiante
        Persona persona = new PersonaDaoImpl().get(new Persona(idPersona));
        System.out.println(persona.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("persona", persona);
        response.sendRedirect(request.getContextPath()+ "/" + "personas/editar-persona.jsp");
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.controllers;

import com.kinalfy.models.dao.ListaReproduccionDaoImpl;
import com.kinalfy.models.domain.ListaReproduccion;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ServletLista")
public class ServletListaReproduccion extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarLista(request, response);
                    break;
                case "actualizar":
                    actualizarLista(request, response);
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
                    listarLista(request, response);
                    break;
                case "editar":
                    editarLista(request, response);
                    break;
                case "eliminar":
                   eliminarLista(request, response);
                    break;
            }
        }
    }

    private void listarLista(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<ListaReproduccion> listaR = new ListaReproduccionDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaR);
        response.sendRedirect("lista-reproduccion/lista-reproduccion.jsp");
    }
    
     private void eliminarLista(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idLista = Integer.parseInt(request.getParameter("carne"));
        ListaReproduccion lista = new ListaReproduccion(idLista);
        int registrosEliminados = new ListaReproduccionDaoImpl().delete(lista);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        listarLista(request, response);
    }
     
     private void insertarLista(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        int cancionId = Integer.valueOf(request.getParameter("cancionId"));
        int idAsig = Integer.valueOf(request.getParameter("idAsig"));
        
        
        ListaReproduccion listas = new ListaReproduccion(cancionId, idAsig);
        System.out.println("Estudiante: " +listas);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new ListaReproduccionDaoImpl().add(listas);
        listarLista(request, response);
    }

     private void actualizarLista(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        int cancionId = Integer.valueOf(request.getParameter("cancionId"));
        int idAsig = Integer.valueOf(request.getParameter("idAsig"));
        System.out.println("Dentro de actualizar");
        ListaReproduccion lista = new ListaReproduccion(id, cancionId, idAsig);
        System.out.println("Album UPDATE: " + lista);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new ListaReproduccionDaoImpl().update(lista);
        listarLista(request, response);
    }
     
     private void editarLista(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Recuperar el id del estudiante
        int idAlbum = Integer.parseInt(request.getParameter("id"));
        
        //Crear un objeto tipo estudiante
        ListaReproduccion lista = new ListaReproduccionDaoImpl().get(new ListaReproduccion(idAlbum));
        System.out.println(lista.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("lista", lista);
        response.sendRedirect(request.getContextPath()+ "/" + "lista-reproduccion/editar-lista-reproduccion.jsp");
        
    }
}

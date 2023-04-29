/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kinalfy.controllers;

import com.kinalfy.models.dao.InformacionArtistaDaoImpl;
import com.kinalfy.models.dao.InformacionArtistaDaoJPA;
import com.kinalfy.models.domain.InformacionArtista;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/ServletInfo")
public class ServletInformacionArtista extends HttpServlet{

    




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
         request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarInfo(request, response);
                    break;
                case "actualizar":
                    actualizarInfo(request, response);
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
                    listarInformacion(request, response);
                    break;
                case "editar":
                    editarInfo(request, response);
                    break;
                case "eliminar":
                    eliminarInfo(request, response);
                    break;
            }
        }
    }

    private void listarInformacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<InformacionArtista> listaInfo = new InformacionArtistaDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaInfo);
        response.sendRedirect("informacion-artista/informacion-artista.jsp");
    }
    
     private void eliminarInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idInfo = Integer.parseInt(request.getParameter("carne"));
        InformacionArtista anuncio = new InformacionArtistaDaoJPA().get(new InformacionArtista(idInfo));
        int registrosEliminados = new InformacionArtistaDaoJPA().delete(anuncio);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        listarInformacion(request, response);
    }
     
      private void insertarInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{

        
        String facebook = request.getParameter("facebook");
        String instagram = request.getParameter("instagram");
        String youtube = request.getParameter("youtube");
        String descripcion = request.getParameter("descripcion");
        String imagen = request.getParameter("imagen");
        
        
        InformacionArtista info = new InformacionArtista(facebook, instagram, youtube, descripcion, imagen);
        System.out.println("Estudiante: " +info);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new InformacionArtistaDaoJPA().add(info);
        listarInformacion(request, response);
    }
    
     private void actualizarInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String facebook = request.getParameter("facebook");
        String instagram = request.getParameter("instagram");
        String youtube = request.getParameter("youtube");
        String descripcion = request.getParameter("descripcion");
        String imagen = request.getParameter("imagen");
        System.out.println("Dentro de actualizar");
        InformacionArtista info = new InformacionArtista(id, facebook, instagram, youtube, descripcion, imagen);
        System.out.println("Album UPDATE: " + info);
        
        //int registrosInsertados = new EstudianteDaoImpl().add(estudiante);
        int registrosInsertados = new InformacionArtistaDaoJPA().update(info);
        listarInformacion(request, response);
    }
     
     private void editarInfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Recuperar el id del estudiante
        int idInfo = Integer.parseInt(request.getParameter("id"));
        
        //Crear un objeto tipo estudiante
        InformacionArtista info = new InformacionArtistaDaoImpl().get(new InformacionArtista(idInfo));
        System.out.println(info.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("info", info);
        response.sendRedirect(request.getContextPath()+ "/" + "informacion-artista/editar-informacion-artista.jsp");
        
    }

}

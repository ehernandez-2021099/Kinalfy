/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.controllers;

import com.kinalfy.models.dao.ArtistaDaoImpl;
import com.kinalfy.models.domain.Artista;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletArtistas")
public class ServletArtistas extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarArtista(request, response);
                    break;
                case "actualizar":
                    actualizarArtista(request, response);
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
                    listarArtistas(request, response);
                    break;
                case "editar":
                    editarArtista(request, response);
                    break;
                case "eliminar":
                    eliminarArtista(request, response);
                    break;
            }
        }
    }

    private void listarArtistas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Artista> listaArtista = new ArtistaDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaArtista);
        response.sendRedirect("artistas/artista.jsp");
    }

    private void eliminarArtista(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idArtista = Integer.parseInt(request.getParameter("id"));
        Artista artista = new Artista(idArtista);
        int registrosEliminados = new ArtistaDaoImpl().delete(artista);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        listarArtistas(request, response);
    }

    private void insertarArtista(HttpServletRequest request, HttpServletResponse response) throws IOException {

       
        String nombre = request.getParameter("nombre");
        int informacionArtista = Integer.valueOf(request.getParameter("info"));

        Artista artista = new Artista(nombre, informacionArtista);
        System.out.println("Estudiante: " + artista);

        int registrosInsertados = new ArtistaDaoImpl().add(artista);

        listarArtistas(request, response);
    }

    private void actualizarArtista(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        int info = Integer.valueOf(request.getParameter("infoArtistaId"));
        System.out.println("Dentro de actualizar");
        Artista artista = new Artista(id, nombre, info);
        System.out.println("artista UPDATE: " + artista);

        int registrosInsertados = new ArtistaDaoImpl().update(artista);

        listarArtistas(request, response);
    }

    private void editarArtista(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Recuperar el id del estudiante
        int idArtista = Integer.parseInt(request.getParameter("id"));

        //Crear un objeto tipo estudiante
        Artista artista = new ArtistaDaoImpl().get(new Artista(idArtista));
        System.out.println(artista.toString());

        HttpSession sesion = request.getSession();
        sesion.setAttribute("artista", artista);
        response.sendRedirect(request.getContextPath() + "/" + "artistas/editar-artista.jsp");

    }

}

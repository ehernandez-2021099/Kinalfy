/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.controllers;

import com.kinalfy.models.dao.AsignacionAlbumArtistaDaoImpl;
import com.kinalfy.models.domain.AsignacionAlbumArtista;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletAsignacionAlbumArtista")
public class ServletAsignacionAlbumArtista extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarAsignacionAlbumArtista(request, response);
                    break;
                case "actualizar":
                    actualizarAsignacionAlbumArtista(request, response);
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
                    listarAsignacionAlbumArtista(request, response);
                    break;
                case "editar":
                    //Otras acciones
                    editarAsignacionAlbumArtista(request, response);
                    break;
                case "eliminar":
                    eliminarAsignacion(request, response);
                    break;
            }
        }
    }

    private void listarAsignacionAlbumArtista(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AsignacionAlbumArtista> listaAlbumes = new AsignacionAlbumArtistaDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaAlbumes);
        response.sendRedirect("asignaciones-albumes-artista/asignacion-album.jsp");
    }

    private void eliminarAsignacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idAsignacion = Integer.parseInt(request.getParameter("carne"));
        AsignacionAlbumArtista as = new AsignacionAlbumArtista(idAsignacion);
        int registrosEliminados = new AsignacionAlbumArtistaDaoImpl().delete(as);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        listarAsignacionAlbumArtista(request, response);
    }

    private void insertarAsignacionAlbumArtista(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int artista = Integer.parseInt(request.getParameter("artista"));
        int album = Integer.parseInt(request.getParameter("album"));

        AsignacionAlbumArtista asignacion = new AsignacionAlbumArtista(artista, album);
        System.out.println("AsignacionAlbumArtista: " + asignacion);

        int registrosInsertados = new AsignacionAlbumArtistaDaoImpl().add(asignacion);
        listarAsignacionAlbumArtista(request, response);
    }

    private void editarAsignacionAlbumArtista(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idAsignacion = Integer.parseInt(request.getParameter("id"));

        AsignacionAlbumArtista asignacion = new AsignacionAlbumArtistaDaoImpl().get(new AsignacionAlbumArtista(idAsignacion));
        System.out.println(asignacion.toString());

        HttpSession sesion = request.getSession();
        sesion.setAttribute("asignacion", asignacion);
        response.sendRedirect(request.getContextPath() + "/" + "asignaciones-albumes-artista/editar-asignacion-album.jsp");
        System.out.println();

    }

    private void actualizarAsignacionAlbumArtista(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int artistaId = Integer.parseInt(request.getParameter("idArtista"));
        int albumId = Integer.parseInt(request.getParameter("idAlbum"));
        System.out.println("Dentro de actualizar");
        AsignacionAlbumArtista asignacion = new AsignacionAlbumArtista(id, artistaId, albumId);
        int registrosInsertados = new AsignacionAlbumArtistaDaoImpl().update(asignacion);
        listarAsignacionAlbumArtista(request, response);

    }

}

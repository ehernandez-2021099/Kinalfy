/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.controllers;

import com.kinalfy.models.dao.AsignacionGeneroArtistaDaoImpl;
import com.kinalfy.models.domain.AsignacionGeneroArtista;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletAga")
public class ServletAsignacionGeneroArtista extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarAsignacionAga(request, response);
                    break;
                case "actualizar":
                    actualizarAsignacionAga(request, response);
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
                    listarAga(request, response);
                    break;
                case "editar":
                    //Otras acciones
                    editarAsignacionAga(request, response);
                    break;
                case "eliminar":
                    eliminarAga(request, response);
                    break;
            }
        }
    }

    private void listarAga(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AsignacionGeneroArtista> listaAga = new AsignacionGeneroArtistaDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaAga);
        response.sendRedirect("asignaciones-generos-artistas/asignar-genero-artista.jsp");
    }

    private void eliminarAga(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idAga = Integer.parseInt(request.getParameter("carne"));
        AsignacionGeneroArtista aga = new AsignacionGeneroArtista(idAga);
        int registrosEliminados = new AsignacionGeneroArtistaDaoImpl().delete(aga);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        listarAga(request, response);
    }

    private void insertarAsignacionAga(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int artista = Integer.parseInt(request.getParameter("artista"));
        int genero = Integer.parseInt(request.getParameter("genero"));
        AsignacionGeneroArtista asignacion = new AsignacionGeneroArtista(genero, artista);
        System.out.println("AsignacionAlbumAga: " + asignacion);
        int registrosInsertados = new AsignacionGeneroArtistaDaoImpl().add(asignacion);
        listarAga(request, response);

    }

    private void editarAsignacionAga(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idAsignacion = Integer.parseInt(request.getParameter("id"));
        AsignacionGeneroArtista asignacion = new AsignacionGeneroArtistaDaoImpl().get(new AsignacionGeneroArtista(idAsignacion));
        System.out.println(asignacion.toString());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("asignacion", asignacion);
        response.sendRedirect(request.getContextPath()+ "/" + "asignaciones-generos-artistas/editar-asignacion-genero-artista.jsp");
    }

    private void actualizarAsignacionAga(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int generotId = Integer.parseInt(request.getParameter("generoId"));
        int artistaId = Integer.parseInt(request.getParameter("artistaId"));
        
        System.out.println("Dentro de actualizar");
        AsignacionGeneroArtista asignacion = new AsignacionGeneroArtista(id, generotId, artistaId);
        System.out.println("Asignacion UPDATE: " +asignacion);
        
        int registrosActualizados = new AsignacionGeneroArtistaDaoImpl().update(asignacion);
        listarAga(request, response);
        
    }
}

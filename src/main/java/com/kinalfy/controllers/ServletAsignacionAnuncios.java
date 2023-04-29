/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kinalfy.controllers;

import com.kinalfy.models.dao.AsignacionAnuncioDaoImpl;
import com.kinalfy.models.domain.AsignacionAnuncios;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletAsignacionAnuncios")
public class ServletAsignacionAnuncios extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarAsignacionesA(request, response);
                    break;
                case "actualizar":
                    actualizarAsignacionA(request, response);
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
                    listarAsignacionesA(request, response);
                    //acciones...
                    break;
                case "editar":
                    //otras acciones
                    editarAsignacionA(request, response);
                    break;
                case "eliminar":
                    eliminarAsignacion(request, response);
                    break;
            }
            
        }
        
    }

    private void listarAsignacionesA(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AsignacionAnuncios> listaAsignacionesA = new AsignacionAnuncioDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaAsignacionesA);
        response.sendRedirect("asignaciones-anuncios/asignacion-anuncio.jsp");
    }
    
    private void eliminarAsignacion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idAsig = Integer.parseInt(request.getParameter("carne"));
        AsignacionAnuncios anuncio = new AsignacionAnuncios(idAsig);
        int registrosEliminados = new AsignacionAnuncioDaoImpl().delete(anuncio);
        
        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        listarAsignacionesA(request, response);
    }

    private void insertarAsignacionesA(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int tarjeta = Integer.parseInt(request.getParameter("tarjeta"));
        int anuncio = Integer.parseInt(request.getParameter("anuncio"));
        AsignacionAnuncios asignacion = new AsignacionAnuncios(tarjeta, anuncio);
        System.out.println("AsignacionAlbumArtista: " + asignacion);
        int registrosInsertados = new AsignacionAnuncioDaoImpl().add(asignacion);
        listarAsignacionesA(request, response);
    }
    private void editarAsignacionA (HttpServletRequest request, HttpServletResponse response) throws IOException{
        int idAsignacion = Integer.parseInt(request.getParameter("id"));
        
        AsignacionAnuncios asignacion = new AsignacionAnuncioDaoImpl().get(new AsignacionAnuncios(idAsignacion));
        System.out.println(asignacion.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("asignacion", asignacion);
        response.sendRedirect(request.getContextPath()+ "/" +"asignaciones-anuncios/editar-asignacion-anuncio.jsp" );
        
    }
    private void actualizarAsignacionA (HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        int idPlanTarjeta = Integer.parseInt(request.getParameter("asignacionPlanTarjeta"));
        int idAnuncio = Integer.parseInt(request.getParameter("anuncioId"));
        System.out.println("Dentro de actualizar");
        AsignacionAnuncios asignacion = new AsignacionAnuncios(id, idPlanTarjeta, idAnuncio);
        System.out.println("Asignacion UPDATE: " +asignacion);
        
        int registrosActializados = new AsignacionAnuncioDaoImpl().update(asignacion);
        listarAsignacionesA(request, response);
        
    }
}

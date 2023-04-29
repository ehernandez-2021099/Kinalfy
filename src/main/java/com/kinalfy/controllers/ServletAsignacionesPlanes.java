package com.kinalfy.controllers;

import com.kinalfy.models.dao.AsignacionPlanDaoImpl;
import com.kinalfy.models.domain.AsignacionAlbumArtista;
import com.kinalfy.models.domain.AsignacionesPlanes;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletAsignacionesPlanes")
public class ServletAsignacionesPlanes extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarAsignacionesPlanes(request, response);
                    break;
                case "actualizar":
                    actualizarAsignacionesPlanes(request, response);
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
                    listarAsignacionesPlanes(request, response);
                    //acciones...
                    break;
                case "editar":
                    //otras acciones
                    editarAsignacionPlanes(request, response);
                    break;
                case "eliminar":
                    eliminarAsP(request, response);
                    break;
            }

        }

    }

    private void listarAsignacionesPlanes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AsignacionesPlanes> listaAsignacionesP = new AsignacionPlanDaoImpl().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaAsignacionesP);
        response.sendRedirect("asignaciones-planes-tarjetas/asignacion-tipo-pago.jsp");
    }

    private void eliminarAsP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idAs = Integer.parseInt(request.getParameter("carne"));
        AsignacionesPlanes asp = new AsignacionesPlanes(idAs);
        int registrosEliminados = new AsignacionPlanDaoImpl().delete(asp);

        if (registrosEliminados >= 1) {
            System.out.println("El registro fue eliminado con exito");
        }
        listarAsignacionesPlanes(request, response);
    }

    private void insertarAsignacionesPlanes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int tarjeta = Integer.parseInt(request.getParameter("tarjeta"));
        int plan = Integer.parseInt(request.getParameter("plan"));

        AsignacionesPlanes asignacion = new AsignacionesPlanes(tarjeta, plan);
        System.out.println("AsignacionGeneroArtista " + asignacion);
        int registrosInsertados = new AsignacionPlanDaoImpl().add(asignacion);
        listarAsignacionesPlanes(request, response);

    }

    private void actualizarAsignacionesPlanes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idTarjeta = Integer.parseInt(request.getParameter("tarjetaId"));
        int idPlan = Integer.parseInt(request.getParameter("planId"));
       
        System.out.println("Dentro de actualizar");
        AsignacionesPlanes asignacion = new AsignacionesPlanes(id, idTarjeta, idPlan);
        System.out.println("Asignacion UPDATE: " +asignacion);
        
        int regisatrosActualizados = new AsignacionPlanDaoImpl().update(asignacion);
        listarAsignacionesPlanes(request, response);
    }

    private void editarAsignacionPlanes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idAsignacion = Integer.parseInt(request.getParameter("id"));
        AsignacionesPlanes asignacion = new AsignacionPlanDaoImpl().get(new AsignacionesPlanes(idAsignacion));
        System.out.println(asignacion.toString());
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("asignacion", asignacion);
        response.sendRedirect(request.getContextPath() + "/" + "asignaciones-planes-tarjetas/editar-asignar-tipo-pago.jsp");
    }
}

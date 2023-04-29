
package com.kinalfy.controllers;

import com.kinalfy.models.dao.TarjetaDaoImpl;
import com.kinalfy.models.dao.TarjetaDaoJPA;
import com.kinalfy.models.domain.Tarjeta;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ServletTarjetas")
public class ServletTarjetas extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion!= null) {
            switch (accion) {
                case "insertar":
                    insertarTarjeta(request,response);
                    break;
                case "actualizar":
                    actualizarTarjeta(request,response);
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
                    listarTarjeta(request, response);
                    //acciones...
                    break;
                case "editar":
                    //otras acciones
                    editarTarjeta(request, response);
                    break;
                case "eliminar":
                    eliminarTarjeta(request,response);
                    break;
            }
            
        }
           
        
    }
    private void listarTarjeta(HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<Tarjeta> listaTarjetas = new TarjetaDaoJPA().getAll();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("data", listaTarjetas);
        response.sendRedirect("tarjetas/tarjeta.jsp");
    }
    
    private void insertarTarjeta(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String numero = request.getParameter("numero_tarjeta");
        String nombre = request.getParameter("nombre");
        Date fecha = Date.valueOf(request.getParameter("fecha_vencimiento"));
        String tipo = request.getParameter("tipo_de_tarjeta");
        String empresa = request.getParameter("empresa");
        Tarjeta tarjeta = new Tarjeta(numero, nombre, fecha, tipo, empresa);
        System.out.println("Album:: " +tarjeta);
        int registrosInsertados = new TarjetaDaoJPA().add(tarjeta);
        listarTarjeta(request, response);
    }
    
    private void editarTarjeta(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Tarjeta tarjeta = new TarjetaDaoJPA().get(new Tarjeta(id));
        System.out.println(tarjeta.toString());
        HttpSession sesion = request.getSession();
        sesion.setAttribute("tarjeta", tarjeta);
        response.sendRedirect(request.getContextPath()+ "/" + "tarjetas/editar-tarjeta.jsp");
    }    
    
    private void actualizarTarjeta(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        String numero = request.getParameter("numero_tarjeta");
        String nombre = request.getParameter("nombre");
        Date fecha = Date.valueOf(request.getParameter("fecha_vencimiento"));
        String tipo = request.getParameter("tipo_de_tarjeta");
        String empresa = request.getParameter("empresa");
        
        System.out.println("Dentro de actualizar");
        Tarjeta tarjeta = new Tarjeta(id, numero, nombre,fecha,tipo,empresa);
        System.out.println("Album UPDATE: " +tarjeta);
        
        int registrosInsertados = new TarjetaDaoJPA().update(tarjeta);
        listarTarjeta(request, response);
    }
    
     private void eliminarTarjeta(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int idTarjeta = Integer.parseInt(request.getParameter("id"));
        System.out.println("ID: "+idTarjeta);
        Tarjeta tarjeta = new TarjetaDaoJPA().get(new Tarjeta(idTarjeta));
        int registrosEliminados = new TarjetaDaoJPA().delete(tarjeta);
       if(registrosEliminados >= 1){
            System.out.println("El registro fue eliminado con exito");
        }
        listarTarjeta(request,response);
        
    }

}

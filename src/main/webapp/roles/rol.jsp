
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Roles</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../assets/css/modelo.css"/>
        <script src="../assets/js/b2dd7c91eb.js"></script>
    </head>
    <body>
       <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"/>

        <main>
            <section id="accions" class="py-4 mb-4">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <a href="#"  data-bs-toggle="modal" data-bs-target="#addModal" class="btn btn-outline">Agregar Rol</a>
                        </div>
                    </div>
                </div>
            </section>

            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Agregar Rol</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form method="POST" action="${pageContext.request.contextPath}/ServletRol" class="was-validated">
                            <div class="modal-body">

                                <div class="mb-3">
                                    <label for="descripcion" class="col-form-label">Rol:</label>
                                    <input type="text" class="form-control" id="descripcion" name="descripcion" required>
                                </div>
                            </div>
                            <input type="hidden" value="insertar" id="accion" name="accion">

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                                <button type="sumbit" class="btn btn-primary">Guardar</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
            
            <section id="estudiante">
                <div class = "container mb-5 pb-5">
                    <div class="row">                      
                        <div class="col-12 col-md-12">

                            <div class="card">
                                <div class="card-header">
                                    <h4>Listado de Roles</h4>
                                </div>
                            </div>
                            <table class="table table-light">
                                <thead class="table-dark">
                                    <tr>
                                        <th>#</th>
                                        <th>Descripción</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>
                                        
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${data}" var="rol">
                                        <tr>
                                            <td>${rol.id}</td>
                                            <td>${rol.descripcion} </td>
                                                                                                                                 
                                               
                                             <td>  <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletRol?accion=editar&id=${rol.id}">

                                                        <i class="far fa-edit"></i> Editar
                                                    </a>
                                                </td> 
                                                <td>
                                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletRol?accion=eliminar&rol=${rol.id}">
                                                    <i class="far fa-trash-alt"></i> Eliminar
                                                </a>
                                               
                                            </td> 
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>     
                    </div>
                </div>
            </section>

        </main>
       <jsp:include page="../WEB-INF/paginas/comunes/pie-pagina.jsp"/>
    </body>
    <script src="../assets/js/bootstrap.js"></script>
    <script src="../assets/js/bootstrap.bundle.js"></script>
    <script src="../assets/js/bootstrap.esm.js"></script>
</html>


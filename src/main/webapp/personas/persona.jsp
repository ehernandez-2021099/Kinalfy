
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Persona</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../assets/css/modelo.css"/>
        <script src="../assets/js/b2dd7c91eb.js"></script>
    </head>
    <body>
        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"/>

        <section id="accions" class="py-4">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <a href="#" data-bs-toggle="modal" data-bs-target="#addModal" class="btn btn-outline">Agregar Persona</a>
                    </div>
                </div>
            </div>
        </section>

        <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar Persona</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form method="POST" action="${pageContext.request.contextPath}/ServletPersona" class="was-validated">
                        <div class="modal-body">


                            <div class="mb-3">
                                <label for="nombre1" class="col-form-label">Primer Nombre:</label>
                                <input type="text" class="form-control" id="nombre1" name="nombre1" required>
                            </div>
                            <div class="mb-3">
                                <label for="nombre2" class="col-form-label">Segundo Nombre:</label>
                                <input type="text" class="form-control" id="nombre2" name="nombre2" >
                            </div>
                            <div class="mb-3">
                                <label for="nombre3" class="col-form-label">Tercer Nombre:</label>
                                <input type="text" class="form-control" id="nombre3" name="nombre3" >
                            </div>
                            <div class="mb-3">
                                <label for="apellido1" class="col-form-label">Primer Apellido:</label>
                                <input type="text" class="form-control" id="apellido1" name="apellido1" required>
                            </div>
                            <div class="mb-3">
                                <label for="apellido2" class="col-form-label">Segundo Apellido:</label>
                                <input type="text" class="form-control" id="apellido2" name="apellido2" >
                            </div>
                            <div class="mb-3">
                                <label for="correo" class="col-form-label">Correos:</label>
                                <input type="email" class="form-control" id="correo" name="correo" required >
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
                                <h4>Listado de Personas</h4>
                            </div>
                        </div>
                        <table class="table table-light">
                            <thead class="table-dark">
                                <tr>
                                    <th>#</th>
                                    <th>Nombre Completo</th>

                                    <th>Correo</th>
                                    <th>Editar</th>
                                    <th>Eliminar</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${data}" var="persona">
                                    <tr>
                                        <td>${persona.id}</td>
                                        <td>${persona.nombre1}  ${persona.nombre2}  ${persona.nombre3}  ${persona.apellido1}  ${persona.apellido2}</td>

                                        <td>${persona.correo}</td> 

                                       
                                        <td>
                                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletPersona?accion=editar&id=${persona.id}">
                                                <i class="fa fa-edit"></i> Editar
                                            </a>
                                        </td> 
                                         <td>
                                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletPersona?accion=eliminar&persona=${persona.id}">
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

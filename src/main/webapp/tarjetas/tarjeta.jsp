
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../assets/css/bootstrap.css">
        <link rel="stylesheet" href="../assets/css/modelo.css"/>
        <script src="../assets/js/b2dd7c91eb.js"></script>

        <title>Tarjetas</title>
    </head>
    <body>

        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"/>

        <main>
            <!-- Aqui va a ir el contenido principal de la pagina -->

            <section id="accions" class="py-4">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <a href="#" data-bs-toggle="modal" data-bs-target="#addModal" class="btn btn-outline">Agregar Tarjeta</a>
                        </div>
                    </div>
                </div>
            </section>

            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Tarjeta</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form method="POST" action="${pageContext.request.contextPath}/ServletTarjetas" class="was-validated">
                            <div class="modal-body">

                                <div class="mb-3">
                                    <label for="nombre" class="col-form-label">Numero de la Tarjeta:</label>
                                    <input type="text" class="form-control" id="numero_tarjeta" name="numero_tarjeta" required>
                                </div>

                                <div class="mb-3">
                                    <label for="cantidades" class="col-form-label">Nombre de Tarjeta</label>
                                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                                </div>
                                
                                <div class="mb-3">
                                    <label for="nombre" class="col-form-label">Fecha de Vencimiento</label>
                                    <input type="date" class="form-control" id="fecha_vencimiento" name="fecha_vencimiento" required>
                                </div>

                                <div class="mb-3">
                                    <label for="cantidades" class="col-form-label">Tipo de Tarjeta</label>
                                    <input type="text" class="form-control" id="tipo_de_tarjeta" name="tipo_de_tarjeta" required>
                                </div>

                                <div class="mb-3">
                                    <label for="cantidades" class="col-form-label">Empresa</label>
                                    <input type="text" class="form-control" id="empresa" name="empresa" required>
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
                <div class="container  mb-5 pb-5">
                    <div class="row">
                        <div class="col-12 ">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Listado de Tarjetas</h4>
                                </div>
                            </div>
                            <table class="table table-light">
                                <thead class="table-dark">
                                    <tr>
                                        <th>#</th>
                                        <th>Numero Tarjeta</th>
                                        <th>Nombre</th>
                                         <th>Editar</th>

                                        <th>Eliminar</th>
                                       


                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${data}" var="listaTarjetas" > 
                                        <tr>
                                            <td>${listaTarjetas.id}</td>
                                            <td>${listaTarjetas.numeroTarjeta}</td>
                                            <td>${listaTarjetas.nombrePropietario}</td>
                                            <td>
                                                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletTarjetas?accion=editar&id=${listaTarjetas.id}">
                                                        <i class="fa fa-edit"></i> Editar
                                                    </a>
                                                </td>
                                            <td> 
                                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletTarjetas?accion=eliminar&id=${listaTarjetas.id}">
                                                    <i class="fa fa-trash-alt"></i> Eliminar
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
        <br><br><br>

        <jsp:include page="../WEB-INF/paginas/comunes/pie-pagina.jsp"/>
    </body>
    <script src="../assets/js/bootstrap.js"></script>
    <script src="../assets/js/bootstrap.bundle.js"></script>
    <script src="../assets/js/bootstrap.esm.js"></script>
</html>


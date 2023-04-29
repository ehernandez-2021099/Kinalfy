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
        <title>Anuncios</title>
    </head>
    <body>

        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"/>

        <main>
            <!-- Aqui va a ir el contenido principal de la pagina -->

            <section id="accions" class="py-4">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <a href="#" data-bs-toggle="modal" data-bs-target="#addModal" class="btn btn-outline">Agregar Anuncios</a>
                        </div>
                    </div>
                </div>
            </section>
            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Anuncios</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form method="POST" action="${pageContext.request.contextPath}/ServletAnuncios" class="was-validated">
                            <div class="modal-body">

                                <div class="mb-3">
                                    <label for="id" class="col-form-label">Id:</label>
                                    <input type="number" class="form-control" id="id" name="id" required>
                                </div>
                                <div class="mb-3">
                                    <a href="../asignaciones-albumes-artista/editar-asignacion-album.jsp"></a>
                                    <label for="nombre" class="col-form-label">Descripcion:</label>
                                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                                </div>
                                <div class="mb-3">
                                    <label for="url" class="col-form-label">Imagen:</label>
                                    <input type="url" class="form-control" id="url" name="url" required>
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
                                    <h4>Listado de Anuncios</h4>
                                </div>
                            </div>
                            <table class="table table-light">
                                <thead class="table-dark">
                                    <tr>
                                        <th>#</th>
                                        <th>Descripcion</th>
                                        <th>Editar</th>
                                        <th>Eliminar</th>



                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${data}" var="listaAnuncios" > 
                                        <tr>
                                            <td>${listaAnuncios.id}</td>
                                            <td>${listaAnuncios.descripcion}</td>

                                            <td>  <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletAnuncios?accion=editar&id=${listaAnuncios.id}">

                                                    <i class="far fa-edit"> Editar</i>
                                                </a>
                                            </td> 
                                            <td>  <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletAnuncios?accion=eliminar&id=${listaAnuncios.id}">

                                                    <i class="far fa-trash-alt"> Eliminar</i>
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

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
        <script src="../assets/js/a0a293cf66.js"></script>
        <title>Informacion Artista</title>
    </head>
    <body>
        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"/>

        <main>
            <!-- Aqui va a ir el contenido principal de la pagina -->

             <section id="accions" class="py-4">
                    <div class="container">
                        <div class="row">
                            <div class="col-12">
                                <a href="#" data-bs-toggle="modal" data-bs-target="#addModal" class="btn btn-outlines">Agregar Informacion</a>
                            </div>
                        </div>
                    </div>
                </section>

            <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Informacion</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <form method="POST" action="${pageContext.request.contextPath}/ServletInfo" class="was-validated">
                            <div class="modal-body">

                                
                                <div class="mb-3">
                                    <label for="facebook" class="col-form-label">Facebook (URL):</label>
                                    <input type="url" class="form-control" id="facebook" name="facebook" required>
                                </div>
                                <div class="mb-3">
                                    <label for="instagram" class="col-form-label">Instagram (URL):</label>
                                    <input type="url" class="form-control" id="instagram" name="instagram" required>
                                </div>
                                <div class="mb-3">
                                    <label for="youtube" class="col-form-label">Youtube (URL):</label>
                                    <input type="url" class="form-control" id="youtube" name="youtube" required>
                                </div>
                                <div class="mb-3">
                                    <label for="descripcion" class="col-form-label">Descripcion:</label>
                                    <input type="text" class="form-control" id="descripcion" name="descripcion" required>
                                </div>
                                <div class="mb-3">
                                    <label for="imagen" class="col-form-label">Imagen (URL):</label>
                                    <input type="url" class="form-control" id="imagen" name="imagen" required>
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
                                    <h4>Listado de Informacion Artistas </h4>
                                </div>
                            </div>
                            <table class="table table-light">
                                <thead class="table-dark">
                                    <tr>
                                        <th>#</th>

                                        <th>Descripcion Artista</th>
                                        <th>Facebook</th>
                                        <th>Instagram</th>
                                        <th>Youtube</th>
                                        <th>Eliminar</th>
                                        <th>Editar</th>



                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${data}" var="Info" > 
                                        <tr>
                                            <td>${Info.id}</td>
                                            <td>${Info.descripcion}</td>
                                            <td> <a href=${Info.facebook}><i class="fa-brands fa-facebook"></i></a> </td>
                                            <td> <a href="${Info.instagram}" style="color:white;"><i class="fa-brands fa-instagram "style="background:-webkit-linear-gradient(yellow,red); border-radius: 5px"></i></a></td>
                                            <td> <a href="${Info.youtube}" style="color:red;"><i class="fa-brands fa-youtube "></i></a></td>


                                           
                                            <td>
                                                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletInfo?accion=editar&id=${Info.id}">
                                                    <i class="fa fa-edit"></i> Editar
                                                </a>
                                            </td>
                                             <td>  <a class="btn btn-danger" href="${pageContext.request.contextPath}/ServletInfo?accion=eliminar&carne=${Info.id}">

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

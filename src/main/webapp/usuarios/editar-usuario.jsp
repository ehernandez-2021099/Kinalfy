<%-- 
    Document   : editar-estudiante
    Created on : 18 ago 2022, 10:15:10
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8"/>
        <link rel="stylesheet" type="text/css" href="../assets/css/hoja_estilo_kinal.css" />
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css" />
        <link rel="stylesheet" href="../assets/css/modelo.css"/>
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css.map" />
        <script src="../assets/js/b2dd7c91eb.js"></script>
        <title>Editar Estudiante</title>
    </head>
    <body>

        <jsp:include  page ="../WEB-INF/paginas/comunes/cabecera.jsp"></jsp:include>
            <main>
                <div class="container">
                    <div class="row">
                        <div class="col-1 col-md-1">
                        </div>
                        <div class="col-10 col-md-10">
                            <br>
                            <br>
                            <div class="container">
                                <div class="row">
                                    <div class="col-4 mb-4">
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletUsuario?accion=listar">
                                        <i class="fa fa-arrow-left"></i> Cancelar/Regresar 
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Usuario</h4>
                            </div>

                        </div>

                        <br>                            
                        <form method="POST" action="${pageContext.request.contextPath}/ServletUsuario"  class="was-validated">




                            <div class="modal-body ">

                                <div class="mb-3">
                                    <label for="user" class="col-form-label">User:</label>
                                    <input type="text" class="form-control" id="user" name="user" value="${usuario.user}" required>
                                </div>

                                <div class="mb-3">
                                    <label for="password" class="col-form-label">Contraseña:</label>
                                    <input type="text" class="form-control" id="password" name="password" value="${usuario.pass}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="personaId" class="col-form-label">ID Persona:</label>
                                    <input type="number" class="form-control" id="personaId" name="personaId" value="${usuario.personaId}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="rolId" class="col-form-label">ID Rol:</label>
                                    <input type="number" class="form-control" id="rolId" name="rolId" value="${usuario.rolId}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="listaId" class="col-form-label">ID Lista :</label>
                                    <input type="number" class="form-control" id="listaId" name="listaId" value="${usuario.getListaRepoduccionId()}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="asigId" class="col-form-label">ID Asignacion Planes:</label>
                                    <input type="number" class="form-control" id="asigId" name="asigId" value="${usuario.getAsignacionPlanId()}" required>
                                </div>




                            </div>
                            <input type="hidden" name="accion" value="actualizar">

                            <div class="container mb-2">
                                <div class="row">
                                    <div class="col-6 text-center">
                                        <a class="btn btn-danger"href="${pageContext.request.contextPath}/ServletUsuario?accion=eliminar&id=${usuario.user}"> 
                                            <i class="fa-solid fa-trash"></i> Eliminar Estudiante
                                        </a>
                                    </div>

                                    <div class="col-6 text-center">
                                        <button type="submit" class="btn btn-success">
                                            <i class="fas fa-check"></i> Guardar Cambios
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-1 col-md-1">

                    </div>
                </div>
            </div>

        </main>
        <aside>
            <!-- Aqui va a ir el contenido secundario -->
        </aside>

        <jsp:include  page ="../WEB-INF/paginas/comunes/pie-pagina.jsp"></jsp:include>

    </body>
    <script type="text/javascript" src="../assets/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="../assets/js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="../assets/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="../assets/js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="../assets/js/script.js"></script>
    <script type="text/javascript" src="../assets/js/bootstrap.bundle.js"></script>
</html>


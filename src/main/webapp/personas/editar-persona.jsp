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
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletPersona?accion=listar">
                                        <i class="fa fa-arrow-left"></i> Cancelar/Regresar 
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Persona</h4>
                            </div>

                        </div>

                        <br>                            
                        <form method="POST" action="${pageContext.request.contextPath}/ServletPersona"  class="was-validated">




                            <div class="modal-body ">

                                <div class="mb-3">
                                    <label for="id" class="col-form-label">Id:</label>
                                    <input type="text" class="form-control" id="id" name="id" value="${persona.id}" readonly="true">
                                </div>

                                <div class="mb-3">
                                    <label for="nombre1" class="col-form-label">Primer Nombre:</label>
                                    <input type="text" class="form-control" id="nombre1" name="nombre1" value="${persona.getNombre1()}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="nombre2" class="col-form-label">Segundo Nombre:</label>
                                    <input type="text" class="form-control" id="nombre2" name="nombre2" value="${persona.getNombre2()}" >
                                </div>
                                <div class="mb-3">
                                    <label for="nombre3" class="col-form-label">Tercer Nombre:</label>
                                    <input type="text" class="form-control" id="nombre3" name="nombre3" value="${persona.getNombre3()}" >
                                </div>
                                <div class="mb-3">
                                    <label for="apellido1" class="col-form-label">Primer Apellido:</label>
                                    <input type="text" class="form-control" id="apellido1" name="apellido1" value="${persona.getApellido1()}" required>
                                </div>
                                <div class="mb-3">
                                    <label for="apellido2" class="col-form-label">Segundo Apellido:</label>
                                    <input type="text" class="form-control" id="apellido2" name="apellido2" value="${persona.getApellido2()}" >
                                </div>
                                <div class="mb-3">
                                    <label for="correo" class="col-form-label">Correo:</label>
                                    <input type="text" class="form-control" id="correo" name="correo" value="${persona. getCorreo()}" required>
                                </div>




                            </div>
                            <input type="hidden" name="accion" value="actualizar">

                            <div class="container mb-2">
                                <div class="row">
                                    <div class="col-6 text-center">
                                        <a class="btn btn-danger"href="${pageContext.request.contextPath}/ServletPersona?accion=eliminar&persona=${persona.id}"> 
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
                                            <br>
                                            <br>
                                            <br>
                                            <br>
                                            <br>

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


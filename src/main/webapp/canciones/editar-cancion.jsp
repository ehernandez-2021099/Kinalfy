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
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletCancion?accion=listar">
                                        <i class="fa fa-arrow-left"></i> Cancelar/Regresar 
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Estudiante</h4>
                            </div>

                        </div>

                        <br>                            
                        <form method="POST" action="${pageContext.request.contextPath}/ServletCancion"  class="was-validated">




                            <div class="modal-body ">

                                <div class="mb-3">
                                    <label for="id" class="col-form-label">Id:</label>
                                    <input type="text" class="form-control" id="id" name="id" value="${cancion.id}" readonly="true">
                                </div>
                                
                                <div class="mb-3">
                                    <label for="nombre" class="col-form-label">Nombre:</label>
                                    <input type="text" class="form-control" id="nombre" name="nombre" value="${cancion.getNombre()}" required>
                                </div>
                                

                                <div class="mb-3">
                                    <label for="albumId" class="col-form-label">Artista Id:</label>
                                    <input type="text" class="form-control" id="albumId" name="albumId" value="${cancion.getAlbumArtistaId()}" required>
                                </div>


                            </div>
                            <input type="hidden" name="accion" value="actualizar">

                            <div class="container mb-2">
                                <div class="row">
                                    <div class="col-6 text-center">
                                        <a class="btn btn-danger"href="${pageContext.request.contextPath}/ServletCancion?accion=eliminar&carne=${cancion.id}"> 
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

   
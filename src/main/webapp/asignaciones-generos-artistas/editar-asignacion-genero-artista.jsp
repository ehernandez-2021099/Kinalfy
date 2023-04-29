<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo-agregar.css" />
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css">
        <title>Agregar asignacion de genero a Artista</title>
    </head>
    <body class="body">
        <jsp:include page="../WEB-INF/paginas/comunes/cabecera.jsp"/>
        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-12"></div>
                    <section class="form-register" id="tarjeta">
                        <div id="cabeza">
                            <img src="../assets/images/Sin título-2.png" width="200px" />
                        </div>
                        <div>

                            <br>
                        </div>
                        <h3 class="titulo">Regístra los datos de la Asignacion de genero a artista.</h3>

                        <article>
                            <form method="POST" action="${pageContext.request.contextPath}/ServletAga"class="row g-3 needs-validation " novalidate id="form">
                                <p id="titul" class="titulo"> Formulario de datos</p>
                                <div class="col-12 col-md-4 divs">
                                    <label for="nombre" class="col-form-label">ID:</label>
                                    <div class="  input-group has-validation">


                                        <input type="text" class="form-control" id="id" onclick="verificacion()"
                                               placeholder="Ingrese la ID" aria-describedby="inputGroupPrepend"
                                               required minlength="1" maxlength="49" value="${asignacion.id}" name="id" readonly="true">

                                        <div class="invalid-feedback">
                                            Ingrese la ID 
                                        </div>
                                    </div>
                                </div>
                                <div class="col-12 col-md-4 divs">
                                    <label for="nombre" class="col-form-label">ID Genero:</label>
                                    <input type="text" class="form-control" id="id-genero" onclick="verificacion()"
                                           placeholder="ID del Genero"
                                           aria-describedby="inputGroupPrepend" minlength="1" maxlength="49"
                                           value="${asignacion.generoId}" name="generoId">
                                </div>

                                <div class="col-12 col-md-4 divs">
                                    <div>
                                        <label for="nombre" class="col-form-label">ID Artista:</label>
                                        <input type="text" class="form-control" id="artista-id" onclick="verificacion()"
                                               placeholder="ID del Artista"
                                               aria-describedby="inputGroupPrepend" minlength="1" maxlength="49" 
                                               value="${asignacion.artistaId}" name="artistaId">
                                    </div>
                                </div>




                                <input type="hidden" name="accion" value="actualizar">
                                <div id="boton" class="col-0 col-md-4"class="col-0 col-md-4"  style="text-align: center">
                                    <div style="text-align: center">
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletAga?accion=listar">
                                        <i class="fa fa-arrow-left"></i> Cancelar/Regresar 
                                    </a>
                                    </div>
                                    
                                </div>
                                <div id="botonagregar" class="col-0 col-md-4"  style="text-align: center">
                                    <div class="botonPlan">
                                        <button type="submit" class="btn btn-success">
                                            <i class="fas fa-check"></i> Guardar Cambios
                                        </button>
                                    </div>
                                </div>
                                <div class="col-0 col-md-4"  style="text-align: center">
                                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletAga?accion=eliminar&carne=${asignacion.id}">

                                        <i class="far fa-trash-alt">Eliminar</i>
                                    </a>
                                </div>
                            </form>
                        </article>

                    </section>
                </div>
            </div>
        </main>

    </body>
    <script src="../assets/js/bootstrap.js"></script>
    <script src="../assets/js/bootstrap.bundle.js"></script>
    <script src="../assets/js/bootstrap.esm.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</html>

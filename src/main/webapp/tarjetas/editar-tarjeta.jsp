<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es_GT"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../assets/css/estilo-agregar.css" />
        <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css">
        <title>Agregar Tarjeta</title>
    </head>
    <body class="body">

        <main>
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-12"></div>
                    <section class="form-register" id="tarjeta">
                        <div id="cabeza" style="text-align: center">
                            <img src="../assets/images/Sin título-2.png" width="200px" />
                        </div>
                        <div>

                            <br>
                        </div>
                        <h3 class="titulo">Regístra los datos de la Tarjeta.</h3>

                        <article>
                            <form method="POST" action="${pageContext.request.contextPath}/ServletTarjetas" class="row g-3 needs-validation " novalidate id="form">

                                <form class="row g-3 needs-validation " novalidate id="form">
                                    <p id="titul" class="titulo"> Formulario de datos</p>
                                    <div class="col-12 col-md-4 divs">
                                        <label for="id" class="col-form-label">Id:</label>
                                        <div class="  input-group has-validation">

                                            
                                            <input type="text" class="form-control" id="id" name="id" 
                                                   placeholder="Ingrese el ID" aria-describedby="inputGroupPrepend"
                                                   required minlength="1" maxlength="49" value="${tarjeta.getId()}" readonly="true">

                                            <div class="invalid-feedback">
                                                Ingrese el ID 
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-12 col-md-4 divs">
                                        <label for="id" class="col-form-label">Numero De Tarjeta:</label>
                                        <input type="text" class="form-control" id="numero_tarjeta" name="numero_tarjeta" onclick="verificacion()"
                                               placeholder="Numero de la tarjeta"
                                               aria-describedby="inputGroupPrepend" minlength="1" maxlength="49"value="${tarjeta.getNumeroTarjeta()}">

                                    </div>

                                    <div class="col-12 col-md-4 divs">
                                        <div>
                                            <label for="id" class="col-form-label">Nombre del Propetario:</label>
                                            <input type="text" class="form-control" id="nombre" name="nombre" onclick="verificacion()"
                                                   placeholder="Ingrese el nombre del propietario"
                                                   aria-describedby="inputGroupPrepend" minlength="1" maxlength="49" value="${tarjeta.getNombrePropietario()}">

                                        </div>
                                    </div>

                                    <div class="col-12 col-md-4 divs">
                                        <div>
                                            <label for="id" class="col-form-label">Fecha de Vencimiento:</label>
                                            <input type="date" class="form-control" id="fecha_vencimiento" name="fecha_vencimiento" onclick="verificacion()"
                                                   placeholder="Ingrese la fecha de vencimiento"
                                                   aria-describedby="inputGroupPrepend" minlength="1" maxlength="49" value="${tarjeta.getFechaVencimiento()}">

                                        </div>
                                    </div>

                                    <div class="col-12 col-md-4 divs">
                                        <div>
                                            <label for="id" class="col-form-label">Tipo de Tarjeta:</label>
                                            <input type="text" class="form-control" id="tipo_de_tarjeta" name="tipo_de_tarjeta" onclick="verificacion()"
                                                   placeholder="Ingrese el tipo de Tarjeta"
                                                   aria-describedby="inputGroupPrepend" minlength="1" maxlength="49" value="${tarjeta.getTipoTarjeta()}">

                                        </div>

                                    </div>    
                                    <div class="col-12 col-md-4 divs">
                                        <div>
                                            <label for="id" class="col-form-label">Empresa:</label>
                                            <input type="text" class="form-control" id="empresa" name="empresa" onclick="verificacion()"
                                                   placeholder="Ingrese la empresa"
                                                   aria-describedby="inputGroupPrepend" minlength="1" maxlength="49"  value="${tarjeta.getEmpresa()}">

                                            <input type="hidden" name="accion" value="actualizar" >

                                        </div>    
                                    </div>

                                    <div id="boton" class="col-0 col-md-4" style="text-align: center">
                                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/ServletTarjetas?accion=listar">
                                            <i class="fa fa-arrow-left"></i> Cancelar/Regresar 
                                        </a>
                                    </div>
                                    <div id="botonagregar" class="col-0 col-md-4" style="text-align: center">
                                        <div class="botonPlan">
                                            <button type="submit" class="btn btn-success">
                                                <i class="fas fa-check"></i> Guardar Cambios
                                            </button>
                                        </div>
                                    </div>
                                    <div class="col-0 col-md-4" style="text-align: center">
                                        <a class="btn btn-warning" href="${pageContext.request.contextPath}/ServletTarjetas?accion=eliminar&id=${tarjeta.id}">

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

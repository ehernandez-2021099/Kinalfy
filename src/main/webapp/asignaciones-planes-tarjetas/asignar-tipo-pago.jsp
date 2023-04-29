<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="es">

<head>
    <title>Formas de pago</title>
    <meta charset="utf-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../assets/css/estilo-tipo-pago.css" />
    <link rel="stylesheet" href="../assets/css/estilo-index.css"/>
    <link rel="stylesheet" type="text/css" href="../assets/css/paypal.css" />
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css.map" />
    <script src="./asets/js/a0a293cf66.js"></script>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="../assets/css/bootstrap-datepicker.css" rel="stylesheet" />
    <script src="../assets/js/bootstrap-datepicker.min.js"></script>
    <script src="../assets/js/bootstrap-datepicker.pt-BR.min.js" charset="UTF-8"></script>


</head>

<body class="body">
    <header>

    </header>
    <main>
        <div class="container">
            <div class="row">
                <div class="contenedor">
                    <section class="tarjeta" id="tarjeta">
                        <div id="contenedor">
                            <div class="col-12 col-md-12 col-lg-12 ">

                                <div class="col-12 col-md-12">
                                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="paypal"
                                        onclick="verificacion()">
                                    <label for="paypal" class="form-check-label">Paypal </label>

                                    <img src="../assets/images/paypal.png" class="img">
                                </div>
                                <div>
                                    <br>
                                </div>
                                <div class="col-12 col-md-12">
                                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="tarjet"
                                        onclick="verificacion()">
                                    <label for="tarjet" class="form-check-label">Tarjeta credito o debito </label>

                                    <img class="img" src="../assets/images/visa-logo.png">
                                    <img class="img"
                                        src="../assets/images/42-422152_american-express-logo-201804301551034-logo-american-express.png">
                                    <img class="img" src="../assets/images/Mastercard_2019_logo.svg.png">
                                </div>
                                <div>
                                    <br>
                                </div>
                                <div id="botomMargin" style="display: none;">
                                    <br>
                                </div>
                                <div id="boton" style="display: none;">
                                    <button class="btn btn-outline-success" onclick="myFunction()"> <a
                                            href="#openModal">Ingresar a Paypal</a></button>


                                    <div id="openModal" class="modalDialog scol-12 col-md-12">

                                        <div class="login-page-content">
                                            <a href="#close" title="Close" class="close">X</a>
                                            <div class="login-page-logo logo">
                                                <span class="p-1">P</span>
                                                <span class="p-2">P</span>
                                                <span>Pay</span>
                                                <span>Pal</span>
                                            </div>
                                            <form action="#" class="login-page-form">
                                                <input type="text" id="user" class="form-login-input"
                                                    placeholder="Email or mobile number">

                                                <input type="password" id="password" class="form-login-input" placeholder="Password">

                                                <button type="button" class="btn btn-primary">Login</button>
                                                <p>or</p>
                                                <input type="button" onclick=" location.href='../vista-usuario.jsp'" class="form-signup-btn" value="Iniciar Sesion">
                                            </form>
                                        </div>

                                    </div>
                                </div>

                                <div class="datos">
                                    <h6 id="dat">Datos de pago</h6>
                                </div>

                                <form class="row g-3 needs-validation " novalidate id="form">
                                    <div class="col-12 col-md-12" >
                                        <div class="  input-group has-validation">
                                            <input type="text" class="form-control" id="nombre-tarjeta"
                                                onclick="verificacion()" placeholder="Numero tarjeta" disabled="true"
                                                aria-describedby="inputGroupPrepend" required>
                                            <div class="invalid-feedback">
                                                Ingrese su numero de tarjeta
                                            </div>
                                        </div>
                                    </div>
                                    <div class=" col-12 col-md-12">
                                        <div class="input-group has-validation">
                                            <input type="text" class="form-control border " id="nombre-propietario"
                                            onclick="verificacion()" placeholder="Nombre Propietario" disabled="true"
                                            aria-describedby="inputGroupPrepend" required>
                                            <div class="invalid-feedback">
                                                Ingrese nombre de Propietario
                                            </div>
                                        </div>
                                    </div>
                                    <div class=" col-12 col-md-12">
                                        <div class="input-group has-validation">
                                            <div class="input-group date">
                                                <input type="text" class="form-control" id="exemplo" disabled="true"
                                                    placeholder="Fecha de caducidad"
                                                    aria-describedby="inputGroupPrepend" required>

                                                    <div class="invalid-feedback">
                                                        Ingrese fecha de vencimiento
                                                    </div>
                                            </div>
                                            
                                        </div>
                                    </div>

                                    <div class=" col-12 col-md-12">
                                        <div class="input-group has-validation">
                                            <input type="password" class="form-control" id="codigoSeguridad"
                                            onclick="verificacion()" placeholder="Codigo de Seguridad" disabled="true"
                                            aria-describedby="inputGroupPrepend" required>
                                            <div class="invalid-feedback">
                                                Ingrese codigo de Seguridad
                                            </div>
                                        </div>
                                    </div>
                                   
                                    <div id="chack">
                                        <input class="form-check-input" type="radio" name="tipoTarjeta"
                                            id="tarjetaCredito" onclick="verificacion()" disabled="true" required>
                                        <label for="tarjetaCredito" class="form-check-label"
                                            id="labelCredito">Credito</label>
                                            

                                        <input class="form-check-input" type="radio" name="tipoTarjeta"
                                            id="tarjetaDebito" onclick="verificacion()" disabled="true" required>
                                        <label for="tarjetaDebito" class="form-check-label"
                                            id="labelDebito">Debito</label>

                                            <div class="invalid-feedback">
                                                Agregue el tipo de tarjeta
                                            </div>
                                    </div>

                                    <div id="check">

                                        <input class="form-check-input" type="radio" name="empresa" id="visa"
                                            onclick="verificacion()" disabled="true" required>
                                        <label for="visa" class="form-check-label" id="labelVisa">Visa</label>

                                        <input class="form-check-input" type="radio" name="empresa" id="masterCard"
                                            onclick="verificacion()" disabled="true" required>
                                        <label for="masterCard" class="form-check-label"
                                            id="labelMaster">MasterCard</label>

                                        <input class="form-check-input" type="radio" name="empresa" id="americanExpres"
                                            onclick="verificacion()" disabled="true" required>
                                        <label for="americanExpres" class="form-check-label" id="labelAmerican">American
                                            Express</label>

                                            <div class="invalid-feedback">
                                                Agregue la empresa
                                            </div>
                                    </div>                   
                                    <div id="region" class="col-12 col-md-12">
                                        <h6>Región Postal</h6>
                                        <div class="input-group has-validation">
                                            <input class="form-control" type="text" id="regiones" list="country_list" 
                                            disabled="true" aria-describedby="inputGroupPrepend" required>

                                            <div class="invalid-feedback">
                                                Ingrese la region
                                            </div>
                                        </div>
    
                                    </div>
                                    <div id="buttom" class="col-12 col-md-12">
                                        <button id="botonProbar" class="btn btn-outline-success" type="submit"onclick="todo()"
                                            type="submit">
                                            Probar ahora</button>
      
                                    </div>
                                </form>
                            </div>
                    </section>
                </div>
            </div>
            </div>
            
    </main>
    <br>
    <br>
    <jsp:include  page ="../WEB-INF/paginas/comunes/pie-pagina.jsp"></jsp:include>
</body>



<script type="text/javascript" src="../assets/js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="../assets/js/script-tipo-pago.js"></script>

</html>

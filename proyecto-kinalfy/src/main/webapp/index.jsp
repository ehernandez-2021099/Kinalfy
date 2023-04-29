<%-- 
    Document   : index
    Created on : 25 ago 2022, 7:55:50
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/css/bootstrap.css">
        <link rel="stylesheet" href="./assets/css/estilo-index.css"/>
        <title>KINALFY</title>
    </head>
    <body class="body">





        <div class="prueba">
            <nav class="navbar navbar-expand-lg bg-dark navbar-dark">

                <div class="container mx-auto">
                    <a class="navbar-brand" href="./index.jsp">KINALFY</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto ">
                            <li class="nav-item">
                                <div class="regis">
                                    <a class="nav-link" aria-current="page" href="./index.jsp#planess">Planes</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <div class="regis">
                                    <a class="nav-link" href="./personas/registro.jsp">Registrate</a>
                                </div>
                            </li>
                            <li class="nav-item" ><a class="nav-link disabled" href="./login.jsp" style="color:white;" >|</a></li>
                            <li class="nav-item">
                                <div class="iniciarsesion">
                                    <a class="nav-link" href="./login.jsp">Iniciar Sesion</a>
                                </div>
                            </li>

                        </ul>


                    </div>
                </div>

            </nav>
        </div>
        

        <div class="totalBio">
        <div class="container mb-5 pb-4 ">
            <div class="row">
                <div class="col-12 col-md-6 ">
                    <p class="biografias"> Kinalfy es un servicio de música que que permite reproducir distintas canciones de artistas de su preferencia, Kinalfy es una aplicación totalmente gratis, pero cuenta con distintos planes de pago, los cuales traen distintos beneficios al usuario dependiendo del plan que adquiera.
                        El usuario tendrá la libertad de reproducir canciones a su voluntad, el usuario podrá ver las distintas redes sociales de sus artistas favoritos para estar siempre al tanto de sus nuevos éxitos.
                    </p>
                </div>
                <div class="col-12 col-md-6 ">
                    <div class="imagenLogoBio">
                        <img src="./assets/images/Sin título-2.png" alt="alt"/>
                    </div>
                </div>
            </div>
        </div>
        </div>
        
        <main >
            <section >

                <h1 id="hPlan" ><a name="planess">PLANES</a></h1>>
                <div class="total">
                    <div class="container mb-5 pb-4 ">
                        <div class="row">
                            <div class="col-12 col-md-4 ">
                                <div class="card">
                                    <div class="card-header">
                                        <p class="planes">Estudiante</p>
                                    </div>
                                    <div class="card-body">
                                        <h5 class="card-title">Q39.99/ mes (Unicamente valido para estudiantes con carné)</h5>
                                        <hr size="2px" color="black"/>
                                        <p class="card-text">&#8594 Tu musica favorita sin anuncios</p>
                                        <br>
                                        <p class="card-text">&#8594 Acceso ilimitado a la aplicacion</p>
                                        <br>
                                        <p class="card-text">&#8594 Descuentos en los proximos meses</p>
                                        <br>
                                        <p class="card-text" style="color: white;">f </p>
                                        <br>
                                        <p class="card-text" style="color: white;">f </p>
                                        <br>
                                        <p class="card-text" style="color: white;">f </p>

                                        <br><br><br>
                                        <div class="botonPlan">
                                            <a  href="./personas/registro.jsp"  class="btn btn-dark">COMPRAR</a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-12 col-md-4 ">
                                <div class="card">
                                    <div class="card-header">
                                        <p class="planes">Duo</p>
                                    </div>
                                    <div class="card-body">
                                        <h5 class="card-title">Q99.99/ al mes tras el periodo de prueba del plan</h5>
                                        <hr size="2px" color="black"/>
                                        <p class="card-text">&#8594 Tu musica favorita sin anuncios</p>
                                        <br>
                                        <p class="card-text">&#8594 Acceso ilimitado a la aplicacion</p>
                                        <br>
                                        <p class="card-text">&#8594 2 cuentas premium para compartir con tu pareja</p>
                                        <br>
                                        <p class="card-text">&#8594 Podras escuchar tu musica sin conexión </p>
                                        <br>
                                        <p class="card-text" style="color: white;">f </p>
                                        <br>
                                        <p class="card-text" style="color: white;">f </p>
                                        <br><br><br>
                                        <div class="botonPlan">
                                            <a  href="./personas/registro.jsp"  class="btn btn-dark">COMPRAR</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-md-4 ">
                                <div class="card">
                                    <div class="card-header">
                                        <p class="planes">Premium</p>
                                    </div>
                                    <div class="card-body">
                                        <h5 class="card-title">Q149.99/ al mes tras el periodo de prueba del plan</h5>
                                        <hr size="2px" color="black"/>
                                        <p class="card-text">&#8594 Tu musica favorita sin anuncios</p>
                                        <br>
                                        <p class="card-text">&#8594 Acceso ilimitado a la aplicacion</p>
                                        <br>
                                        <p class="card-text">&#8594 Hasta 5 cuentas vinculadas</p>
                                        <br>
                                        <p class="card-text">&#8594 Podras entrar sin limites a la información de tu artista favorito</p>
                                        <br>
                                        <p class="card-text">&#8594 Podras escuchar tu musica sin conexión </p>
                                        <br>
                                        <p class="card-text">&#8594 Acesso a la aplicacion sin limites</p>
                                        <br><br>
                                        <div class="botonPlan">
                                            <a  href="./personas/registro.jsp"  class="btn btn-dark">COMPRAR</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </section>
        </main>      
    <br>
    <jsp:include  page ="./WEB-INF/paginas/comunes/pie-pagina.jsp"></jsp:include>

    </body>
</html>

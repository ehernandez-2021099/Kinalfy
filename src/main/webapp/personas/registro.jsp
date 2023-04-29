

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <!-- Aquí debe ir el título y las hojas de estilo CSS -->
  <meta charset="utf-8" />

  <title>Registro</title>
  <link rel="stylesheet" href="../assets/css/registro.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.css" />
  
</head>

<body class="body">

  <main>
    <div class="container">
      <div class="row">
    <div class="col-12 col-md-12"></div>
    <section class="form-register" id="tarjeta">
      <div id="cabeza">
        <img src="../assets/images/Sin título-1.png" width="200px"></img>
      </div>
      <div>
        <br>
      </div>
      <h3 class="titulo">Regístrate gratis para escuchar tu musica preferida.</h3>
      
      <article>
        <form class="row g-3 needs-validation " novalidate id="form">
          <p id="titul"class="titulo"> ¿Cual es tu Nombre?</p>
          <div class="col-12 col-md-4 divs">
            <div class="  input-group has-validation">
              

              <input type="text" class="form-control" id="primer-nombre" onclick="verificacion()"
                placeholder="Ingrese su Primer Nombre" aria-describedby="inputGroupPrepend" required
                minlength="1" maxlength="49">

              <div class="invalid-feedback">
                Ingrese su Primer Nombre
              </div>
            </div>
          </div>
          <div class="col-12 col-md-4 divs"> 
              <input type="text" class="form-control" id="segundo-nombre" onclick="verificacion()"
                placeholder="Ingrese su Segundo Nombre(opcional)" aria-describedby="inputGroupPrepend" 
                minlength="1" maxlength="49">
          </div>

          <div class="col-12 col-md-4 divs">
            <div>
              <input type="text" class="form-control" id="tercer-nombre" onclick="verificacion()"
                placeholder="Ingrese su Tercer Nombre(opcional)" aria-describedby="inputGroupPrepend" 
                minlength="1" maxlength="49">
            </div>
          </div>
          
          <div class="col-12 col-md-4 divs">
            <div class="  input-group has-validation">
              <input type="text" class="form-control" id="primer-apellido" onclick="verificacion()"
                placeholder="Ingrese su Primer Apellido" aria-describedby="inputGroupPrepend" required
                minlength="1" maxlength="49">
              <div class="invalid-feedback">
                Ingrese su Primer Apellido
              </div>
            </div>
          </div>
          <div class="col-12 col-md-4 divs">
            <div>
              <input type="text" class="form-control" id="segundo-apellido" onclick="verificacion()"
                placeholder="Ingrese su Segundo Apellido(opcional)" aria-describedby="inputGroupPrepend" 
                minlength="1" maxlength="49">
            </div>
          </div>
          <div class="col-12 col-md-4 divs">
            <div class="  input-group has-validation">
              <input type="text" class="form-control" id="correo" onclick="verificacion()"
                placeholder="Ingrese su Correo" aria-describedby="inputGroupPrepend" required
                minlength="1" maxlength="254">
              <div class="invalid-feedback">
                Ingrese su Correo
              </div>
            </div>
          </div>
          

          <div class="col-0 col-md-4">

          </div>
          <div id="submit" class="col-12 col-md-4 ">
              <a href="../planes/plan.jsp">
            <button id="botonProbar" class="btn btn-warning botons" type="submit" onclick="myFunction()">
              Registrate</button>
            </a>
          </div>
          <div class="col-0 col-md-4">

          </div>
        </form>
      </article>
    
    </section>
  </div>
    </div>
  </main>

</body>
<script type="text/javascript" src="../assets/js/bootstrap.bundle.js"></script>
<script type="text/javascript" src="../assets/js/script-registro.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>

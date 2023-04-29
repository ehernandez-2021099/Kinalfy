<%-- 
    Document   : registro
    Created on : 29/08/2022, 11:01:57
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="es">
  <head>
    <!-- Aquí debe ir el título y las hojas de estilo CSS -->
    <link rel="stylesheet" href="../assets/css/registro.css">
    <link rel="stylesheet" href="../assets/css/estilo-index.css"/>
  </head>
  <body>
    <header>
      <!-- Aquí debe ir el encabezado -->
    </header>
    <nav>
      <!-- Aquí va el menú -->
    </nav>
    <main>
      <section class="form-register">
        <article>
         
                <h4>Formulario Registro</h4>
                <input class="controls" type="text" name="nombres" id="nombres" placeholder="Ingrese su Nombre">
                <input class="controls" type="text" name="apellidos" id="apellidos" placeholder="Ingrese su Apellido">
                <input class="controls" type="email" name="correo" id="correo" placeholder="Ingrese su Correo">
                <input class="controls" type="password" name="correo" id="correo" placeholder="Ingrese su Contraseña">
                <p>Estoy de acuerdo con <a href="#">Terminos y Condiciones</a></p>
                <input class="botons" type="submit" value="Registrar">
            
        </article>
      </section>
    </main>
    <aside>
      <!-- Aquí va información secundaria -->
    </aside>
    <br>
    <jsp:include  page ="../WEB-INF/paginas/comunes/pie-pagina.jsp"></jsp:include>
  </body>
  <!-- Aquí pueden ir los scripts (.js) -->
</html>


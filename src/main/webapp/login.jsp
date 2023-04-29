
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./assets/css/estilo-login.css">
    
    <link rel="stylesheet" href="./assets/css/bootstrap.css">
    <title>Login Kinalfy</title>
</head>

<body class="body">
    <header>

    </header>
        <nav>
            <div class="login">
                <img src="./assets/images/Sin título-2.png" class="img" alt="image">
                <div class="titulo">

                    <h1><font color="#FF8F00">K</font>
                        <font color="#FFA000">I</font>
                        <font color="#F9A825">N</font>
                        <font color="#FFB300">A</font>
                        <font color="#FBC02D">L</font>
                        <font color="#FFC107">F</font>
                        <font color="#FFCA28">Y</font>
                    </h1>
                </div>

                <br><br>
                <div class="usuario">
                    <label for="username">Usuario</label>
                </div>
                <input type="text" placeholder="Introduce tu usuario">

                <br><br>
                <div class="contra">
                    <label for="password">Contraseña</label>
                </div>

                <input type="password" placeholder="Ingresa tu contraseña">

                <br>
                <a href="./vista-usuario.jsp"><input class="btn btn-primary" type="button" value="Ingresar"></a>

                <br>
                <div class="line">

                </div>
                <div class="content">
                    <span class="cuenta">¿No tienes cuenta?</span>
                    <a href="./personas/registro.jsp"> Registrarse</a>
                </div>
            </div>
        </nav>
    
    <jsp:include page ="./WEB-INF/paginas/comunes/pie-pagina.jsp"></jsp:include>
</body>
</html>

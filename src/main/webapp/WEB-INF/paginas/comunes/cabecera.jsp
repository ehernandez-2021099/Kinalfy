<div class="prueba">
    <nav class="navbar navbar-expand-lg bg-dark navbar-dark">

        <div class="container mx-auto">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">KINALFY</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">



                <ul class="navbar-nav ms-auto ">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Entidades
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletAlbum?accion=listar" style="color:black;">Albumes</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletAnuncios?accion=listar" style="color:black;">Anuncios</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletArtistas?accion=listar" style="color:black;">Artista</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletAsignacionAlbumArtista?accion=listar" style="color:black;">Asignacion-Album-Artista</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletAsignacionAnuncios?accion=listar" style="color:black;">Asignación-Anuncios</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletAga?accion=listar" style="color:black;">Asignacion-Generos-Artistas</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletAsignacionesPlanes?accion=listar" style="color:black;">Asignación-Planes</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletCancion?accion=listar" style="color:black;">Canciones</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletGenero?accion=listar" style="color:black;">Generos</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletInfo?accion=listar" style="color:black;">Informacion Artista</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletLista?accion=listar" style="color:black;">Lista Reproduccion</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletPersona?accion=listar" style="color:black;">Persona</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletPlanes?accion=listar" style="color:black;">Planes</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletRol?accion=listar" style="color:black;">Roles</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletTarjetas?accion=listar" style="color:black;">Tarjetas</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ServletUsuario?accion=listar" style="color:black;">Usuario</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <div class="regis">
                            <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/index.jsp#planess">Planes</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <div class="regis">
                            <a class="nav-link" href="${pageContext.request.contextPath}/personas/registro.jsp">Registrate</a>
                        </div>
                    </li>
                    <li class="nav-item" ><a class="nav-link disabled" href="#" style="color:white;" >|</a></li>
                    <li class="nav-item">
                        <div class="iniciarsesion">
                            <a class="nav-link" href="${pageContext.request.contextPath}/login.jsp">Iniciar Sesion</a>
                        </div>
                    </li>

                </ul>


            </div>
        </div>

    </nav>
</div>
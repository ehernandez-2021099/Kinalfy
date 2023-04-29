<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./assets/css/vista-usuario.css">
    <title>Spotify</title>
</head>

<body>
    <div class="container">
        <aside>
            <div class="menu">
                <a class="active" href="#"><span><img src="./assets/images/home.svg" alt=""></span>Inicio</a>
                <a href="#"><span><img src="./assets/images/search.svg" alt=""></span>Buscar</a>
                <a href="#"><span><img src="./assets/images/library.svg" alt=""></span>Tu biblioteca</a> <br>
                <a href="#"><span><img src="./assets/images/add.svg" alt=""></span>Crear lista</a>
                <a href="#"><span><img src="./assets/images/heart.svg" alt=""></span>Canciones que te gustan</a>
            </div>
            </nav>
        </aside>
        <section>
            <header>
                <div class="botones_prev_next">
                    <span class="btn_prev"><img src="./assets/images/prev.svg" alt=""></span>
                    <span class="btn_next"><img src="./assets/images/next.svg" alt=""></span>
                </div>

                <div class="suscribcion">
                    <div class="mejora_cuenta">
                        <a href="planes/plan.jsp" class="btn btn-default">MEJORA TU CUENTA</a>
                    </div>
                    <div class="perfil">
                        <span class="circulo"><img src="./assets/images/user.svg" alt=""></span>
                        <span class="nombre">Usuario</span>
                        <span><img src="./assets/images/salir.svg" alt=""></span>
                    </div>
                </div>
            </header>
            <div class="contenedor_degradado">
                <div class="banner">
                    <div class="cancion">
                        <figure>
                            <img src="./assets/images/person_01.png" alt="">
                        </figure>
                    </div>
                    <div class="cancion">
                        <figure>
                            <img src="./assets/images/person_02.png" alt="">
                        </figure>
                    </div>
                    <div class="cancion">
                        <figure>
                            <img src="./assets/images/person_03.png" alt="">
                        </figure>
                    </div>
                    <div class="cancion">
                        <figure>
                            <img src="./assets/images/person_04.png" alt="">
                        </figure>
                    </div>
                </div>
            </div>
            <div class="contenedor_contenido">
                <div class="titulos">
                    <h1>¡Buenos días!</h1>
                </div>
                <div class="generos">
                    <div class="cards">
                        <div class="card_imagen"><img src="./assets/images/person_01.png" alt=""></div>
                        <div class="card_text">
                            <h4>Autor primero</h4>
                            <iframe style="border-radius:12px" src="https://open.spotify.com/embed/track/31i56LZnwE6uSu3exoHjtB?utm_source=generator&theme=0" width="100%" height="152" frameBorder="0" allowfullscreen="" allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture" loading="lazy">  <img src="./assets/images/play.svg" alt=""/></iframe>
                            
                        </div>
                    </div>
                    <div class="cards">
                        <div class="card_imagen"><img src="./assets/images/person_02.png" alt=""></div>
                        <div class="card_text">
                            <h4>Autor primero</h4>
                            <img src="./assets/images/play.svg" alt="">
                        </div>
                    </div>
                    <div class="cards">
                        <div class="card_imagen"><img src="./assets/images/person_03.png" alt=""></div>
                        <div class="card_text">
                            <h4>Autor primero</h4>
                            <img src="./assets/images/play.svg" alt="">
                        </div>
                    </div>
                    <div class="cards">
                        <div class="card_imagen"><img src="./assets/images/person_04.png" alt=""></div>
                        <div class="card_text">
                            <h4>Autor primero</h4>
                            <img src="./assets/images/play.svg" alt="">
                        </div>
                    </div>
                    <div class="cards">
                        <div class="card_imagen"><img src="./assets/images/person_01.png" alt=""></div>
                        <div class="card_text">
                            <h4>Autor primero</h4>
                            <img src="./assets/images/play.svg" alt="">
                        </div>
                    </div>
                    <div class="cards">
                        <div class="card_imagen"><img src="./assets/images/person_02.png" alt=""></div>
                        <div class="card_text">
                            <h4>Autor primero</h4>
                            <img src="./assets/images/play.svg" alt="">
                        </div>
                    </div>
                </div>
                <div class="titulos">
                    <h2>Programas para probar</h2>
                    <span>Podcast que pensamos que te van a enganchar</span>
                </div>

                <div class="podcast">
                    <div class="card_podcast">
                        <img src="./assets/images/person_01.png" alt="">
                        <h4>Titulo</h4>
                        <p>Podcast primero</p>
                    </div>
                    <div class="card_podcast">
                        <img src="./assets/images/person_02.png" alt="">
                        <h4>Titulo</h4>
                        <p>Podcast primero</p>
                    </div>
                    <div class="card_podcast">
                        <img src="./assets/images/person_03.png" alt="">
                        <h4>Titulo</h4>
                        <p>Podcast primero</p>
                    </div>
                    <div class="card_podcast">
                        <img src="./assets/images/person_04.png" alt="">
                        <h4>Titulo</h4>
                        <p>Podcast primero</p>
                    </div>
                </div>
            </div>
        </section>
        <footer>
            <div class="controles">
                <img src="./assets/images/prev_footer.svg" alt="">
                <img src="./assets/images/play_footer.svg" alt="">
                <img src="./assets/images/next_footer.svg" alt="">
            </div>
            <div class="progreso">
                <span>0:00</span>
                <div class="barra_progreso"></div>
                <span>5:00</span>
            </div>
        </footer>

    </div>
</body>
</html>

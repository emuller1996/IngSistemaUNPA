<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>DASHMIN - Bootstrap Admin Template</title>
        <jsp:include page="inc/stilo.jsp"></jsp:include>
        </head>

        <body>
            <div class="container-xxl position-relative bg-white d-flex p-0">
                <!-- Spinner Start -->
                <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                    <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                </div>
                <!-- Spinner End -->


                <!-- Sign In Start -->
                <div class="container-fluid">
                    <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                        <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                            <div class="bg-light rounded-3 shadow  p-4 p-sm-5 my-4 mx-3 ">
                                <div class="d-flex align-items-center justify-content-between mb-3">
                                    <a href="index.jsp" class="btn btn-primary rounded-3">
                                        <i class="fas fa-arrow-left"></i>  
                                    </a>
                                    <h3 class=" text-primary text-center">Inicio de Session</h3>

                                </div>
                                <form action="login" method="POST" >
                                    <div class="form-floating mb-3">
                                        <input type="hidden" name="action" value="validarUsuario" >
                                        <input name="usuario_usuario_log" type="text" class="form-control" id="floatingInput" placeholder="alopez">
                                        <label for="floatingInput">Usuario</label>
                                    </div>
                                    <div class="form-floating mb-4">
                                        <input name="usuario_pass_log" type="password" class="form-control" id="floatingPassword" placeholder="Password">
                                        <label for="floatingPassword">Contraseña</label>
                                    </div>

                                    <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Validar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Sign In End -->
            </div>

        <jsp:include page="inc/scriptsadmin.jsp"></jsp:include>


    </body>

</html>
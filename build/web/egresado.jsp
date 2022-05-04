<%-- 
    Document   : egresado
    Created on : 16/03/2022, 10:18:46 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>- Egresado - </title>
        <jsp:include page="inc/estilo.jsp"></jsp:include>


        </head>
        <body>

            <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                    <span class="sr-only">Loading...</span>
                </div>
            </div>




        <jsp:include page="inc/navbar.jsp"></jsp:include>

            <!-- Contenido Start -->
            <div class="container-xxl py-5">
                <div class="container">
                    <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                        <h6 class="section-title bg-white text-center text-primary px-3">Egresado </h6>
                        <h3 class="mb-5">Consulta Egresado</h3>
                    </div>

                    <div class="bg-light p-4 rounded-3 shadow">
                        <div class="text-center mb-2">
                            Ingrese su numero de Cedula
                        </div>
                        <form>
                            <div class="form-floating mb-3">
                                <input type="number" class="form-control" id="floatingInput" placeholder="1.114.146">
                                <label for="floatingInput">Cedula de Cuidadania</label>
                            </div>
                            <div class="text-center">
                                <button class="btn btn-primary rounded-3 px-5 py-2 fw-bold fs-5">
                                    Consultar
                                </button>
                            </div>
                            
                                
                        </form>

                    </div>
                </div>
            </div>

            <!-- Contenido end -->







        <jsp:include page="inc/footer.jsp"></jsp:include>


            <!-- Back to Top -->
            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


        <jsp:include page="inc/scripts.jsp"></jsp:include>

    </body>
</html>

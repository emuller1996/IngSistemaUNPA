<%-- 
    Document   : libroverde
    Created on : 28/03/2022, 07:21:29 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libro Verde</title>
        <jsp:include page="inc/estilo.jsp"></jsp:include>
        </head>
        <body>
            <!-- Spinner Start -->
            <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                    <span class="sr-only">Loading...</span>
                </div>
            </div>
            <!-- Spinner End -->



        <jsp:include page="inc/navbar.jsp"></jsp:include>

            <div class="container-xxl py-5">

                <div class="container">
                    <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                        <h6 class="section-title bg-white text-center text-primary px-3">Libro Verde </h6>
                        <br>
                        <iframe class="w-100" style="height: 90vh;" src="documentos/libroverdeminciencias.pdf">
                            
                        </iframe>
                    </div>
                </div>

            </div>













        <jsp:include page="inc/footer.jsp"></jsp:include>


            <!-- Back to Top -->
            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


        <jsp:include page="inc/scripts.jsp"></jsp:include>
    </body>
</html>

<%-- 
    Document   : profesores
    Created on : 16/03/2022, 06:34:55 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> - Profesores - </title>
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

            <!-- Team Start -->
            <div class="container-xxl py-5">
                <div class="container">
                    <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                        <h6 class="section-title bg-white text-center text-primary px-3">Docentes del Programa</h6>
                        <h1 class="mb-5">Listado</h1>
                    </div>
                    <div class="row g-4">
                    <c:forEach var="profesor" items="${listaProfesores}">


                        <div class="col-lg-3 col-md-6 wow fadeInUp " data-wow-delay="0.1s">
                            <div class="team-item bg-light shadow">
                                <div class="overflow-hidden">
                                    <img class="img-fluid" src="img/team-1.jpg" alt="">
                                </div>
                                <div class="position-relative d-flex justify-content-center" style="margin-top: -23px;">
                                    <div class="bg-light d-flex justify-content-center pt-2 px-1">
                                        <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-facebook-f"></i></a>
                                        <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-twitter"></i></a>
                                        <a class="btn btn-sm-square btn-primary mx-1" href=""><i class="fab fa-instagram"></i></a>
                                    </div>
                                </div>
                                <div class="text-center p-4">
                                    <h5 class="mb-0">${profesor.nombreProfesor}</h5>
                                    <p class="fs-6 mb-0">${profesor.correoElectronico}</p>
                                    <p class="fs-6 mb-0">${profesor.fechaIngreso}</p>
                                    <small>${profesor.titulAcademico}</small>
                                </div>
                            </div>
                        </div>
                    </c:forEach>


                </div>
            </div>
        </div>
        <!-- Team End -->





        <jsp:include page="inc/footer.jsp"></jsp:include>


            <!-- Back to Top -->
            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>






        <jsp:include page="inc/scripts.jsp"></jsp:include>
    </body>
</html>

<%-- 
    Document   : eventos
    Created on : 18/03/2022, 10:11:37 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> - Eventos -</title>
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





            <!-- Categories Start -->
            <div class="container-xxl py-5 category">
                <div class="container">
                    <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                        <h6 class="section-title bg-white text-center text-primary px-3">Eventos</h6>


                    </div>
                    <div class="row g-3">

                    <c:forEach var="evento" items="${ListaEventosJSP}">
                        <div class="col-lg-12 ">
                            <div class="row g-3">
                                <div class="col-lg-12 col-md-12 wow zoomIn " data-wow-delay="0.1s">
                                    <a class="position-relative d-block overflow-hidden border border-primary" href="#">
                                        <img class="img-fluid" src="${evento.evento_imagen_url}" alt="">
                                        <div class="bg-white text-center position-absolute  bottom-0  end-0 py-2 px-3" style="margin: 1px;">
                                            <h5 class="m-0">${evento.evento_nombre}</h5>
                                            <p class="m-0">Lugar : ${evento.evento_lugar}</p>
                                            <p class="m-0"> Fecha : ${evento.evento_fecha}</p>
                                            <p class="m-0"> Hora : ${evento.evento_hora}</p>
                                            <p class="m-0"> Aforo : ${evento.evento_cantidad}</p>
                                            <p class="m-0"> Invitado : ${evento.evento_invitado}</p>
                                        </div>
                                    </a>
                                </div>                               
                            </div>
                        </div>
                    </c:forEach>




                </div>
            </div>
        </div>
        <!-- Categories Start -->










        <jsp:include page="inc/footer.jsp"></jsp:include>


            <!-- Back to Top -->
            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>


        <jsp:include page="inc/scripts.jsp"></jsp:include>
    </body>
</html>
